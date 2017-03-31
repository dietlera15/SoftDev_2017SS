package at.fhj.swd;

public class swd_quiz {

	public static void main(String[] args) {
		Question question = new Question("Welcher Tag ist heute?", new String[]{"Freitag", "Samstag", "Sonntag"}, 0);
		
		System.out.println(question.generateText());
		System.out.println(question.evaluate(1));
		System.out.println(question.evaluate(2));
	}

}
