public class Captain extends Soldier{
    Captain(){
        this.military_rank = 3;
        this.strength = this.military_rank * this.experience;
    }
}