package at.fhj.swd;

import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame{

	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(1000,500);
		
		JPanel north = myBorderPanel(BorderLayout.NORTH);
		JPanel east = myBorderPanel(BorderLayout.EAST);
		JPanel west = myBorderPanel(BorderLayout.WEST);
		JPanel south = myBorderPanel(BorderLayout.SOUTH);
		
		JPanel center = new JPanel();
		center.setBackground(Color.DARK_GRAY);
		add(center, BorderLayout.CENTER);
		
		BoxLayout boxLayout = new BoxLayout(center, BoxLayout.Y_AXIS);
		center.setLayout(boxLayout);
		JPanel input = noNamePanel("Input");
		center.add(input);
		
		JButton convert = new JButton("Convert");
		center.add(convert);
		
		JPanel output = noNamePanel("Output");
		center.add(output);
	}
	
	private JPanel noNamePanel(String labelText) {
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.add(new JLabel(labelText));
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		JTextField textField = new JTextField();
		textField.setColumns(10);
		panel.add(textField);
		return panel;
	}
	
	private JPanel myBorderPanel (String layout) {
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		add(panel, layout);
		return panel;
	}
	
}
