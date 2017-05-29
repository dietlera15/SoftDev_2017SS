package at.fhj.swd;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class QuestionReader {
	private ArrayList<Question> Question = new ArrayList<Question>();
	
	public QuestionReader (String path) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(path));
			int index = 1;
			String header[] = reader.readLine().split(";");
			if(checkCSV(header)) {
				index++;
				String line = null;
				while ((line = reader.readLine()) != null) {
					if (line.startsWith("#")) {
						dietlera15.LogFileMessage("Comment in line " + index + ": " + line);
					} else {
						Question.add(new Question(line));
						int lastIndex = Question.size() - 1;
						if (!Question.get(lastIndex).getFormatCorrect()) {
							dietlera15.LogFileMessage("Corrupted values in line " + index + ": " + Question.get(lastIndex).getWrongFormatMsg());
						}
					}
					index++;
				}
				System.out.println(dietlera15.actualDateTimeForm() + "Reading file successfull.");
			} else {
				System.out.println(dietlera15.actualDateTimeForm() + "The format of the given CSV-file is wrong.");
				dietlera15.LogFileMessage("Wrong format of CSV-file (Header not correct).");
			}
		} catch (IOException error) {
			System.out.println(dietlera15.actualDateTimeForm() + "Error reading file. More details in log file.");
			dietlera15.LogFileMessage("Error reading CSV file.");
			dietlera15.LogFileError(error);
		} finally {
			if (reader != null) {
				try {
					reader.close();
					System.out.println(dietlera15.actualDateTimeForm() + "Read file finished.");
				} catch (Exception error) {
					dietlera15.LogFileError(error);
				}
			}
		}
	}
	
	private boolean checkCSV(String[] header){
		boolean[] col = new boolean[] {false, false, false};
		if(header.length != 3) return false;
		if(header[0].equals("Questions")) col[0] = true;
		if(header[1].equals("Answers")) col[1] = true;
		if(header[2].equals("CorrectIndex")) col[2] = true;
		return (col[0] && col[1] && col[2]);
	}

	public ArrayList<Question> getQuestion() {
		return Question;
	}
}
