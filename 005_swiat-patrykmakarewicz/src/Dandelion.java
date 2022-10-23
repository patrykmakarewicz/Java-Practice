public class Dandelion extends Plant{
    public Dandelion(Position position, World world){
        super(position, world);
    }

    public Dandelion(Position position){
        super(position, null);
    }

    public Dandelion(Dandelion dandelion){
        super(dandelion);
    }

    @Override
    public void initParam(){
        this.setPower(0);
        this.setInitiative(0);
        this.setLiveLength(6);
        this.setPowerToReproduce(2);
    }

    @Override
    public Dandelion clone(){
        return new Dandelion(this);
    }
}
