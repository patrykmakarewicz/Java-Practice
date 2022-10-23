public class Main {

    public static void main(String args[]) {

        World world = new World(10, 10);
        OrganismFactory factory = new OrganismFactory();

        int grassNumber = 3;
        int dandelionNumber = 3;
        int sheepNumber = 3;
        int toadstoolNumber = 3;
        int wolfNumber = 3;

        for (int i = 0; i < grassNumber; i++) {
            world.addOrganism(factory.createOrganism(Species.GRASS, world.getRandomFreePosition()));
        }

        for (int i = 0; i < dandelionNumber; i++){
            world.addOrganism(factory.createOrganism(Species.DANDELION, world.getRandomFreePosition()));
        }

        for (int i = 0; i< sheepNumber; i++){
            world.addOrganism(factory.createOrganism(Species.SHEEP, world.getRandomFreePosition()));
        }

        for (int i = 0; i < toadstoolNumber; i++){
            world.addOrganism(factory.createOrganism(Species.TOADSTOOL, world.getRandomFreePosition()));
        }

        for (int i = 0; i < wolfNumber; i++){
            world.addOrganism(factory.createOrganism(Species.WOLF, world.getRandomFreePosition()));
        }
        world.makeTurn();

        int turnCounter = 0;
        while(true){
            int grassCounter = 0;
            int dandelionCounter = 0;
            int sheepCounter = 0;
            int toadstoolCounter = 0;
            int wolfCounter = 0;
            world.makeTurn();
            for (Organism organism : world.getOrganisms()){
                if (organism.getClass().getSimpleName().equals("Grass")) grassCounter++;
                else if (organism.getClass().getSimpleName().equals("Dandelion")) dandelionCounter++;
                else if (organism.getClass().getSimpleName().equals("Sheep")) sheepCounter++;
                else if (organism.getClass().getSimpleName().equals("Toadstool")) toadstoolCounter++;
                else if (organism.getClass().getSimpleName().equals("Wolf")) wolfCounter++;
            }
            if (grassCounter == 0){
                System.out.println("Zabraklo trawy w turze: " + turnCounter);
                break;
            }
            else if (dandelionCounter == 0){
                System.out.println("Zabraklo mniszkow lekarskich w turze: " + turnCounter);
                break;
            }
            else if (sheepCounter == 0){
                System.out.println("Zabraklo owiec w turze: " + turnCounter);
                break;
            }
            else if (toadstoolCounter == 0){
                System.out.println("Zabraklo muchomorow w turze: " + turnCounter);
                break;
            }
            else if (wolfCounter == 0){
                System.out.println("Zabraklo wilkow w turze: " + turnCounter);
                break;
            }
            turnCounter++;
        }


    }
}
