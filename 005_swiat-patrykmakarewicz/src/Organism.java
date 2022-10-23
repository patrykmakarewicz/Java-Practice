import java.util.*;

public abstract class Organism {
    public abstract void initParam();
    public abstract void move();

    protected int power;
    protected int initiative;
    protected Position position;
    protected int liveLength;
    protected int powerToReproduce;
    protected String sign;
    protected World world;

    public Organism(Organism organism){
        this.power = organism.power;
        this.initiative = organism.initiative;
        this.position = organism.position;
        this.liveLength = organism.liveLength;
        this.powerToReproduce = organism.powerToReproduce;
        this.world = organism.world;
    }

    public Organism (Position position, World world){
        this.position = position;
        this.world = world;
    }

    public Position getPosition(){
        return position;
    }

    public int getPower(){
        return power;
    }

    public void setPower(int power){
        this.power = power;
    }

    public int getInitiative(){
        return initiative;
    }

    public void setInitiative(int initiative){
        this.initiative = initiative;
    }

    public int getLiveLength(){
        return liveLength;
    }

    public void setLiveLength(int liveLength){
        this.liveLength = liveLength;
    }

    public void setPowerToReproduce(int powerToReproduce){
        this.powerToReproduce = powerToReproduce;
    }

    public void setWorld(World world) { this.world = world; }

    public boolean ifReproduce(){
        return this.power >= this.powerToReproduce;
    }

    public boolean consequences(){
        boolean state = false;
        for (Organism checkedOrganism : world.getOrganisms()){
            if (this.getPosition().ifEquals(checkedOrganism.getPosition()) && !this.equals(checkedOrganism)){
                if (this.getLiveLength() <= 0) return true;
                else if (this.getClass().getSimpleName().equals("Alien")) return false;
                else if (checkedOrganism.getClass().getSimpleName().equals("Alien")) state = false;
                else if (checkedOrganism.getClass().getSimpleName().equals("Toadstool")) return true;
                else if (this.getClass().getSimpleName().equals("Wolf") && checkedOrganism.getClass().getSimpleName().equals("Grass")) return false;
                else if (checkedOrganism.getClass().getSimpleName().equals("Wolf") && this.getClass().getSimpleName().equals("Grass")) return false;
                else if (this.getPower() < checkedOrganism.getPower() && this.getClass() != checkedOrganism.getClass()) return true;
                else state = false;
            } else state = false;
        }
        return state;
    }

    public boolean ifAlienAround(){
        for (int x = this.getPosition().getX() - 2; x <= this.getPosition().getX() + 2; x++){
            for (int y = this.getPosition().getY() - 2; y <= this.getPosition().getY() + 2; y++){
                for (Organism organism : world.getOrganisms()){
                    if (organism.getClass().getSimpleName().equals("Alien") && organism.getPosition().ifEquals(new Position(x, y))){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return this.getClass().getName() +
                "\npower: " + power +
                "\ninitiative: " + initiative +
                "\nposition: " + position.getX() + ", " + position.getY() +
                "\nlive length: " + liveLength +
                "\npower to reproduce: " + powerToReproduce;
    }
}


