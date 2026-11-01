public abstract class Evenement implements Comparable<Evenement>  {
    private long date;

    public Evenement(long date){
        this.setDate(date);
    }

    public long getDate(){
        return this.date;
    }
    public void setDate(long date){
        if (date<=0){
            throw new IllegalArgumentException("La date doit être strictement positif !");
        }
        this.date = date;
    }
    public abstract void execute(); //exécute les opérations associées

    @Override 
    public int compareTo(Evenement d){ //Compare les dates pour insérer dans le tableau événements
        if (this.date>d.date){
            return 1;
        }
        if (this.date<d.date){
            return -1;
        }
        return 0;
    }
    @Override 
    public boolean equals(Object other){//Compare si les dates sont égaux
        if(other instanceof Evenement){
            Evenement et = (Evenement) other;
            return et.date == this.date;
        }
        return false;
    }
}
