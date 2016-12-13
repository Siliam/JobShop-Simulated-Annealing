package Jobshop;

import static java.lang.Double.max;

public class Operation {
    public int id, job, machine, durée;
    static int M = 1000000;

    public Operation(int id, int job, int machine, int durée) {
        this.id = id;
        this.job = job;
        this.machine = machine;
        this.durée = durée;
    }

    public int getId() {
        return id;
    }

    public int getJob() {
        return job;
    }

    public int getMachine() {
        return machine;
    }

    public int getDurée() {
        return durée;
    }
    
    public int distaTo(Operation o){
        if(this.job == o.job && this.machine == o.machine)
                return M;
        else if(this.job == o.job && this.machine != o.machine || this.job != o.job && this.machine == o.machine)
                return this.durée + o.durée;
        else
            return Integer.max(this.durée, o.durée);
    }
    
    @Override
    public String toString(){
        return "O"+ id + " : J" + job + " @ M" + machine + " [" + durée + "]";
    }

}
