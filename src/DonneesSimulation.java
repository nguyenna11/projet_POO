import java.util.ArrayList;

public class DonneesSimulation {
    private Carte carte;
    private ArrayList<Incendie> incendies;
    private ArrayList<Robot> robots ;

    public DonneesSimulation(Carte carte){
        this.carte = carte;
        this.incendies = new ArrayList<Incendie>();
        this.robots = new ArrayList<Robot>();
    }

    public Carte getCarte(){
        return carte;
    }
    public ArrayList<Incendie> getIncendies(){
        return incendies;
    }
    public ArrayList<Robot> getRobots(){
        return robots;
    }
    
}
