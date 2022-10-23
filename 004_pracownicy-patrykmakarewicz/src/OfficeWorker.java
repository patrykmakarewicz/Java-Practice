public class OfficeWorker extends Worker{
    int office_id;
    int iq;

    OfficeWorker(int id, String name, String surname, int age, int experience, Address address, int office_id, int iq){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.experience = experience;
        this.address = address;
        this.office_id = office_id;
        this.iq = iq;
        this.value = experience * iq;
    }
}
