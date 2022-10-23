public class Grass extends Plant{
    public Grass(Position position, World world){
        super(position, world);
    }

    public Grass(Position position){
        super(position, null);
    }

    public Grass(Grass grass){
        super(grass);
    }

    @Override
    public void initParam(){
        this.setPower(0);
        this.setInitiative(0);
        this.setLiveLength(6);
        this.setPowerToReproduce(3);
    }

    @Override
    public Grass clone(){
        return new Grass(this);
    }
}
