package at.fhj.swd;

public class Question {
	private String question;
	private String[] answer;
	private int correctIndex;
	private boolean formatCorrect;
	
	public Question(String line) {
		String[] splitted = line.split(";");
		formatCorrect = false;
		if (splitted.length == 3) {
			if(checkQuestion(splitted[1])) {
				question = splitted[0];
				answer = splitted[1].split("/");
				correctIndex = Integer.parseInt(splitted[2]);
				formatCorrect = true;
			} else {
				System.out.println("NOPE");
			}
		}
	}

	private boolean checkQuestion(String answers) {
		String[] answer = answers.split("/");
		if (answer.length == 3) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getQuestion() {
		return question;
	}

	public String[] getAnswer() {
		return answer;
	}

	public int getCorrectIndex() {
		return correctIndex;
	}
	
	public boolean getFormatCorrect() {
		return formatCorrect;
	}
}
