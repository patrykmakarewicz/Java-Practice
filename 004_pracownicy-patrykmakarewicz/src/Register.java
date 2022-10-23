import java.util.*;
import java.lang.Exception;

public class Register {
    ArrayList<Worker> employees;

    public Register(){
        this.employees = new ArrayList<>();
    }


    public void addOfficeWorker(String name, String surname, int age, int experience, Address address, int iq){
        int counter = 0;
        for (Worker worker : this.employees) {
            if (worker instanceof OfficeWorker) counter++;
        }
        this.employees.add(new OfficeWorker(this.employees.size(), name, surname, age, experience, address, counter, iq));

    }

    public void addManualWorker(String name, String surname, int age, int experience, Address address, int strength){
        this.employees.add(new ManualWorker(this.employees.size(), name, surname, age, experience, address, strength));
    }

    public void addTrader(String name, String surname, int age, int experience, Address address, String effectiveness, int percentage){
        this.employees.add(new Trader(this.employees.size(), name, surname, age, experience, address, effectiveness, percentage));
    }

    public void addEmployees(Worker... workers){
        label: for (Worker new_worker : workers){
            for (Worker worker : this.employees){
                if (worker.id == new_worker.id){
                    continue label;
                }
                if (new_worker instanceof OfficeWorker){
                    if (((OfficeWorker) new_worker).office_id == ((OfficeWorker) worker).office_id) {
                        continue label;
                    }
                }
            }
            this.employees.add(new_worker);
        }
    }

    public void removeEmployee(int id){
        this.employees.removeIf(employee -> employee.id == id);
    }

    public ArrayList<Worker> filterByCity(String city){
        ArrayList<Worker> filtered_employees = new ArrayList<>();
        for (Worker worker : this.employees){
            if (worker.address.city == city){
                filtered_employees.add(worker);
            }
        }
        return filtered_employees;
    }


}
