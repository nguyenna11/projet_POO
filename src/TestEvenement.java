import java.awt.Color;
import java.util.PriorityQueue;

import gui.GUISimulator;
import gui.Simulable;

public class TestEvenement{
    public static void main(String[] args){
        GUISimulator gui = new GUISimulator(800, 60, Color.BLACK);
    }
}
class Simulateur implements Simulable {
    private GUISimulator gui;
    private long dateSimulation;
    private PriorityQueue<Evenement> evenements; //Liste d'événements dans l'ordre des dates


    public Simulateur(GUISimulator gui,long dateSimulation){
        this.gui = gui;
        gui.setSimulable(this);
        this.setDateSimulation(1); // Initialisation dateSimulation = 1 d'après l'annexe C 
        this.setEvenements();
    }

    public long getDateSimulation(){
        return this.dateSimulation;
    }
    public void setDateSimulation(long dateSimulation){
        if (dateSimulation<=0){
            throw new IllegalArgumentException("La date de simulation doit être strictement positif !");
        }
        this.dateSimulation = dateSimulation;
    }
    public void setEvenements(){
        this.evenements = new PriorityQueue<Evenement>();
    }
    public void ajouteEvenement(Evenement e){
        evenements.add(e);
    }

    public void incrementeDate(){ //Incrémente la date de simulation + 1 et on exécute les évenements ayant la date inférieur égale à cette date de simulation
        this.dateSimulation +=1;
        while (evenements.peek().getDate() <=dateSimulation){
            Evenement e = evenements.poll();
            e.execute();
        }
    }
    @Override 
    public void next(){
        incrementeDate();
    }
    @Override 
    public void restart(){ //Recommence à 0 avec une liste d'événement vide et une date de simulation = 1
        if (simulationTerminee()==true){
            this.dateSimulation = 1;
        }
        while(evenements.peek()!=null){
                evenements.poll();
            }
    }
    public boolean simulationTerminee(){ //Plus aucune événements dans le tableau evenements donc simulation terminee
        if (evenements.peek()==null && this.dateSimulation !=1){
            return true;
        }
        return false;
    } 

    
}
