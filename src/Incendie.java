public class Incendie {
    private Case caseIncendie; //Case où il y a un incendie
    private int intensite; //Volume d'eau nécessaire pour éteindre le feu
    public Incendie(Case caseIncendie, int intensite){
        this.caseIncendie = caseIncendie;
        this.setIntensite(intensite);
    }

    public Case getIncendie(){
        return this.caseIncendie;
    }
    public int getintensite(){
        return intensite;
    }
    public void setIntensite(int intensite){
        if (intensite<0){
            throw new IllegalArgumentException("Il faut de l'eau pour éteindre la case !");
        }
        this.intensite=intensite;
    }
}
