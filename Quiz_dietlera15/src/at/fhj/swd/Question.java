package at.fhj.swd;

public class Question {
	private String question;
	private String[] answer;
	private int correctIndex;
	private boolean formatCorrect;
	private String wrongFormatMsg = "";
	
	public Question(String line) {
		String[] splitted = line.split(";");
		formatCorrect = false;
		if (splitted.length == 3) {
			if(checkQuestion(splitted[1])) {
				question = splitted[0];
				answer = splitted[1].split("/");
				try {
					correctIndex = Integer.parseInt(splitted[2]);
					if (correctIndex >= 0 && correctIndex <= 3) {
						formatCorrect = true;
					} else {
						wrongFormatMsg = "Index out of Bounds.";
					}
				} catch (NumberFormatException error) {
					dietlera15.LogFileError(error);
					wrongFormatMsg = "Parsing of index failed.";
				}
			} else {
				wrongFormatMsg = "Not enough or too many answers for question.";
			}
		} else {
			wrongFormatMsg = "Question format is wrong (check CSV file).";
		}
	}

	private boolean checkQuestion(String answers) {
		String[] answer = answers.split("/");
		if (answer.length == 4) {
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
	
	public String getWrongFormatMsg() {
		return wrongFormatMsg;
	}
}
