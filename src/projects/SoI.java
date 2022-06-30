package projects;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class SoI extends JFrame{
	//declare class variables of JFrame components to be used in JFrame
	private JButton integers, strings;
	private JLabel head;
	protected static String choice;
	public SoI() {
		// TODO Auto-generated constructor stub
		//instantiate objects of the classes
		integers = new JButton("Integers");
		strings = new JButton("Strings");
		head = new JLabel("Select list type:", SwingConstants.CENTER);
		//instantiate an object of the class implementing the listener
		Execute exe = new Execute();
		//add actionlistener to the buttons
		strings.addActionListener(exe);
		integers.addActionListener(exe);
		setTitle("String Or Integer");
		// create a space int he JFrame window to house the components
		//add the components to the JFrame
		Container pane = getContentPane();
		pane.setLayout(null);
		//set the size and location of the buttons and other components
		integers.setLocation(70,100);
		integers.setSize(150,35);
		strings.setLocation(70,150);
		strings.setSize(150,35);
		head.setLocation(50,30);
		head.setSize(170,35);
		//add the components to the container
		pane.add(head);
		pane.add(integers);
		pane.add(strings);
		setSize(300,350);  //sets the size of the window
		setLocationRelativeTo(null);
		setVisible(true);   //make the window visible
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	private class Execute implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			dispose();
			choice = e.getActionCommand(); //store users choice
			if(Sos.choice=="Search") { //if the user's choice is search
				new Searches();  //instantiate the Searches class
			}
			else if(Sos.choice =="Sort" ) //if the user's choice is Sort
				new Sorts();		//instantiate the Sort class
		}
	}

}
