package at.fhj.swd;

public class Main {

	public static void main(String[] args) {
		Person p1 = new Person ("John", "Doe");
		Person p2 = new Person ("Jane", "Doe");
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		
		Object o = p1;
		System.out.println(o.toString());
		
		Person p3 = new Person ("John", "Doe");
		Person p4 = new Person ("John", "Doe");
		if(p3.equals(p4)) {
			System.out.println("Sind gleich!");
		} else {
			System.out.println("Sind nicht gleich!");
		}
		
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
		System.out.println("Window is not shown!");
		
	}

}
