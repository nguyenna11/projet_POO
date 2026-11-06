public class Pattes extends Robot {
    private int numero ;
    
    public Pattes(Case position,int reservoir, double vitesse,int numero){
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
        if (nature.equals(NatureTerrain.ROCHE)==true){
            return 10;
        }
        if(nature.equals(NatureTerrain.EAU) ==true){
            throw new IllegalArgumentException("Le robot chenille ne peut pas se rendre sur une case eau  !");
        }
        return 30;
    }

    @Override
    public void deverserEau(){
        if (reservoir==0){
            throw new IllegalArgumentException("Le drone ne peut pas deverser d'eau car son réservoir est nulle !");
        }
    }


    @Override
    public void remplirReservoir(Carte carte) {
    }
}

