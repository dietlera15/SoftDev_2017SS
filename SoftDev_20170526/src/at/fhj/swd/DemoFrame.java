package at.fhj.swd;

import java.awt.BorderLayout;
import java.awt.event.*;

import javax.swing.*;

public class DemoFrame extends JFrame {

	private int clickCount = 0;
	private JButton button;
	private JTextField textField;
	
	
	public DemoFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		button = new JButton("Click me");
		textField = new JTextField();
		
		getContentPane().add(button, BorderLayout.NORTH);
		getContentPane().add(textField, BorderLayout.CENTER);
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				buttonClicked();}
			});
		
		
		setTitle("Demo Window");
		setSize(400,300);
	}
	
	private void buttonClicked() {
		clickCount++;
		
		String message = String.format("Button was cklicked '%d' times.",  clickCount);
		System.out.println(message);
		textField.setText(message);
	}
}
