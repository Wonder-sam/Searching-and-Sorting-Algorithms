package projects;

import java.util.Vector;

public class Sort_Functions {

	public static void insertionSort(Vector<String> list) {
		//function for insertion sort used to sort strings
		for (int i = 1; i < list.size(); i++) {
			String current = list.elementAt(i);
			int j = i - 1;
			while(j >= 0 && current.compareTo(list.elementAt(j)) < 0){
				list.set(j+1, list.elementAt(j));
				j--;
			}
			list.set(j+1,current);
			}
		}
	public static void IntinsertionSort(Vector<String> list) {
		//function for insertion sort used to sort integers
		for (int i = 1; i < list.size(); i++) {
			String current = list.elementAt(i);
			int j = i - 1;
			//convert the string into an integer before performing arithmetic operations
			while(j >= 0 && Integer.parseInt(current)<Integer.parseInt(list.elementAt(j)) ){
				list.set(j+1, list.elementAt(j));
				j--;
			}
			list.set(j+1,current);
			}
		}
	
	public static void bubbleSort(Vector<String> list) {
		//function for bubble sort used to sort strings
		String tmp = "0";
		for(int i=0; i < list.size(); i++){
			for(int j=1; j < (list.size()-i); j++){
				if(list.elementAt(j-1).compareTo(list.elementAt(j)) > 0){
					//swap elements
					tmp = list.elementAt(j-1);
					list.set(j-1, list.elementAt(j));
					list.set(j,tmp);
				}
			}
		}
	}
	public static void IntbubbleSort(Vector<String> list) {
		//function for bubble sort used to sort integers
		String tmp = "0";
		for(int i=0; i < list.size(); i++){
			for(int j=1; j < (list.size()-i); j++){
				if(Integer.parseInt(list.elementAt(j-1))>Integer.parseInt(list.elementAt(j)) ){
					//swap elements
					tmp = list.elementAt(j-1);
					list.set(j-1, list.elementAt(j));
					list.set(j,tmp);
				}
			}
		}
	}
	
	public static void selectionSort(Vector<String> list){
		//function for selection sort used to sort strings
		for (int i = 0; i < list.size() - 1; i++){
			int smallest =i;
			for (int j = i + 1; j < list.size(); j++){
				if (list.elementAt(j).compareTo(list.elementAt(smallest)) < 0){
					smallest = j;
				}
			}
			String temp =list.elementAt(smallest);
			list.set(smallest, list.elementAt(i));
			list.set(i,temp);		
		}
	}
	public static void IntselectionSort(Vector<String> list){
		//function for insertion sort used to sort integers
		for (int i = 0; i < list.size() - 1; i++){
			int smallest =i;
			for (int j = i + 1; j < list.size(); j++){
				//convert the string into an integer
				if (Integer.parseInt(list.elementAt(j)) < Integer.parseInt(list.elementAt(smallest)) ){
					smallest = j;
				}
			}
			//swap elements
			String temp =list.elementAt(smallest);
			list.set(smallest, list.elementAt(i));
			list.set(i,temp);		
		}
	}

	public static void mergeSort(Vector<String> list, int left, int right, String path){
		//function for merge sort
		//accepts a string to know whether to perform the sort on integers or strings and passes it to merge function
        int middle;
        if (left < right) {                            
            middle = (left + right) / 2;
 
            mergeSort(list, left, middle,path);                   
            mergeSort(list, middle + 1, right,path);               
 
            merge(list, left, middle, right, path);               
        }
    }
	
	public static void merge(Vector<String> list, int left, int middle, int right, String path){
		//function for merge
		//accepts a string to know whether to perform the sort on integers or strings
		int lengthLeft = middle - left + 1;
	    int lengthRight = right - middle;
 
        String leftArray[] = new String [lengthLeft];
        String rightArray[] = new String [lengthRight];

     
        for (int i = 0; i < lengthLeft; i++)
            leftArray[i] = list.elementAt(left+i);
        for (int i = 0; i < lengthRight; i++)
            rightArray[i] = list.elementAt(middle+i+1);

        int leftIndex = 0;
        int rightIndex = 0;

      
        for (int i = left; i < right + 1; i++) {
          
            if (leftIndex < lengthLeft && rightIndex < lengthRight && path == "Strings") {
                if (leftArray[leftIndex].compareTo(rightArray[rightIndex]) < 0) {
                    list.set(i, leftArray[leftIndex]);
                    leftIndex++;
                }
                else {
                    list.set(i, rightArray[rightIndex]);
                    rightIndex++;
                }
            }
            else if(leftIndex < lengthLeft && rightIndex < lengthRight && path == "Integers")
            {
            	if (Integer.parseInt(leftArray[leftIndex])<Integer.parseInt(rightArray[rightIndex]) ) {
                    list.set(i, leftArray[leftIndex]);
                    leftIndex++;
                }
                else {
                    list.set(i, rightArray[rightIndex]);
                    rightIndex++;
                }

            }
         
            else if (leftIndex < lengthLeft) {
                list.set(i, leftArray[leftIndex]);
                leftIndex++;
            }
           
            else if (rightIndex < lengthRight) {
                list.set(i, rightArray[rightIndex]);
                rightIndex++;
            }
        }
	}
	
