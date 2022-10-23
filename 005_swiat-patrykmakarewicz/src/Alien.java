public class Alien extends Organism{
    public Alien(Position position, World world){
        super(position, world);
    }

    public Alien(Animal animal){
        super(animal);
    }

    public Alien(Position position) { super(position, null); }

    @Override
    public void initParam(){
        this.setPower(0);
        this.setInitiative(10);
        this.setLiveLength(15);
        this.setPowerToReproduce(10);
    }

    public void move() {
        this.position = world.getRandomNeighbourPosition(this.position);
    }
}