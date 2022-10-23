public class Major extends Soldier{
    Major(){
        this.military_rank = 4;
        this.strength = this.military_rank * this.experience;
    }
}