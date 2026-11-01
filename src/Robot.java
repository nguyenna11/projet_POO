public abstract class Robot{
    private Case position; //Position du robot 
    private TypeRobot type; //Drone,Roues etc...
    private int reservoir;
    private double vitesse; // Vitesse selon la nature du terrain


    public Robot(Case position, TypeRobot type,double vitesse){
        this.setPosition(position);
        this.type=type;
        this.setReservoir();
        this.setVitesse(position.getNature());
    }

    public Case getPosition(){
        return this.position;
    }
    public TypeRobot getType(){
        return this.type;
    }
    public int getReservoir(){
        return this.reservoir;
    }
    public double getVitesse(){
        return this.vitesse;
    }

    public void setPosition(Case position){
         this.position = position;
    }
    public void setReservoir(){
        switch (type) {
            case DRONE:
                this.reservoir = 10000;
                break;
            case ROUES:
                this.reservoir = 5000;
            case CHENILLES:
                this.reservoir = 2000;
            case PATTES :
                this.reservoir = 1000000000;
            default:
                System.out.println("Le type de robot n'existe pas !");
        }
    }
    public abstract double setVitesse(NatureTerrain nature);
    public abstract void deverserEau(int volumeEau); //Déverser eau sur le terrain selon le type de robot
    public abstract void remplirReservoir(); //Réservoir limité pour chaque type de robots
}
