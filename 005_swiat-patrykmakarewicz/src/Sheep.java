public class Sheep extends Animal{
    public Sheep(Position position, World world){
        super(position, world);
    }

    public Sheep(Position position){
        super(position, null);
    }

    public Sheep(Sheep sheep){
        super(sheep);
    }

    @Override
    public void initParam(){
        this.setPower(3);
        this.setInitiative(3);
        this.setLiveLength(10);
        this.setPowerToReproduce(6);
    }

    @Override
    public Sheep clone(){
        return new Sheep(this);
    }
}
