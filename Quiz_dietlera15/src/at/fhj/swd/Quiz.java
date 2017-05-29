package at.fhj.swd;

import java.util.ArrayList;

public class Quiz {
	// questions from CSV-file
	private static ArrayList<Question> question;
	// actual user directory
	private static String actualPath = System.getProperty("user.dir");
	// path of source-file
	private static String source = actualPath + "/CSVFile/Question.csv";
	// path of destination-file
	private static String destination = actualPath + "/HTMLFile/index.html";
	// path of log-file
	public static String logFile = System.getProperty("user.dir") + "/log.txt";
	
	public static void main(String[] args) {
		// create log file
		dietlera15.LogFileMessage("-------------------------");
		System.out.println(dietlera15.actualDateTimeForm() + "A Log-File has been created / New Entries have been written to the Log-File");
		System.out.println(dietlera15.actualDateTimeForm() + "The file can be found at: " + logFile);
		System.out.println("-------------------------");
		dietlera15.LogFileMessage("Quiz program started.");
		dietlera15.LogFileMessage("Actual Directory: " + actualPath);
		// write given arguments in log file
		for(String argument : args) {
			dietlera15.LogFileMessage("Arguments given: " + argument);
		}
		
		if (args.length == 0) {
			System.out.println(dietlera15.actualDateTimeForm() + "No arguments given, program started with initial values.");
			System.out.println(dietlera15.actualDateTimeForm() + "Source file: " + source);
			System.out.println(dietlera15.actualDateTimeForm() + "Destination file: " + destination);
			System.out.println("-------------------------");
		}
		
		// check the given arguments
		if (args.length == 2 || args.length == 0) {
			// assign given arguments (if given)
			if(args.length == 2) {
				source = args[0];
				destination = args[1];
			}
			// write source and destination file to log file
			dietlera15.LogFileMessage("source file: " + source);
			dietlera15.LogFileMessage("destination file: " + destination);
			// read CSV file
			QuestionReader reader = new QuestionReader(source);
			question = reader.getQuestion();
			try {
				dietlera15.LogFileMessage(question.size() + " lines were found in file.");
			} catch (NullPointerException error) {
				dietlera15.LogFileError(error);
			}
			// write HTML file
			HTMLQuestionWriter writer = new HTMLQuestionWriter(destination, question);
			writer.writeHTML();
			dietlera15.LogFileMessage("Quiz program stopped.");
		} else {
			System.out.println(dietlera15.actualDateTimeForm() + "Please check your Input Parameter");
			System.out.println(dietlera15.actualDateTimeForm() + "Quiz <Source-File> <Destination-File>");
		}
	}
}
