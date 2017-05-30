package at.fhj.swd;
/**
 * generates a question, the answers and the correct answer
 * @author andreas
 *
 */
public class Question {
	private String question;
	private String[] answer;
	private int correctIndex;
	private boolean formatCorrect;
	private String wrongFormatMsg = "";
	
	/**
	 * generates the question out of an String
	 * when the format is wrong an error message is generated
	 * @param line
	 */
	public Question(String line) {
		String[] splitted = line.split(";");
		formatCorrect = false;
		if (splitted.length == 3) {
			if(checkQuestion(splitted[1])) {
				question = splitted[0];
				answer = splitted[1].split("/");
				try {
					correctIndex = Integer.parseInt(splitted[2]);
					if (correctIndex >= 0 && correctIndex < answer.length) {
						formatCorrect = true;
					} else {
						wrongFormatMsg = "Correct index out of Bounds.";
					}
				} catch (NumberFormatException error) {
					dietlera15.LogFileError(error);
					wrongFormatMsg = "Parsing of index failed.";
				}
			} else {
				wrongFormatMsg = "Not enough answers for question.";
			}
		} else {
			wrongFormatMsg = "Question format is wrong (check CSV file).";
		}
	}

	/**
	 * checks if the string contains enough answers
	 * @param answers
	 * @return
	 */
	private boolean checkQuestion(String answers) {
		String[] answer = answers.split("/");
		if (answer.length > 1) {
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
