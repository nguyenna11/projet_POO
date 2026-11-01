public class EvenementDirection extends Evenement{
    private Robot robot;
    private Direction direction;

    public EvenementDirection(long date,Robot robot,Direction direction){
        super(date);
        this.robot = robot;
        this.direction = direction;
    }

    @Override 
    public void execute(){
        switch (direction) {
            case NORD:
                Case nord = new Case(robot.getPosition().getLigne()+1,robot.getPosition().getColonne(),robot.getPosition().getNature());
                robot.setPosition(nord);
                break;
            case SUD:
                Case sud = new Case(robot.getPosition().getLigne()-1,robot.getPosition().getColonne(),robot.getPosition().getNature());
                robot.setPosition(sud);
            case OUEST:
                Case ouest = new Case(robot.getPosition().getLigne(),robot.getPosition().getColonne()-1,robot.getPosition().getNature());
                robot.setPosition(ouest);
            case EST:
                Case est = new Case(robot.getPosition().getLigne(),robot.getPosition().getColonne()+1,robot.getPosition().getNature());
                robot.setPosition(est);
            default:
                System.out.println("Aucune direction indiquée");
                break;
        }
    }
}
