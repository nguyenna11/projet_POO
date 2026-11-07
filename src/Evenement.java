public abstract class Evenement implements Comparable<Evenement>  {
    protected long date;

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
}
