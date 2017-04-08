package at.fhj.swd;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader = null;
		try {
			FileInputStream inputStream = new FileInputStream("C:/temp/file.txt");

			/**
			 * Byte für Byte Lesen und anschließend die ASCII Kodierung ausgeben
			int val1 = inputStream.read();
			int val2 = inputStream.read();
			inputStream.close();
			System.out.printf("%d - %d \n ", val1, val2);
			 */
			
			
			/**
			 * Verwendung eines BufferedReaders
			 * Es muss nur der BufferedReader geschlossen werden.
			 * Der BufferedReader gibt das close an den InputStreamReader weiter.
			 * Der InputStreamReader schließt wiederrum den FileInputStream.
			 */
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			bufferedReader = new BufferedReader(inputStreamReader);
			/*
			String line1 = bufferedReader.readLine();
			String line2 = bufferedReader.readLine();
			System.out.printf("Line1: %s \n", line1);
			System.out.printf("Line2: %s \n", line2);
			*/
			
			/**
			 * 
			 */
			
			String line;
			int numLine = 0;
			while ((line = bufferedReader.readLine()) != null) {
				numLine++;
				System.out.printf("Zeile %d: %s\n", numLine, line);
			}
			System.out.printf("Die Datei hatte %d Zeilen. \n", numLine);
			
			bufferedReader.close();
			
		} catch (IOException ex) {
			System.out.println("Fehler beim Lesen der Datei");
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException ex2) {}
			}
		}
	}

}
