package at.fhj.swd;

import java.util.ArrayList;

public class Main {

	private static ArrayList<Rectangle> rect = new ArrayList<Rectangle>();
	private static int count = 8;
	
	public static void main(String[] args) {
		int w = 3;
		int h = 4;
		
		for(int i = 0; i < count; i++) {
			int w_internal = w * (i + 1);
			int h_internal = h * (i + 1);
			rect.add(new Rectangle (w_internal, h_internal));
		}
		
		/**
		 * 2.3 Ausgabe der ArrayList durch eine Methode
		 */
		printRectangles();
		
		/**
		 * 2.4 Verändern der ArrayList
		 *    a. vorletztes Element entfernen
		 *    b. erstes Element entfernen
		 */
		rect.remove(rect.size() - 2); // 2.4 a
		rect.remove(0); // 2.4 b
		
		/**
		 * Ausgabe der ArrayList
		 */
		printRectangles();
		
	}
	
	/**
	 * printRectangle
	 * gibt alle erstellten Rechtecke aus.
	 */
	private static void printRectangles() {
		for(int i = 0; i < rect.size(); i++) {
			int width = rect.get(i).getWidth();
			int height = rect.get(i).getHeight();
			int Umfang = rect.get(i).Umfang();
			System.out.printf("Rechteck %d: %d x %d Umfang: %d \n", (i + 1), width, height, Umfang);
		}
	}

}
