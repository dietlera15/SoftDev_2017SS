package at.fhj.swd;

/**
 * Created by seuch on 5/13/17.
 */
public class Person {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toHtml(){
        return String.format("<p> %s %s </p>", firstName, lastName);
    }
}
