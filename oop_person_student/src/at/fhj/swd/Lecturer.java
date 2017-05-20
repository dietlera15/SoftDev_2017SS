package at.fhj.swd;

/**
 * Created by seuch on 5/13/17.
 */
public class Lecturer extends Person {
    private float salary;

    public Lecturer(String firstName, String lastName, float salary){
        super(firstName,lastName);
        this.salary = salary;
    }


    public float getSalary() {
        return salary;
    }
}
