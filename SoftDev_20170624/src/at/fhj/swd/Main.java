package at.fhj.swd;

import java.io.*;

public class Main {

	public static void methodA() {
		System.out.println("call Method B!");
		methodB();
	}
	public static void methodB() {
		System.out.println("call Method C!");
		methodC();
	}
	public static void methodC() {
		System.out.println("about to crash!");
		crash();
	}
	public static void crash() {
		throw new MyException("BOOOM!!!");
	}
	
	
	public static String readFirstLine(String name) throws IOException {
		BufferedReader reader = new BufferedReader (new FileReader(name));		
		String line = reader.readLine();
		return line;
	}
	
	public static void main(String[] args) {
		try {
			crash();
		} catch (MyException error) {
			error.printStackTrace();
		}
		methodA();
		try {
			readFirstLine("C:/Users/andreas/Documents/text.txt");
		} catch (IOException error) {
			System.out.println("Fehler");
		}
	}
}