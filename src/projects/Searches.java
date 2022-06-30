package projects;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

public class Searches extends JFrame{
	//declare class variables of JFrame components to be used in JFrame
	private JButton linearSearch, binarySearch;
	private JLabel head;
	public Searches() {
		// TODO Auto-generated constructor stub
		//declare class variables of JFrame components to be used in JFrame
		linearSearch = new JButton("Linear Search");
		binarySearch = new JButton("Binary Search");
		head = new JLabel("Select the kind of search to perform:", SwingConstants.CENTER);
		//instantiate an object of the class implementing the listener
		next nexxt = new next();
		//add actionlistener to the buttons
		linearSearch.addActionListener(nexxt);
		binarySearch.addActionListener(nexxt);
		setTitle("Searches");
		// create a space int he JFrame window to house the components
		//add the components to the JFrame
		Container pane = getContentPane();
		pane.setLayout(null);
		//set the size and location of the buttons and other components
		linearSearch.setLocation(70,70);
		linearSearch.setSize(150,35);
		binarySearch.setLocation(70,120);
		binarySearch.setSize(150,35);
		head.setLocation(50,30);
		head.setSize(210,35);
		//add the components to the container
		pane.add(head);
		pane.add(linearSearch);
		pane.add(binarySearch);
		setSize(300,350); //sets the size of the window
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private class next implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			long startTime = 0, endTime = 0;
			Vector<String> list = new Vector<String>();
			String nums;
			String num;
			Vector<Integer> pos = new Vector<Integer>();
			try{
				nums = JOptionPane.showInputDialog("Enter "+SoI.choice.substring(0,SoI.choice.length()-1)+ " elements(separate with a space)");
				Functions.InsertInList(list,nums);
				if(list.size() > 0 && nums.length()>0) {
					num = JOptionPane.showInputDialog("Enter Search Key");
					if(e.getActionCommand().equals("Linear Search")) {
						startTime = System.nanoTime();
						pos = Functions.linearSearch(list,num,SoI.choice); // call function from the Functions class
						endTime = System.nanoTime();
					}
					if(e.getActionCommand().equals("Binary Search")) {
						startTime = System.nanoTime();
						Sort_Functions.mergeSort(list, 0, list.size()-1, SoI.choice);
						System.out.println(SoI.choice);
						System.out.println(list.getClass().getSimpleName());
						pos = Functions.binarySearch(list,num, SoI.choice); // call function from the Functions class
						endTime = System.nanoTime();
					}
				if(pos.size() == 0) //if the size of the array returned is 0, output 'search key not in list'
					JOptionPane.showMessageDialog(null, num+" is not in the list!","output",JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "List: "+list+"\n"+"Search key found at postions: "+pos+"\n"+"Running time: "+(endTime - startTime)+"ns","output",JOptionPane.INFORMATION_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(null, "Sorry, can't work with an empty list","output",JOptionPane.INFORMATION_MESSAGE);
			}
			catch(NullPointerException err) {JOptionPane.getRootFrame().dispose();}
			//ask if user wants to perform another operation
			catch(NumberFormatException err) { JOptionPane.showMessageDialog(null,"Input must be of type "+SoI.choice,"Output", JOptionPane.PLAIN_MESSAGE);}
			int resp = JOptionPane.showConfirmDialog(null, "Do you want to perform another operation?");
			if(resp == 0) {//if response is "yes"
				dispose();
				new Sos();
			}
			else if(resp == 2) //if response is "No"
				JOptionPane.getRootFrame().dispose();
			else
				System.exit(0);
		}
	}
	
	
	

}
