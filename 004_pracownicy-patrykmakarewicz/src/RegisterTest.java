import org.junit.Test;

import static org.junit.Assert.assertEquals;



public class RegisterTest {
    @Test
    public void testAddSingleWorker(){
        Address address = new Address("Ulica", 4, 13, "Gdansk");
        Register register = new Register();
        register.addOfficeWorker("Patryk", "Nazwisko", 22, 5, address, 100);
        register.addManualWorker("Kacper", "Surname", 25, 10, address, 100);
        register.addTrader("Handlarz", "Najlepszy", 35, 10, address, "high", 15);
        register.addOfficeWorker("Patryk", "Nazwisko", 22, 5, address, 100);
        assertEquals(4, register.employees.size());
        assertEquals(0, register.employees.get(0).id);
        assertEquals(1, register.employees.get(1).id);
        assertEquals(2, register.employees.get(2).id);
        assertEquals(0, ((OfficeWorker) register.employees.get(0)).office_id);
        assertEquals(1, ((OfficeWorker) register.employees.get(3)).office_id);
    }

    @Test
    public void testAddEmployees(){
        Address address = new Address("Ulica", 4, 13, "Gdansk");
        Register register = new Register();
        OfficeWorker office = new OfficeWorker(0, "Imie", "Nazwisko", 22, 5, address, 0, 100);
        ManualWorker manual = new ManualWorker(0, "Imie", "nazwisko", 35, 10, address, 100);
        Trader trader = new Trader(2, "imie", "nazwisko", 44, 10, address, "low", 15);
        register.addEmployees(office, manual, trader);
        assertEquals(2, register.employees.size());
    }

    @Test
    public void testRemoveEmployee(){
        Address address = new Address("Ulica", 4, 13, "Gdansk");
        Register register = new Register();
        OfficeWorker office = new OfficeWorker(0, "Imie", "Nazwisko", 22, 5, address, 0, 100);
        ManualWorker manual = new ManualWorker(1, "Imie", "nazwisko", 35, 10, address, 100);
        register.addEmployees(office, manual);
        register.removeEmployee(0);
        assertEquals(1, register.employees.size());
        assertEquals(1, register.employees.get(0).id);
    }

    @Test
    public void testFilterByCity(){
        Address address1 = new Address("Ulica", 4, 13, "Gdansk");
        Address address2 = new Address("Ulica", 4, 13, "Gdynia");
        Register register = new Register();
        register.addOfficeWorker("Patryk", "Nazwisko", 22, 5, address1, 100);
        register.addOfficeWorker("Patryk", "Nazwisko", 22, 5, address2, 100);
        assertEquals(1, register.filterByCity("Gdansk").size());
        assertEquals("Gdansk", register.filterByCity("Gdansk").get(0).address.city);
    }

    @Test
    public void testValues(){
        Address address = new Address("Ulica", 4, 13, "Gdansk");
        Register register = new Register();
        register.addOfficeWorker("Patryk", "Nazwisko", 22, 5, address, 100);
        register.addManualWorker("Kacper", "Surname", 30, 15, address, 100);
        register.addTrader("Handlarz", "Najlepszy", 35, 10, address, "high", 15);
        assertEquals(500, register.employees.get(0).value);
        assertEquals(50, register.employees.get(1).value);
        assertEquals(1200, register.employees.get(2).value);
    }


}





