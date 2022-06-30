package projects;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Sos extends JFrame {
	//declare class variables of JFrame components to be used in JFrame
	private JButton Search, Sort;
	private JLabel head;
	protected static String choice;

	public Sos() {
		//declare class variables of JFrame components to be used in JFrame
		// TODO Auto-generated constructor stub
		head = new JLabel("Welcome",SwingConstants.CENTER);
		Search = new JButton("Search");
		Sort = new JButton("Sort");
		//instantiate an object of the class implementing the listener
		next nexxt = new next();
		//add actionlistener to the buttons
		Search.addActionListener(nexxt);
		Sort.addActionListener(nexxt);
		setTitle("Search Or Sort");
		// create a space int he JFrame window to house the components
		//add the components to the JFrame
		Container pane = getContentPane();
		//set the layout of the container
		pane.setLayout(new GridLayout(3,1));
		//add the components to the container
		pane.add(head);
		pane.add(Search);
		pane.add(Sort);
		setSize(300,350); //sets the size of the window
		setLocationRelativeTo(null); //displays the window in he center of the screen
		setVisible(true); //make the window visible
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	private class next implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			dispose();     //dispose off current window
			choice=e.getActionCommand();  //store the users choice
			new SoI();				//call the SoI class
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Sos();
		
		

	}

}
