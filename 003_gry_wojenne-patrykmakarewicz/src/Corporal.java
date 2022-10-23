public class Corporal extends Soldier{
    Corporal(){
        this.military_rank = 2;
        this.strength = this.military_rank * this.experience;
    }
}