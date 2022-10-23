import org.junit.Test;

import static org.junit.Assert.assertEquals;



public class OrganismTest {


    @Test
    public void testCreateOrganism() {
        World world = new World(10, 10);
        OrganismFactory factory = new OrganismFactory();
        Organism dandelion = factory.createOrganism(Species.DANDELION, world.getRandomFreePosition());
        world.addOrganism(dandelion);
        world.makeTurn();
        assertEquals(1, world.getOrganisms().size());
        assertEquals("Dandelion", world.getOrganisms().get(0).getClass().getSimpleName());
    }

    @Test
    public void testMoveAnimal(){
        World world = new World(10, 10);
        OrganismFactory factory = new OrganismFactory();
        Organism sheep = factory.createOrganism(Species.SHEEP, world.getRandomFreePosition());
        world.addOrganism(sheep);
        System.out.println(sheep.position.toString());
        sheep.move();
        System.out.println(sheep.position.toString());
    }

    @Test
    public void testPlantReproduce(){
        World world = new World(10, 10);
        OrganismFactory factory = new OrganismFactory();
        Organism grass = factory.createOrganism(Species.GRASS, world.getRandomFreePosition());
        world.addOrganism(grass);
        world.makeTurn();
        assertEquals(1, world.getOrganisms().size());
        world.makeTurn();
        assertEquals(1, world.getOrganisms().size());
        world.makeTurn();
        assertEquals(1, world.getOrganisms().size());
        world.makeTurn();
        assertEquals(2, world.getOrganisms().size());
    }


    @Test
    public void testConsequenceSheepWolf(){
        World world = new World(10, 10);
        OrganismFactory factory = new OrganismFactory();
        Organism sheep = factory.createOrganism(Species.SHEEP, new Position(1, 1));
        Organism wolf = factory.createOrganism(Species.WOLF, new Position(1, 1));
        world.addOrganism(sheep);
        world.addOrganism(wolf);
        world.makeTurnWithoutMove();
        assertEquals(2, world.getOrganisms().size());
        world.makeTurnWithoutMove();
        assertEquals(1, world.getOrganisms().size());
        assertEquals("Wolf", world.getOrganisms().get(0).getClass().getSimpleName());
    }

    @Test
    public void testConsequenceAnimalToadstool(){
        World world = new World(10, 10);
        OrganismFactory factory = new OrganismFactory();
        Organism wolf = factory.createOrganism(Species.WOLF, new Position(1, 1));
        Organism toadstool = factory.createOrganism(Species.TOADSTOOL, new Position(1, 1));
        world.addOrganism(toadstool);
        world.addOrganism(wolf);
        world.makeTurnWithoutMove();
        assertEquals(2, world.getOrganisms().size());
        world.makeTurnWithoutMove();
        assertEquals(1, world.getOrganisms().size());
        assertEquals("Toadstool", world.getOrganisms().get(0).getClass().getSimpleName());
    }

    @Test
    public void testConsequenceWolfGrass(){
        World world = new World(10, 10);
        OrganismFactory factory = new OrganismFactory();
        Organism wolf = factory.createOrganism(Species.WOLF, new Position(1, 1));
        Organism toadstool = factory.createOrganism(Species.GRASS, new Position(1, 1));
        world.addOrganism(toadstool);
        world.addOrganism(wolf);
        world.makeTurnWithoutMove();
        assertEquals(2, world.getOrganisms().size());
        world.makeTurnWithoutMove();
        assertEquals(2, world.getOrganisms().size());
    }

    @Test
    public void testAlien(){
        World world = new World(10, 10);
        OrganismFactory factory = new OrganismFactory();
        Organism wolf1 = factory.createOrganism(Species.WOLF, new Position(2, 1));
        Organism wolf2 = factory.createOrganism(Species.WOLF, new Position(9, 9));
        Organism alien = factory.createOrganism(Species.ALIEN, new Position(1, 1));
        world.addOrganism(alien);
        world.addOrganism(wolf1);
        world.addOrganism(wolf2);
        world.makeTurn();
        System.out.println(wolf1.toString());
        world.makeTurn();
        System.out.println(wolf1.toString());
        //assertEquals(2, world.getOrganisms().size());
        //world.makeTurnWithoutMove();
        //assertEquals(2, world.getOrganisms().size());
    }
}





