public class Private extends Soldier{
    Private(){
        this.military_rank = 1;
        this.strength = this.military_rank * this.experience;
    }
}