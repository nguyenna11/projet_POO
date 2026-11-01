public class EvenementRemplir extends Evenement{
    private Robot robot;
    
    public EvenementRemplir(long date,Robot robot){
        super(date);
        this.robot = robot;
    }

    @Override 
    public void execute(){
        if (robot.getPosition().getNature() == NatureTerrain.EAU){
            robot.remplirReservoir();
        }
    }
}
