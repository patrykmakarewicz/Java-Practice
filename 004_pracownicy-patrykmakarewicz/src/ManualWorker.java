public class ManualWorker extends Worker{
    int strength;

    ManualWorker(int id, String name, String surname, int age, int experience, Address address, int strength){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.experience = experience;
        this.address = address;
        this.strength = strength;
        this.value = experience * strength / age;
    }
}
