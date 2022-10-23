public class OrganismFactory {
    public Organism createOrganism(Species specie, Position position){
        Organism organism = null;
        switch(specie){
            case DANDELION:
                organism = new Dandelion(position);
                break;
            case GRASS:
                organism = new Grass(position);
                break;
            case SHEEP:
                organism = new Sheep(position);
                break;
            case TOADSTOOL:
                organism = new Toadstool(position);
                break;
            case WOLF:
                organism = new Wolf(position);
                break;
            case ALIEN:
                organism = new Alien(position);
                break;
        }
        organism.initParam();
        return organism;
    }
}
