class Drone extends Robot{
    private int numero ;
    private static final int CAPACITE_MAX = 10000; //static : une seule copie pour tous les drones final : valeur non modifiable 
    
    public Drone(Case position,int reservoir, double vitesse,int numero){
        super(position,reservoir,vitesse);
        this.setNumero(numero);
    }

    public void setNumero(int numero){
        if (numero<=0){
            throw new IllegalArgumentException("Le numero doit être strictement positif !");
        }
        this.numero = numero;
    }


    @Override
    public double setVitesse(NatureTerrain nature){ //Implémenter la notion de vitesse ne sait pas comment faire
        vitesse = 100;
        return 100;
    }

    @Override
    public int deverserEau(){
        if (reservoir==0){
            throw new IllegalArgumentException("Le drone ne peut pas deverser d'eau car son réservoir est nulle !");
        }
        int v = reservoir;
        reservoir = 0;
        return  v;
    }


    @Override
    public void remplirReservoir(Carte carte) {
        if (reservoir != CAPACITE_MAX){
        reservoir=CAPACITE_MAX;
        }
    }
}   

