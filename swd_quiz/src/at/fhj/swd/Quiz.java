package at.fhj.swd;

import javax.swing.JOptionPane;

public class Quiz {
	private Question[] questions;
	private int numCorrect;
	
	public Quiz(Question[] questions) {
		this.questions = questions;
		numCorrect = 0;
	}
	
	public void start(){
		for (int i = 0; i < questions.length; i++) {
			Question curQuestions = questions[i];
			String text = JOptionPane.showInputDialog(curQuestions.generateText());
			int input = Integer.parseInt(text);
			if (curQuestions.evaluate(input)){
				numCorrect++;
				JOptionPane.showMessageDialog(null, "Richtig");
			} else {
				JOptionPane.showMessageDialog(null, "Depp");
			}
		}
	}

	public int getNumCorrect() {
		return numCorrect;
	}

	public Question[] getQuestions() {
		return questions;
	}
	
}
