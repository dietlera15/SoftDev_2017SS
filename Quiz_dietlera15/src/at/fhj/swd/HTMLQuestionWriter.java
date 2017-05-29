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
					+ "\t</header>\n");
			
			//writer.println(Question.get(1));
			
			
			writer.println(dietlera15.getFooter());
		} catch (IOException error) {
			
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (Exception error) {
					
				}
			}
		}
	}
}
