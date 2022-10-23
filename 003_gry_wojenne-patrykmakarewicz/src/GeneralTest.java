import org.junit.*;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;


public class GeneralTest {
    @Test
    public void testAddArmy(){
        Private soldier1 = new Private();
        Major soldier2 = new Major();

        List<Soldier> army = new ArrayList<Soldier>();
        army.add(soldier1);
        army.add(soldier2);
        General general = new General(army, 100);
        general.buy(1);
        assertEquals(3, general.army.size());
        assertEquals(90, general.gold);
    }

    @Test
    public void testTrain(){
        Private soldier1 = new Private();
        Corporal soldier2 = new Corporal();

        List<Soldier> army = new ArrayList<Soldier>();
        army.add(soldier1);
        army.add(soldier2);
        General general = new General(army, 100);
        general.train();
        general.train();
        general.train();
        general.train();
        assertEquals(1, general.army.get(0).experience);
        assertEquals(2, general.army.get(0).military_rank);
        assertEquals(1, general.army.get(1).experience);
        assertEquals(3, general.army.get(1).military_rank);
        assertEquals(88, general.gold);
    }

    @Test
    public void testAttack(){
        Private private1 = new Private();
        Private private2 = new Private();
        Major major1 = new Major();
        Major major2 = new Major();
        List<Soldier> army1 = new ArrayList<Soldier>();
        List<Soldier> army2 = new ArrayList<Soldier>();
        army1.add(private1);
        army1.add(private2);
        army2.add(major1);
        army2.add(major2);
        General general1 = new General(army1, 100);
        General general2 = new General(army2, 100);
        general1.attack(general2);
        assertEquals(110, general2.gold);
        assertEquals(90, general1. gold);
        assertEquals(false, general1.army.get(0).isAlive);
        assertEquals(2, general2.army.get(0).experience);
    }
}


