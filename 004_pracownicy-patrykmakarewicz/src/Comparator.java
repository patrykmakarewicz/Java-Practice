import java.util.Comparator;

class ExperienceComparator implements Comparator<Worker> {
    public int compare (Worker a, Worker b){
        return a.experience - b.experience;
    }
}

class AgeComparator implements Comparator<Worker>{
    public int compare (Worker a, Worker b){
        return b.age - a.age;
    }
}

class SurnameComparator implements Comparator<Worker>{
    public int compare (Worker a, Worker b){
        return a.surname.compareTo(b.surname);
    }
}