	static void heapify(Vector<String> list, int length, int i, String path) {
		//function for heapify ( breaks the list into ta tree form and sorts)
		//accepts a string to know whether to perform the sort on integers or strings
	    int leftChild = 2*i+1;
	    int rightChild = 2*i+2;
	    int largest = i;

	    if(path == "Integers") {
	    	if (leftChild < length && Integer.parseInt(list.elementAt(leftChild)) > Integer.parseInt(list.elementAt(largest)) ){
	    		largest = leftChild;
	    	}

	    	if (rightChild < length && Integer.parseInt(list.elementAt(rightChild)) > Integer.parseInt(list.elementAt(largest)) ){
	    		largest = rightChild;
	    	}
	    }
	    else {
	    	if (leftChild < length && list.elementAt(leftChild).compareTo(list.elementAt(largest)) > 0 ){
	    		largest = leftChild;
	    	}

	    	if (rightChild < length && list.elementAt(rightChild).compareTo(list.elementAt(largest)) > 0){
	    		largest = rightChild;
	    	}
	    }

	    if (largest != i) {
			//swap elements
	        String temp = list.elementAt(i);
	        list.set(i, list.elementAt(largest));
	        list.set(largest, temp);
	        heapify(list, length, largest, path);
	    }
	}

	public static void heapSort(Vector<String> list, String path) {
		//function for heap sort
		//accepts a string to know whether to perform the sort on integers or strings and passes it to heapify
	    if (list.size() == 0) return;

	   
	    int length = list.size();
	  
	    for (int i = length / 2-1; i >= 0; i--)
	        heapify(list, length, i,path);

	    for (int i = length-1; i >= 0; i--) {
	        String temp = list.elementAt(0);
	        list.set(0, list.elementAt(i));
	        list.set(i, temp);

	        heapify(list, i, 0, path);
	    }
	}

	public static void quickSort(Vector<String> list, int low, int high, String path){
		//function for quick sort
		//accepts a string to know whether to perform the sort on integers or strings
	    if (low < high)
	    {
	      
	        int pi = partition(list, low, high, path);

	        quickSort(list, low, pi - 1, path);  
	        quickSort(list, pi + 1, high, path); 
	    }
	}
	 static int partition(Vector<String> list, int low, int high, String path)
	 //function for partition
	 //accepts a string to know whether to perform the sort on integers or strings
	 //the last element in the list is chosen as the pivot and all numbers larger than it are moved to the right
	 //the list is now partitioned and the sorting is done
	    {
	        String pivot = list.elementAt(high); 
	        int i = (low-1); 
	        for (int j=low; j<high; j++)
	        {
	            
	        	if(path == "Strings") {
	        		if (list.elementAt(j).compareTo(pivot) <= 0){
	                i++;
						//swap elements
	                String temp = list.elementAt(i);
	                list.set(i, list.elementAt(j));
	                list.set(j, temp);
	        		}
	        	}
	        	else {
	        		if (Integer.parseInt(list.elementAt(j))<=Integer.parseInt(pivot)){
		                i++;
		              	//swap elements
		                String temp = list.elementAt(i);
		                list.set(i, list.elementAt(j));
		                list.set(j, temp);
		        		}
	        	}
	        }

			//swap elements
	        String temp = list.elementAt(i+1);
	        list.set(i+1, list.elementAt(high));
	        list.set(high,temp);
	  
	        return i+1;
	    }
	 
	 public static void shellSort(Vector<String> list, String path)
			 //function for shell sort
			 //accepts a user's choice to know the type of data being sorted
	    {
	        int n = list.size();
	  
	        for (int gap = n / 2; gap > 0; gap /= 2) {
	            for (int i = gap; i < n; i += 1) {

	                String temp = list.elementAt(i);
	                int j;
	                if(path == "Integers") {
	                	for (j = i; j >= gap && Integer.parseInt(list.elementAt(j - gap)) > Integer.parseInt(temp); j -= gap)
	                		list.set(j, list.elementAt(j - gap));
	                }
	                else {
	                	for (j = i; j >= gap && list.elementAt(j - gap).compareTo(temp)>0; j -= gap)
	                		list.set(j, list.elementAt(j - gap));
	                }
	                list.set(j,temp);
	            }
	        }
	    }
}
