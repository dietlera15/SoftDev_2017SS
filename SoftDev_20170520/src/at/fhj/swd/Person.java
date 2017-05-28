package at.fhj.swd;

public class Person {

	private String firstName;
	private String lastName;
	
	public Person (String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s", firstName, lastName);
	}
	
	@Override
	public boolean equals (Object obj) {
		if (!(obj instanceof Person)) {
			return false;
		}
		Person p = (Person) obj;
		return firstName.equals(p.getFirstName()) && lastName.equals(p.getLastName());
	}
}
