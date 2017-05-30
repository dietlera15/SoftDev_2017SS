package at.fhj.swd;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class HTMLQuestionWriter {
	private String Destination;
	private ArrayList<Question> Question;
	
	public HTMLQuestionWriter (String dest, ArrayList<Question> question) {
		this.Destination = dest;
		this.Question = question;
	}
	
	public void writeHTML() {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(new FileOutputStream(Destination));
			writer.println(dietlera15.getHeader());
			writer.println("<body>\n"
					+ "\t<header>\n"
						+ "\t\t<h1>Uebung 1: Collections und Kommandozeilenargumente</h1>\n"
						+ "\t\t<h3>Quiz - Dietler Andreas</h3>\n"
					+ "\t</header>");
			writer.println("\t<main>");
			int index = 1;
			for (int i = 0; i < Question.size(); i++) {
				if (Question.get(i).getFormatCorrect()) {
					if ((index % 2) == 0) {
						writer.println("\t\t<section class=\"even\">");
					} else {
						writer.println("\t\t<section class=\"odd\">");
					}
					writer.println("\t\t\t<h3 class=\"question\">Question " + index + ": " + Question.get(i).getQuestion() + "</h3>");
					writer.println("\t\t\t<article>");
					writer.println("\t\t\t\t<p><ul>");
					for (int j = 0; j < Question.get(i).getAnswer().length; j++) {
						if (j == Question.get(i).getCorrectIndex()) {
							writer.println("\t\t\t\t<li class=\"answer\">" + Question.get(i).getAnswer()[j] + "</li>");
						} else {
							writer.println("\t\t\t\t<li>" + Question.get(i).getAnswer()[j] + "</li>");
						}
					}
					writer.println("\t\t\t\t</ul></p>\n"
							+ "\t\t\t</article>\n"
							+ "\t\t</section>");
					index++;
				}
			}
			writer.println("\t</main>\n");
			writer.println(dietlera15.getFooter());
			System.out.println(dietlera15.actualDateTimeForm() + "Writing file successfull.");
		} catch (IOException error) {
			System.out.println(dietlera15.actualDateTimeForm() + "Error writing file. More details in log file.");
			dietlera15.LogFileMessage("Error writing HTML file.");
			dietlera15.LogFileError(error);
		} finally {
			if (writer != null) {
				try {
					writer.close();
					System.out.println(dietlera15.actualDateTimeForm() + "Write file finished.");
				} catch (Exception error) {
					dietlera15.LogFileError(error);
				}
			}
		}
	}
}
