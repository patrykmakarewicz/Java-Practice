import java.util.Comparator;

public class InitiativeComparator implements Comparator<Organism>{
    @Override
    public int compare(Organism organism1, Organism organism2){
        return organism2.getInitiative() - organism1.getInitiative();
    }
}
