public abstract class Animal extends Organism{
    public Animal(Position position, World world){
        super(position, world);
    }

    public Animal(Animal animal){
        super(animal);
    }

    public abstract Animal clone();


    public void move() {
        this.position = world.getRandomNeighbourPosition(this.position);
        for (Organism checkedOrganism : world.getOrganisms()) {
            if (this.getPosition().ifEquals(checkedOrganism.getPosition()) && this.getClass().equals(checkedOrganism.getClass())) {
                if (this.ifReproduce()){
                    this.power = this.power / 2;
                    Animal newAnimal = this.clone();
                    newAnimal.initParam();
                    newAnimal.position = world.getRandomNeighbourPosition(newAnimal.position);
                    world.addOrganism(newAnimal);
                }
                else if(checkedOrganism.ifReproduce()){
                    checkedOrganism.power = checkedOrganism.power / 2;
                    Animal newAnimal = (Animal)((Animal)checkedOrganism).clone();
                    newAnimal.initParam();
                    newAnimal.position = world.getRandomNeighbourPosition(newAnimal.position);
                    world.addOrganism(newAnimal);
                }
            }
            }
        }
    }
