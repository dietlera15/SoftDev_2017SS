package at.fhj.swd;

public class Question {
	private String question;
	private String[] answers;
	private int solutionIndex;
	
	public Question (String question, String[] answers, int solutionIndex) {
		this.question = question;
		this.answers = answers;
		this.solutionIndex = solutionIndex;
	}
	
	public String generateText() {
		String text = question;
		text += "\n";
		for(int i=0; i < answers.length; i++) {
			String curAnswer = (i + 1) + ". " + answers[i] + "   ";
			text += curAnswer;
			//String curAnswer = answers[i];
			//int questionNr = i + 1;
			//text += questionNr + ". " + curAnswer + "   ";
		}
		return text;
	}
	
	public boolean evaluate (int input) {
		/* int inputIndex = input -1;
		if (inputIndex == solutionIndex) {
			return true;
		} else {
			return false;
		} */
		return (input - 1) == solutionIndex;
	}
}
