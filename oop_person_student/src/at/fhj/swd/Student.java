package at.fhj.swd;


public class Student extends Person{
    private float pointAverage;

    public Student(String firstName, String lastName, float pointAverage){
        super(firstName,lastName);
        this.pointAverage = pointAverage;
    }

    public float getPointAverage() {
        return pointAverage;
    }
}
