import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;


public class ComparatorTest {
    @Test
    public void testExperienceComparator(){
        Address address = new Address("Ulica", 4, 13, "Gdansk");
        Register register = new Register();
        register.addOfficeWorker("Patryk", "Nazwisko", 22, 10, address, 100);
        register.addManualWorker("Kacper", "Surname", 25, 5, address, 100);
        assertEquals(10, register.employees.get(0).experience);
        Collections.sort(register.employees, new ExperienceComparator());
        assertEquals(5, register.employees.get(0).experience);
    }

    @Test
    public void testAgeComparator(){
        Address address = new Address("Ulica", 4, 13, "Gdansk");
        Register register = new Register();
        register.addOfficeWorker("Patryk", "Nazwisko", 22, 10, address, 100);
        register.addManualWorker("Kacper", "Surname", 25, 5, address, 100);
        assertEquals(22, register.employees.get(0).age);
        Collections.sort(register.employees, new AgeComparator());
        assertEquals(25, register.employees.get(0).age);
    }

    @Test
    public void testSurnameComparator(){
        Address address = new Address("Ulica", 4, 13, "Gdansk");
        Register register = new Register();
        register.addOfficeWorker("Patryk", "Bbb", 22, 10, address, 100);
        register.addManualWorker("Kacper", "Aaa", 25, 5, address, 100);
        register.addManualWorker("Kacper", "Ccc", 25, 5, address, 100);
        Collections.sort(register.employees, new SurnameComparator());
        assertEquals("Aaa", register.employees.get(0).surname);
        assertEquals("Bbb", register.employees.get(1).surname);
        assertEquals("Ccc", register.employees.get(2).surname);
    }

}





