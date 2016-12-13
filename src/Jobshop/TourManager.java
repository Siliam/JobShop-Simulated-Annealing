package Jobshop;

import Jobshop.Operation;
import java.util.ArrayList;

public class TourManager {

    private static ArrayList destinationOps = new ArrayList<Operation>();

    public static void addOperation(Operation O) {
        destinationOps.add(O);
    }
    
    public static Operation getOp(int index){
        return (Operation)destinationOps.get(index);
    }
    
    public static int nombreOperations(){
        return destinationOps.size();
    }
    
    public static void Vider(){
        destinationOps.clear();
    }
    
}