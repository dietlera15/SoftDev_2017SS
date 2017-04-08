package at.fhj.swd;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintWriter printWriter = null;
		try {
			FileOutputStream outputStream = new FileOutputStream("C:/temp/Output.txt");
			printWriter = new PrintWriter(outputStream);
			printWriter.println("Hallo Welt!");
			printWriter.println("Das ist ein Test");
		} catch (IOException ex) {
			System.out.println("Fehler beim Schreiben in die Datei");
		} catch (Exception ex) {
			System.out.println("Unbekannter Fehler");
		} finally {
			if (printWriter != null) {
				printWriter.close();
			}
		}
		
	}

}
