public abstract class Plant extends Organism{
    public Plant(Position position, World world){
        super(position, world);
    }

    public Plant(Plant plant){
        super(plant);
    }

    public abstract Plant clone();

    public void move(){
        if (this.ifReproduce()){
            this.power = this.power / 2;
            Plant newPlant = this.clone();
            newPlant.initParam();
            newPlant.position = world.getRandomNeighbourPosition(newPlant.position);
            world.addOrganism(newPlant);
        }
    }
}
