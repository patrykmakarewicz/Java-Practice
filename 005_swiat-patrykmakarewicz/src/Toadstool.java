public class Toadstool extends Plant{
    public Toadstool(Position position, World world){
        super(position, world);
    }

    public Toadstool(Position position){
        super(position, null);
    }

    public Toadstool(Toadstool toadstool){
        super(toadstool);
    }

    @Override
    public void initParam(){
        this.setPower(100);
        this.setInitiative(0);
        this.setLiveLength(10);
        this.setPowerToReproduce(5);
    }

    @Override
    public Toadstool clone(){
        return new Toadstool(this);
    }
}
