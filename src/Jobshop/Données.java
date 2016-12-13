package Jobshop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/*
    Classe Données
    Se charge de charger le fichier de données (de type csv : comma-separated values)
    qui peut être édité par Excel ou un éditeur de texte normal.
    Elle transforme la matrice en une liste d'Opérations à ordonner
*/

public class Données {
    static public int nbMachines;
    static public int nbJobs;
    
    public static ArrayList<Operation> Ouvrir(String nomfichier)
    {
        try
        {
            ArrayList<Operation> Os = new ArrayList<Operation>();
            BufferedReader fichier = new BufferedReader(new FileReader(nomfichier));
            String ligne;
            int i = 1;
            int j = 1;

            while ((ligne = fichier.readLine()) != null) {
                String[] vals = ligne.trim().split(";");
                nbMachines = vals.length/2;

                for (int k = 0; k < nbMachines; k++)
                {
                    int m = Integer.parseInt(vals[2*k]);
                    int d = Integer.parseInt(vals[2*k + 1]);
                    Os.add(new Operation(i, j, m, d));
                    i++;

                }

                j++;
            }
            nbJobs = j;
            System.err.println(nbJobs + " // " + nbMachines + " // " + Os.size());
            
            return Os;
        }
        catch(Exception Ex)
        {
            System.err.println(Ex.getMessage());
            return null;
        }
    }
}
