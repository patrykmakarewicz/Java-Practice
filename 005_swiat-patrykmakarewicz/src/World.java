import java.util.ArrayList;
import java.util.*;


public class World {
    private int worldX;
    private int worldY;
    private ArrayList<Organism> organisms;
    private ArrayList<Organism> newOrganisms;
    private int turn;
    public Iterator<Organism> organismIterator;

    public World(int worldX, int worldY) {
        this.worldX = worldX;
        this.worldY = worldY;
        this.organisms = new ArrayList<>();
        this.newOrganisms = new ArrayList<>();
        this.turn = 0;
    }


    public ArrayList<Organism> getOrganisms() {
        return organisms;
    }


    public void addOrganism(Organism organism) {
        if (isOnBoard(organism.position) && getOrganismOnPosition(organism.position) == null) {
            organism.setWorld(this);
            this.newOrganisms.add(organism);
        } else {
            organism.position = getRandomFreePosition();
            addOrganism(organism);
        }
    }


    public Organism getOrganismOnPosition(Position position) {
        ArrayList<Organism> allOrganisms = new ArrayList<>();
        allOrganisms.addAll(this.organisms);
        allOrganisms.addAll(this.newOrganisms);
        for (Organism organism : allOrganisms) {
            if (organism.getPosition().equals(position)) {
                return organism;
            }
        }
        return null;
    }


    public Position getRandomFreePosition() {
        ArrayList<Position> freePositions = new ArrayList<>();
        for (int x = 0; x < this.worldX; x++) {
            for (int y = 0; y < this.worldY; y++) {
                if (getOrganismOnPosition(new Position(x, y)) == null) {
                    freePositions.add(new Position(x, y));
                }
            }
        }
        return freePositions.get((int) (Math.random() * freePositions.size()));
    }

    public boolean isOnBoard(Position position) {
        return position.getX() >= 0 && position.getY() >= 0 && position.getX() < this.worldX && position.getY() < this.worldY;
    }


    public Position getRandomNeighbourPosition(Position position) {
        int[] intArray = {-1, 0, 1};
        int x = position.getX();
        int y = position.getY();
        x += intArray[new Random().nextInt(intArray.length)];
        y += intArray[new Random().nextInt(intArray.length)];
        if (isOnBoard(new Position(x, y)) && !new Position(x, y).equals(position)) {
            return new Position(x, y);
        } else return getRandomNeighbourPosition(position);
    }


    public void makeTurn() {
        if (Math.random() <= 0.02){
            Alien alien = new Alien(this.getRandomFreePosition(), this);
            this.addOrganism(alien);
        }
        this.organisms.sort(new InitiativeComparator());
        this.organismIterator = this.organisms.iterator();
        while (organismIterator.hasNext()) {
            Organism organism = organismIterator.next();
            if (organism.getClass().getSimpleName().equals("Alien") && Math.random() <= 0.3){
                organismIterator.remove();
                continue;
            }
            if (!organism.ifAlienAround()) {
                organism.setPower(organism.power + 1);
                organism.setLiveLength(organism.liveLength - 1);
                organism.move();
                if (organism.consequences()) {
                    organismIterator.remove();
                }
            }
        }
        this.organisms.addAll(this.newOrganisms);
        this.newOrganisms.clear();
        this.organisms.sort(new InitiativeComparator());
        this.turn += 1;
    }


    public void makeTurnWithoutMove() {
        this.organisms.sort(new InitiativeComparator());
        this.organismIterator = this.organisms.iterator();
        while (organismIterator.hasNext()){
            Organism organism = organismIterator.next();
            organism.setPower(organism.power + 1);
            organism.setLiveLength(organism.liveLength - 1);
            if (organism.consequences()){
                organismIterator.remove();
            }
        }
        this.organisms.addAll(this.newOrganisms);
        this.newOrganisms.clear();
        this.organisms.sort(new InitiativeComparator());
        this.turn += 1;
    }
}
