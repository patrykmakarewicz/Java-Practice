public class Trader extends Worker{
    String effectiveness;
    int percentage;

    Trader(int id, String name, String surname, int age, int experience, Address address, String effectiveness, int percentage){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.experience = experience;
        this.address = address;
        this.effectiveness = effectiveness;
        this.percentage = percentage;
        if (effectiveness.equalsIgnoreCase("low")) this.value = experience * 60;
        if (effectiveness.equalsIgnoreCase("medium")) this.value = experience * 90;
        if (effectiveness.equalsIgnoreCase("high")) this.value = experience * 120;
    }
}
