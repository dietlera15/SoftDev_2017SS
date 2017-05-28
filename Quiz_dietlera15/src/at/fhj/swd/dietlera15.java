package at.fhj.swd;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dietlera15 {
	private static String logFile = System.getProperty("user.dir") + "/log.txt";
	
	/**
	 * formats the actual date and time
	 * @return date and time in YYYY-MM-DD hh:mm format
	 */
	public static String actualDateTime() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;
	}
	
	/**
	 * writes an exception into a log file
	 * @param exception message to be logged
	 */
	public static void LogFileError(Exception exc){
		PrintWriter writer = null;
		try {
			// add new line to log file
			writer = new PrintWriter(new FileOutputStream(logFile, true));
			writer.println("["+ actualDateTime() + "] - " + exc);								
		} catch (IOException error) {
			/* in case of the log file generation fails, an output
			 * message in the console is generated
			 */
			System.out.println("Error during writing the Log-File to " + logFile);
			System.out.println("Error-Details: " + error);
		} finally {
			if (writer != null){
				try {
					writer.close();
				} catch (Exception e){}
			}
		}
	}

	/**
	 * writes a message into a log file
	 * @param message to be logged
	 */
	public static void LogFileMessage(String msg){
		PrintWriter writer = null;
		try {
			// add new line to log file
			writer = new PrintWriter(new FileOutputStream(logFile, true));
			writer.println("["+ actualDateTime() + "] - " + msg);								
		} catch (IOException error) {
			/* in case of the log file generation fails, an output
			 * message in the console is generated
			 */
			System.out.println("Error during writing the Log-File to \"" + logFile + "\"");
			System.out.println("Error-Details: " + error);
		} finally {
			if (writer != null){
				try {
					writer.close();
				} catch (Exception e){}
			}
		}
	}
	
	/**
	 * 
	 * @return HTML Header as a String
	 */
	public static String getHeader(){
		return "<!DOCTYPE html>\n"
				+ "<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"en\" xml:lang=\"en\">\n"
				+ "<head>\n"
					+ "\t<meta charset=\"UTF-8\"/>\n"
					+ "\t<meta name=\"viewport\" content=\"width=device-width\"/>\n"
					+ "\t<meta name=\"author\" content=\"Andreas Dietler\"/>\n"
					+ "\t<title>Software Development </title>\n"
					+ getStyleSheet()
				+ "</head>\n";
	}
	
	/**
	 * 
	 * @return HTML Footer as a String
	 */
	public static String getFooter(){
		return "\t<footer>\n"
				+ "\t\t<h6>Andreas Dietler<br></br>\n"
				+ "\t\tSoftware Development<br></br>\n"
				+ "\t\tSoftware Design WS2016<br></br>\n"
				+ "\t\tFH Joanneum Kapfenberg</h6>\n"
			+ "\t</footer>\n"
		+ "</body>\n"
		+ "</html>\n";
	}
	
	/**
	 * 
	 * @return Style Sheet in an  HTML-Tag as a String
	 */
	private static String getStyleSheet() {
		return "\t<style>\n"
				+ ".low {color: red;}"
				+ "#table-header {font-weight: bold; color: blue;}"
				+ "#austria {font-weight: bold; color: green;}"
			+ "\t</style>\n";
	}
}
