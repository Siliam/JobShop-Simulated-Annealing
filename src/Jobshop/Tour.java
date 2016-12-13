package Jobshop;

import java.util.ArrayList;
import java.util.Collections;

/*
    Classe Tour
    Encode l'ordre d'exécution des opérations = couple (job,machine)
*/

public class Tour{

    private ArrayList<Operation> tour = new ArrayList<Operation>();
    private int distance = 0;
    public int[][][] temps = new int[Données.nbJobs][Données.nbMachines][2];
    
    // Constructeurs 
    public Tour(){
        for (int i = 0; i < TourManager.nombreOperations(); i++) {
            tour.add(null);
        }
    }
    public Tour(ArrayList tour){
        this.tour = (ArrayList) tour.clone();
    }

    // Comment générer une solution initiale aléatoire pour commencer
    public void genererSolutionInitiale() {
        for (int index = 0; index < TourManager.nombreOperations(); index++) {
          setOperation(index, TourManager.getOp(index));
        }
        //Collections.shuffle(tour);
    }
    
    // Méthodes d'accessibilité
    public Operation getOperation(int tourPosition) {
        return (Operation)tour.get(tourPosition);
    }

    // Sets a city in a certain position within a tour
    public void setOperation(int tourPosition, Operation o) {
        tour.set(tourPosition, o);
        distance = 0;
    }
    
    // Calcul du makespan correspondant au tour actuel
    /*
        Partie la plus importante : permet de qualifier une solution pour savoir
        si elle est sera prise ou non
    */
    public int getMakespan(){
        int[] machines = new int[Données.nbMachines + 1]; // 1..n
        int[] jobs = new int[Données.nbJobs + 1]; // 1..n
        
        int ms = 0; // makespan
        
        // vérifier le respect des précédences 
        ArrayList<Integer> jobsEvaluées = new ArrayList<Integer>();
        for(int i = 0; i < tour.size(); i++)
        {
            Operation o = tour.get(i);
            
            if(jobsEvaluées.indexOf(o.job) != -1)
                continue;
            jobsEvaluées.add(o.job);
            int id = o.id;
            for(int j = i+1; j < tour.size(); j++)
            {
                Operation p = tour.get(j);
                if(p.job == o.job)
                {
                    if(id < p.id)  id = p.id;
                    else  return 999999;
                }
            }
        }
        
        if (distance == 0) {
            int tourDistance = tour.get(0).durée;
            
            for(Operation o : tour)
            {
                int m = o.machine;
                int j = o.job;
                int d = o.durée;
                
                if(machines[m] < jobs[j])
                {
                    //System.out.println("Retard de " + (jobs[j] - machines[m]) + "s sur la machine " + m);
                    machines[m] = jobs[j];
                }
                temps[j-1][m-1][0] = machines[m];
                temps[j-1][m-1][1] = machines[m] + d;
                jobs[j] = (machines[m] += d);
                ms = Integer.max(ms, machines[m]);
            }
            distance = ms;
        }
        return distance;
    }
    
    public int tailleSolution() {
        return tour.size();
    }
    public ArrayList getTour(){
        return tour;
    }
    @Override
    public String toString() {
        String geneString = " | ";
        for (int i = 0; i < tailleSolution(); i++) {
            geneString += getOperation(i)+"|";
        }
        return geneString;
    }
}