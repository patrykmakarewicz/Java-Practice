public class Address {
    String street_name;
    int building_number;
    int local_number;
    String city;


    Address(String street_name, int building_number, int local_number, String city){
        this.street_name = street_name;
        this.building_number = building_number;
        this.local_number = local_number;
        this.city = city;
    }
}