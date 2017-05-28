package at.fhj.swd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SoftDev_20170331 {
	public static void main(String[] args) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("C:\\Users\\Andreas\\Desktop\\Hallo.txt"));
			String line = null;			
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		}
	
		catch (IOException error) {
			System.out.println("Fehler beim Lesen der Datei.");
			System.out.println("Error-Details: " + error);
		}
		
		finally{
			if (reader != null){
				try {
					reader.close();
				}
				catch (Exception e){}
			}
		}
	}
}
