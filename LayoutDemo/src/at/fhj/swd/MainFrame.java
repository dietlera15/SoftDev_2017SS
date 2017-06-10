package at.fhj.swd;

import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JPanel north = new JPanel ();
		north.setBackground(Color.CYAN);
		add(north, BorderLayout.NORTH);
		
		JPanel east = new JPanel();
		east.setBackground(Color.BLUE);
		add(east, BorderLayout.EAST);
		
		JPanel west = new JPanel();
		west.setBackground(Color.GREEN);
		add(west, BorderLayout.WEST);
		
		JPanel south = new JPanel();
		south.setBackground(Color.YELLOW);
		add(south, BorderLayout.SOUTH);
		
		JPanel center = new JPanel();
		center.setBackground(Color.DARK_GRAY);
		add(center, BorderLayout.CENTER);
		
		setSize(1000, 500);
		/*
		center.setLayout(new FlowLayout());
		for (int i = 0; i < 5; i++) {
			JButton btn = new JButton("Button" + (i + 1));
			center.add(btn);
		}
		*/
		BoxLayout boxLayout = new BoxLayout(center, BoxLayout.Y_AXIS);
		center.setLayout(boxLayout);
		for (int i = 0; i < 5; i++) {
			JButton btn = new JButton("Button" + (i + 1));
			btn.setAlignmentX(0.5f);
			center.add(btn);
			center.add(Box.createRigidArea(new Dimension(0,5)));
		}
		
		JPanel bottom = new JPanel();
		bottom.setBackground(Color.RED);
		center.add(bottom);
		
		BoxLayout southLayout = new BoxLayout(south, BoxLayout.X_AXIS);
		south.setLayout(southLayout);
		
		JButton presious = new JButton("Previous");
		JButton next = new JButton("Next");
		south.add(presious);
		south.add(Box.createGlue());
		south.add(next);
		
		JLabel label = new JLabel("Hello World!");
		north.add(label);
	}

}
