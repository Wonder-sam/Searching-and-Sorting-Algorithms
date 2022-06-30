package projects;

import java.util.Vector;

import javax.swing.JOptionPane;

public class Functions {

	public static void InsertInList(Vector<String> list, String data) {
		// TODO Auto-generated constructor stub
		//function to insert user input into a list
		for(int i = 0; i<data.split("\\s").length; i++ ) {
				list.add(data.split("\\s")[i]);
		}
	}
	
	public static Vector<Integer> binarySearch(Vector<String> list, String key, String path) {
		//function for binary search
		// accept a string parameter to determine the type of list being searched
		Vector<String> dup = new Vector<String>(list);
		Vector<Integer> matches = new Vector<Integer>();
		int top = dup.size()-1;
		int bottom =0;
		int mid;
		while(bottom<=top) {
			mid  = (top + bottom)/2;
			if(path == "Strings") {
				if(key.compareTo(dup.elementAt(mid))>0)
					bottom = mid +1;
				else if(key.compareTo(dup.elementAt(mid))<0)
					top = mid -1;
				else {
					matches.add(mid);
					dup.set(mid, dup.elementAt(mid)+"[found]");
				}
			}
			else {
				if(Integer.parseInt(key)>Integer.parseInt(dup.elementAt(mid)) )
					bottom = mid +1;
				else if(Integer.parseInt(key)<Integer.parseInt(dup.elementAt(mid)) )
					top = mid -1;
				else {
					matches.add(mid);
					dup.set(mid, "999");
				}
			}
		}
		
		return matches;
	}
	
	public static Vector<Integer> linearSearch(Vector<String> list, String key, String path) {
		//function for binary search
		// accept a string parameter to determine the type of list being searched
		Vector<Integer> matches = new Vector<Integer>();
		 for (int i=0; i<list.size(); i++) { 
			 if(path =="Strings") {
				 if ( key.compareTo( list.elementAt(i) ) == 0 ) { 
					 matches.add(i); // Return index 
				 }
			 }
			 else {
				 if(Integer.parseInt(key)== Integer.parseInt(list.elementAt(i))) {
					 matches.add(i);
				 }
			 }
		 }
		 return matches;
	}


}
