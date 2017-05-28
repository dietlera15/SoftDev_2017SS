package at.fhj.swd;

import java.awt.event.*;

import javax.swing.*;

public class MainFrame extends JFrame {

	private static final ActionListener ActionListener = null;

	public MainFrame() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hello SWD");
		setSize(300,400);
		
		JButton button = new JButton("Press me!");
		
		getContentPane().add(button);
		
	}
	
}
