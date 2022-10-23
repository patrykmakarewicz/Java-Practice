public class Wolf extends Animal{
    public Wolf(Position position, World world){
        super(position, world);
    }

    public Wolf(Position position){
        super(position, null);
    }

    public Wolf(Wolf wolf){
        super(wolf);
    }

    @Override
    public void initParam(){
        this.setPower(6);
        this.setInitiative(5);
        this.setLiveLength(15);
        this.setPowerToReproduce(12);
    }

    @Override
    public Wolf clone(){
        return new Wolf(this);
    }
}
