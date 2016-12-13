package Jobshop;
import java.util.ArrayList;

/*
    La classe responsable de générer la simulation du recuit simulé
    Les étapes de l'algorithme sont expliqués 
*/

public class Recuit {
    public Tour optimum;
    
    /*
        Probabilité d'accepter une nouvelle solution qui est f(température)
    */
    public static double acceptanceProbability(int energy, int newEnergy, double temperature) {
        /*
            Si la nouvelle solution est ) 100% meilleure que celle qu'on a,
            on la garde à 100%
        */
        if (newEnergy < energy) {
            return 1.0;
        }
        
        /*
            Si celle-là est pire, on renvoie une probabilité
            qui est inférieure à 100% selon la température (cette probabilité
            est inversement proportionnelle à la température actuelle)
        */
        return Math.exp((energy - newEnergy) / temperature);
    }
    
    /*
        On charge les données depuis le fichier précisé
        et on les met dans une liste
    */
    public void Alimenter(String nomFichier)
    {
        ArrayList<Operation> ol = Données.Ouvrir(nomFichier);
        for(Operation o : ol)
            TourManager.addOperation(o);
    }

    /*
        On lance la simulation
    */
    public void Lancer(int temp, double tauxRefroidissement) {
        /*
            On commence avec une solution vide et une température temp
        */
        Tour solutionActuelle = new Tour();
        solutionActuelle.genererSolutionInitiale();
        
        System.out.println("Solution initiale : " + solutionActuelle.getMakespan());

        // Set as current best
        Tour best = new Tour(solutionActuelle.getTour());
        
        /*
            On répète la sélection des solutions jusqu'au refroidissement total 
            du système, soit température = 1
        */
        
        while (temp > 1) {
            /*
                On génère une solution voisine à partir de la solution actuelle,
                en échangeant l'ordre de deux opérations.
                Si la nouvelle configuration est impossible, 
                elle aura un makespan = 999999, soit une très faible probabilité 
                de la sélectionner.
            */
            Tour solutionVoisine = new Tour(solutionActuelle.getTour());
            int tourPos1, tourPos2;
            Operation opSwap1, opSwap2;
            
            /*
                On échange deux noeuds sélectionnées aléatoirement de notre
                solution actuelle.
                On continue à basculer les noeuds jusqu'à trouver une solution
                valide (un chemin entre les noeuds qui respect la précédence des
                tâches)
            */
            do
            {
                tourPos1 = (int) (solutionVoisine.tailleSolution() * Math.random());
                tourPos2 = (int) (solutionVoisine.tailleSolution() * Math.random());

                opSwap1 = solutionVoisine.getOperation(tourPos1);
                opSwap2 = solutionVoisine.getOperation(tourPos2);

                solutionVoisine.setOperation(tourPos2, opSwap1);
                solutionVoisine.setOperation(tourPos1, opSwap2);
            }
            while(solutionVoisine.getMakespan() == 999999 && 
                  best.getMakespan() == 999999);
            
            /*
                On calcule niveau "l'énergie" de chaque solution, soit
                la distance entre les deux "départ" et "arrivée" qui est aussi
                le makespan qu'on cherche à minimiser.
            */
            int energieActuelle = solutionActuelle.getMakespan();
            int energieVoisine  = solutionVoisine.getMakespan();

            /*
                A partir des deux niveaux d'énergie et la température on calcule
                la probabilité avec laquelle on accepte la nouvelle solution générée
                (qui diminue avec le temps)
            */
            if (acceptanceProbability(energieActuelle, energieVoisine, temp) > Math.random()) {
                solutionActuelle = new Tour(solutionVoisine.getTour());
            }

            /*
                Si on choisit de garder la nouvelle solution voisine, on vérifie
                si elle est meilleure que la meilleure solution qu'on a trouvé 
                depuis le début du programme
            */
            if (solutionActuelle.getMakespan()< best.getMakespan()) {
                System.out.print("Nouvelle solution trouvée : " + solutionActuelle.getMakespan());
                System.out.println("  à la température " + temp);
                best = new Tour(solutionActuelle.getTour());
            }
            
            /*
                On refroidit le système avec un taux qui est 
            */
            temp *= 1-tauxRefroidissement;
        }

        /*
            Une fois le système est complétement froid (température = 1),
            on affiche la solution retenue ainsi que son makespan
        */
        System.out.println("Makespan de la solution retenue : " + best.getMakespan());
        System.out.println("Tour: " + best);
        
        optimum = best;
    }
}

