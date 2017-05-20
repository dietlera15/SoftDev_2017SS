package at.fhj.swd;

/**
 * Created by seuch on 5/13/17.
 */
public class Main {
    public static void main(String[] args){

        Person p = new Person("Some", "Body");
        System.out.println(p.toHtml());

        Student s = new Student("Stue", "Dent", 1.2f);
        System.out.println(s.toHtml());
        System.out.println("Point Average: " + s.getPointAverage());
        
        
        Lecturer l = new Lecturer("Ludwig", "Lecturer", 3600.f);
        System.out.println(l.toHtml());
        System.out.println("Salary: " + l.getSalary());


        Person s2 = new Student("Jane","Student",1.1f);
        System.out.println(s2.toHtml());

        Person l2 = new Lecturer("Test", "Test2",3000f);





    }
}
