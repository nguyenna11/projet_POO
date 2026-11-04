import java.lang.Thread; //Suspend thread courant pendant le nombre de ms indiqué

public class EvenementIntervention extends Evenement{
    private Robot robot;
    private Incendie incendie;

    public EvenementIntervention(long date,Robot robot, Incendie incendie){
        super(date);
        this.robot =robot;
        this.incendie=incendie;
    }

    @Override 
    public void execute(){ // Manque condition si il y a un incendie mais je ne sais pas comment faire 
        if (robot.getPosition().equals(incendie.getIncendie())== true){
            switch (robot.getType()) {
                case DRONE:
                    robot.deverserEau(robot.getReservoir());
                    try{
                        Thread.sleep(30000);
                    }
                    catch (InterruptedException e){
                        Thread.currentThread().interrupt();
                    }
                    break;
                case ROUES :
                    int v = robot.getReservoir();
                    while(v!=0){
                        robot.deverserEau(100);
                        try{
                            Thread.sleep(5000);
                        }
                        catch (InterruptedException e){
                            Thread.currentThread().interrupt();
                        }
                        v -=100;
                    }
                    break;
                case CHENILLES :
                    int v1 = robot.getReservoir();
                    while(v1!=0){
                        robot.deverserEau(100);
                        try{
                            Thread.sleep(8000);
                        }
                        catch (InterruptedException e){
                            Thread.currentThread().interrupt();
                        }
                        v1 -=100;
                    }
                    break;
                case PATTES :
                    int v2 = robot.getReservoir();
                    while(v2!=0){
                        robot.deverserEau(10);
                        try{
                            Thread.sleep(1000);
                        }
                        catch (InterruptedException e){
                            Thread.currentThread().interrupt();
                        }
                        v2 -=10;
                    }
                    break;
                default:
                    System.out.println("Le type de robot n'existe pas !");
            }
        }
    } 
}
