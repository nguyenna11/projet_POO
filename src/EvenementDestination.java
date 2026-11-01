public class EvenementDestination extends Evenement {
    private Robot robot;
    private Case destination;

    public EvenementDestination(long date,Robot robot, Case destination){
        super(date);
        this.robot = robot;
        this.destination = destination;
    }

    @Override 
    public void execute(){ //Déplacement case destination
        robot.setPosition(destination);
    }
}
