import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;

public class General implements Observable{
    List<Soldier> army;
    int gold;
    private Set<Observer> observers = new HashSet<>();
    private String log;

    General(List<Soldier> army, int gold) {
        this.army = army;
        this.gold = gold;
    }

    @Override
    public void attach(Observer observer){
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer){
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(){
        observers.forEach(Observer::update);
    }

    public String getLog() {
        return log;
    }

    public void publish(String text){
        log = text;
        notifyObservers();
    }


    public void buy(int rank){
        if (rank == 1 && this.gold >= rank * 10){
            this.army.add(new Private());
            this.gold -= rank * 10;
            publish("General has just bought the private soldier for 10 gold!\n");
        }
        else if (rank == 2 && this.gold >= rank * 10){
            this.army.add(new Corporal());
            this.gold -= rank * 10;
            publish("General has just bought the corporal soldier for 20 gold!\n");
        }
        else if (rank == 3 && this.gold >= rank * 10){
            this.army.add(new Captain());
            this.gold -= rank * 10;
            publish("General has just bought the captain soldier for 30 gold!\n");
        }
        else if (rank == 4 && this.gold >= rank * 10){
            this.army.add(new Major());
            this.gold -= rank * 10;
            publish("General has just bought the major soldier for 40 gold!\n");
        }
    }

    public void addExperience(){
        int iterator = 0;
        for (Soldier soldier : this.army){
            if (soldier.isAlive){
                soldier.experience += 1;
            }
            if (soldier.experience == 5 && soldier.military_rank < 4){
                if (soldier instanceof Private){
                    this.army.set(iterator, new Corporal());
                }
                else if (soldier instanceof Corporal) {
                    this.army.set(iterator, new Captain());
                }
                else if (soldier instanceof Captain){
                    this.army.set(iterator, new Major());
                }
            }
            iterator += 1;
        }
    }

    public void train(){
        int gold_required = 0;
        for (Soldier soldier : this.army){
            gold_required += soldier.military_rank;
        }
        if (gold_required <= this.gold){
            this.gold -= gold_required;
            publish("Training has started!\n");
            this.addExperience();
        }
    }

    public void attack(General attacked_general){
        int strength = 0;
        int enemy_strength = 0;
        for (Soldier soldier : this.army) {
            if (soldier.isAlive) {
                strength += soldier.strength;
            }
        }
        for (Soldier soldier : attacked_general.army){
            if (soldier.isAlive){
                enemy_strength += soldier.strength;
            }
        }
        if (strength > enemy_strength){
            this.gold += 0.1 * attacked_general.gold;
            attacked_general.gold -= 0.1 * attacked_general.gold;
            for (Soldier soldier : attacked_general.army){
                soldier.experience -= 1;
                if (soldier.experience == 0){
                    soldier.isAlive = false;
                }
            }
            for (Soldier soldier : this.army) {
                soldier.experience += 1;
            }
        }
        else if (strength < enemy_strength) {
            this.gold -= 0.1 * attacked_general.gold;
            attacked_general.gold += 0.1 * attacked_general.gold;
            for (Soldier soldier : attacked_general.army) {
                soldier.experience += 1;
            }
            for (Soldier soldier : this.army) {
                soldier.experience -= 1;
                if (soldier.experience <= 0){
                    soldier.isAlive = false;
                }
            }
        }
        else {
            Random rand = new Random();
            int my_army_size = this.army.size();
            int enemy_army_size = attacked_general.army.size();
            int random1 = rand.nextInt(my_army_size);
            int random2 = rand.nextInt(enemy_army_size);
            this.army.remove(random1);
            attacked_general.army.remove(random2);
            }
    }


}
