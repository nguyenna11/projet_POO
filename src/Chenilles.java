public class Chenilles extends Robot{
    private int numero ;
    private static final int CAPACITE_MAX = 2000; //static : une seule copie pour tous les drones final : valeur non modifiable 
    
    public Chenilles(Case position,int reservoir, double vitesse,int numero){
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
        if (nature.equals(NatureTerrain.FORET)==true){
            return 0.5*60;
        }
        if(nature.equals(NatureTerrain.EAU) ==true | nature.equals(NatureTerrain.ROCHE)==true){
            throw new IllegalArgumentException("Le robot chenille ne peut pas se rendre sur une case eau ou roche !");
        }
        return 60;
    }

    @Override
    public int deverserEau(){
        if (reservoir==0){
            throw new IllegalArgumentException("Le drone ne peut pas deverser d'eau car son réservoir est nulle !");
        }
        int v = 0;
        while (reservoir<100) {
             reservoir -= 100;
             v+=100;
        }
        return v;
    }


    @Override
    public void remplirReservoir(Carte carte) {
        for(Direction dir : Direction.values()){
            if (carte.voisinExiste(position, dir) && carte.getVoisin(position, dir).getNature() == NatureTerrain.EAU) {
            reservoir = CAPACITE_MAX;
            }
        }
    }
}
