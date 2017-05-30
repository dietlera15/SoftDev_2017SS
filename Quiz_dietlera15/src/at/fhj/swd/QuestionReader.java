package at.fhj.swd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class QuestionReader {
	private ArrayList<Question> Question = new ArrayList<Question>();
	
	public QuestionReader (String path) {
		BufferedReader reader = null;
		try {
			//start reading of file
			reader = new BufferedReader(new FileReader(path));
			// index is generated for the messages in the log-file
			int index = 1;
			String header[] = reader.readLine().split(";");
			/* 
			 * if the header format is wrong the program is stopped
			 * 
			 * the task is a little bit different (ignore line)
			 * but why should i read an incorrect CSV file?
			 */
			if(checkCSV(header)) {
				index++;
				String line = null;
				while ((line = reader.readLine()) != null) {
					// if the line starts with an #, it contains a comment and can be skipped
					if (line.startsWith("#")) {
						dietlera15.LogFileMessage("Comment in line " + index + ": " + line);
					} else {
						Question.add(new Question(line));
						int lastIndex = Question.size() - 1;
						// if the format of the question is not correct a message is logged
						if (!Question.get(lastIndex).getFormatCorrect()) {
							dietlera15.LogFileMessage("Line " + index + " contains corrupted values: " + Question.get(lastIndex).getWrongFormatMsg());
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
	/**
	 * checks the header of the CSV file
	 * @param header
	 * @return
	 */
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
