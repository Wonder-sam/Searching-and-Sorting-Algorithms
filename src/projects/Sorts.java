package projects;


import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;

public class Sorts extends JFrame {
	//declare class variables of JFrame components to be used in JFrame
	private static JButton selectionSort, insertionSort, bubbleSort, mergeSort, heapSort, quickSort, shellSort;
	private JLabel head;

	public Sorts() {
		// TODO Auto-generated constructor stub
		//declare class variables of JFrame components to be used in JFrame
		selectionSort = new JButton("Selection Sort");
		insertionSort = new JButton("Insertion Sort");
		bubbleSort = new JButton("Bubble Sort");
		mergeSort = new JButton("Merge Sort");
		heapSort = new JButton("Heap Sort");
		quickSort = new JButton("Quick Sort");
		shellSort = new JButton("Shell Sort");
		head = new JLabel("Select the kind of sort to perform:", SwingConstants.CENTER);
		//instantiate an object of the class implementing the listener
		Execute exe = new Execute();
		//add actionlistener to the buttons
		selectionSort.addActionListener(exe);
		insertionSort.addActionListener(exe);
		bubbleSort.addActionListener(exe);
		mergeSort.addActionListener(exe);
		heapSort.addActionListener(exe);
		quickSort.addActionListener(exe);
		shellSort.addActionListener(exe);
		setTitle("Sorts");
		// create a space int he JFrame window to house the components
		//add the components to the JFrame
		Container pane = getContentPane();
		pane.setLayout(null);
		//set the size and location of the buttons and other components
		selectionSort.setLocation(70,70);
		selectionSort.setSize(150,35);
		insertionSort.setLocation(70,110);
		insertionSort.setSize(150,35);
		bubbleSort.setLocation(70,150);
		bubbleSort.setSize(150,35);
		mergeSort.setLocation(70,190);
		mergeSort.setSize(150,35);
		heapSort.setLocation(70,230);
		heapSort.setSize(150,35);
		quickSort.setLocation(70,270);
		quickSort.setSize(150,35);
		shellSort.setLocation(70,310);
		shellSort.setSize(150,35);
		head.setLocation(50,30);
		head.setSize(210,35);
		//add the components to the container
		pane.add(head);
		pane.add(selectionSort);
		pane.add(insertionSort);
		pane.add(bubbleSort);
		pane.add(mergeSort);
		pane.add(heapSort);
		pane.add(shellSort);
		pane.add(quickSort);
		
		setSize(300,400); //sets the size of the window
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private class Execute implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			long startTime=0, endTime=0;
			Vector<String> numbers = new Vector<String>();
			String nums;
			//try the operation, catch and output the appropriate error if it fails
			try {
				nums = JOptionPane.showInputDialog("Enter "+SoI.choice.substring(0,SoI.choice.length()-1)+" elements(separate with a space)");
				Functions.InsertInList(numbers,nums);
				//if the input field is not empty
				if(numbers.size()>0  && nums.length()>0) {
					if ( e.getActionCommand().equals("Selection Sort") && SoI.choice=="Integers") {
						startTime = System.nanoTime();
						Sort_Functions.IntselectionSort(numbers); //call the function from the Sort_Functions class
						endTime = System.nanoTime();
					}
					else if(e.getActionCommand().equals("Selection Sort") && SoI.choice=="Strings") {
						startTime = System.nanoTime();
						Sort_Functions.selectionSort(numbers);  //call the function from the Sort_Functions class
						endTime = System.nanoTime();
					}
					else if ( e.getActionCommand().equals("Insertion Sort") && SoI.choice.equals("Integers")) {
						startTime = System.nanoTime();
						Sort_Functions.IntinsertionSort(numbers); //call the function from the Sort_Functions class
						endTime = System.nanoTime();
					}
					else if(e.getActionCommand().equals("Insertion Sort") && SoI.choice=="Strings"){
						startTime = System.nanoTime();
						Sort_Functions.insertionSort(numbers); //call the function from the Sort_Functions class
						endTime = System.nanoTime();
					}
					else if ( e.getActionCommand().equals("Bubble Sort") && SoI.choice.equals("Integers")) {
						startTime = System.nanoTime();
						Sort_Functions.IntbubbleSort(numbers); //call the function from the Sort_Functions class
						endTime = System.nanoTime();
					}
					else if(e.getActionCommand().equals("Bubble Sort") && SoI.choice=="Strings") {
						startTime = System.nanoTime();
						Sort_Functions.bubbleSort(numbers); //call the function from the Sort_Functions class
						endTime = System.nanoTime();
					}
					else if ( e.getActionCommand().equals("Merge Sort") ) {
						startTime = System.nanoTime();
						Sort_Functions.mergeSort(numbers,0,numbers.size()-1,SoI.choice); //call the function from the Sort_Functions class
						endTime = System.nanoTime();
					}
					else if ( e.getActionCommand().equals("Heap Sort") ) {
						startTime = System.nanoTime();
						Sort_Functions.heapSort(numbers,SoI.choice); //call the function from the Sort_Functions class
						endTime = System.nanoTime();
						
					}
					else if ( e.getActionCommand().equals("Shell Sort") ) {
						startTime = System.nanoTime();
						Sort_Functions.shellSort(numbers,SoI.choice); //call the function from the Sort_Functions class
						endTime = System.nanoTime();
						
					}
					else if ( e.getActionCommand().equals("Quick Sort") ) {
						startTime = System.nanoTime();
						Sort_Functions.quickSort(numbers,0,numbers.size()-1,SoI.choice); //call the function from the Sort_Functions class
						endTime = System.nanoTime();
						
					}
					//display the results
					JOptionPane.showMessageDialog(null, "Sorted List: "+numbers+"\n"+"Running Time: "+(endTime-startTime)+"ns","output",JOptionPane.INFORMATION_MESSAGE);
				}
				else { //if input field is empty
					JOptionPane.showMessageDialog(null, "Sorry, can't work with empty list","output",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
			catch(NullPointerException err) {JOptionPane.getRootFrame().dispose();}
			//if there is a problem which conversion from string to integer, show the  appropriate result
			catch(NumberFormatException err) { JOptionPane.showMessageDialog(null,"Input must be of type "+SoI.choice,"Output", JOptionPane.PLAIN_MESSAGE);}
			//ask if user wants to perform another operation
			int resp = JOptionPane.showConfirmDialog(null, "Do you want to perform another operation?");
			if(resp == 0) { //if response is "yes"
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
