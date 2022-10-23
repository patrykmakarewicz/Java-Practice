import org.junit.*;
import static org.junit.Assert.assertEquals;

public class SoldierTest {
    @Test
    public void testPrivate(){
        Private one = new Private();
        assertEquals(1, one.military_rank);
        assertEquals(1, one.experience);
        assertEquals(one.military_rank * one.experience, one.strength);
    }
    @Test
    public void testCorporal(){
        Corporal one = new Corporal();
        assertEquals(2, one.military_rank);
        assertEquals(1, one.experience);
        assertEquals(one.military_rank * one.experience, one.strength);
    }

    @Test
    public void testCaptain(){
        Captain one = new Captain();
        assertEquals(3, one.military_rank);
        assertEquals(1, one.experience);
        assertEquals(one.military_rank * one.experience, one.strength);
    }

    @Test
    public void testMajor(){
        Major one = new Major();
        assertEquals(4, one.military_rank);
        assertEquals(1, one.experience);
        assertEquals(one.military_rank * one.experience, one.strength);
    }

}
