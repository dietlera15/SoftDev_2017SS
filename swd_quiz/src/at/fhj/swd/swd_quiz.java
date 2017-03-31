package at.fhj.swd;

import javax.swing.JOptionPane;

public class swd_quiz {

	public static void main(String[] args) {
		Question q1 = new Question("Welcher Tag ist heute?", new String[]{"Freitag", "Samstag", "Sonntag"}, 0);
		Question q2 = new Question("Wo befinden wir uns gerade?", new String[]{"Graz", "Wien", "Kapfenberg"}, 2);
		Question q3 = new Question("Wo befinden wir uns gerade?", new String[]{"Graz", "Wien", "Kapfenberg"}, 2);
		
		Quiz quiz = new Quiz(new Question[]{q1, q2, q3});
		quiz.start();
		
		//String result = "Es wurden " + quiz.getNumCorrect() + " Fragen richtig beantwortet!";
		String result = String.format("Es wurden %d von %d Fragen richtig beantwotet", quiz.getNumCorrect(), quiz.getQuestions().length);
		JOptionPane.showMessageDialog(null, result);
	}

}
