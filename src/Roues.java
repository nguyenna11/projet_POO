public class Roues extends Robot{
    private int numero ;
    private static final int CAPACITE_MAX = 5000; //static : une seule copie pour tous les drones final : valeur non modifiable 
    
    public Roues(Case position,int reservoir, double vitesse,int numero){
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
        if(nature.equals(NatureTerrain.HABITAT) ==false | nature.equals(NatureTerrain.TERRAIN_LIBRE)==false){
            throw new IllegalArgumentException("Le robot roues est bloqué il n'est pas situé dans un case habitat ou terrain libre !");
        }
        return 80;
    }

    @Override
    public void deverserEau(){
        if (reservoir==0){
            throw new IllegalArgumentException("Le drone ne peut pas deverser d'eau car son réservoir est nulle !");
        }
        reservoir = 0;
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
