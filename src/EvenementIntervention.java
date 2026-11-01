public class EvenementIntervention extends Evenement{
    private Robot robot;

    public EvenementIntervention(long date,Robot robot){
        super(date);
        this.robot =robot;
    }

    @Override 
    public void execute(){ // Manque condition si il y a un incendie mais je ne sais pas comment faire 
        switch (robot.getType()) {
            case DRONE:
                robot.deverserEau(robot.getReservoir());
                break;
        
            default:
                break;
        }
    }
    
}
