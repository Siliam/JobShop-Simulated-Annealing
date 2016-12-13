package Test;

import Jobshop.Données;
import Jobshop.Operation;
import Jobshop.Recuit;
import Jobshop.Tour;
import Jobshop.TourManager;
import java.util.ArrayList;


public class test {

    public static void main(String[] args) throws Exception {
        Recuit recs = new Recuit();
        recs.Lancer(10000, 0.003);
        Tour best = recs.optimum;
        best.getMakespan();
    }
    
}
