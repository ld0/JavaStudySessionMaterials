/**
 * Class that has a deleteDuplicates method
 * using Comparable's compareTo method.
 * @author L.. D..
 * SI Sessions CSCI 2120 fall 2015
 */

import java.util.ArrayList;

/** 
 * T is our generic type.
 * T extends Comparable because we need to use the method compareTo in interface Comparable. 
 * Read more: http://docs.oracle.com/javase/7/docs/api/java/lang/Comparable.html
 * If we try to use a type that isn't extending Comparable, we'll get a "type argument" error. 
 */
public class ComparingType<T extends Comparable<T>>{
	
	private ArrayList<T> data;
	private boolean sorted;
	private final int VALUE_NOT_FOUND = -1;

	/**
	 * Constructor for ComparingType
	 * @param data ArrayList of type T for data
	 */
	public ComparingType(ArrayList<T> data){
		this.data = data;
		sorted = false;
	}

	/** Public method to call the private inner method. */
	public void deleteDuplicates(){
		data = deleteDuplicates(data);
	}

	/** 
	 * Private recursive internal method called by deleteDuplicates()
	 * @param input ArrayList of type T to have its duplicates deleted
	 */
	private ArrayList<T> deleteDuplicates(ArrayList<T> input){
		for (int i = 0; i < input.size(); i++){			// start at the first item
			for (int j = i + 1; j < input.size(); j++){	// compare to the next item. 
				if (input.get(j).compareTo(input.get(i)) == 0){		// if compareTo returns 0, the items are equal
					input.remove(i);
					return deleteDuplicates(input);					// this is to avoid the ConcurrentModificationException that occurs when altering the contents of something we're iterating over.
				}
			}
		}
		return input;
	}
	
	/**
	 * use compareTo to fetch the greatest item
	 * @param none
	 * @return greatest item
	 */
	public T getGreatestItem(){
		T result = data.get(0);
		for (int i = 1; i < data.size(); i++){
			if (data.get(i).compareTo(result) > 0){		// compareTo returns greater than 0/ positive if it's larger
				result = data.get(i);
			}
		}
		return result;
	}
	
	/**
	 * use compareTo to fetch the least item
	 * @param none
	 * @return least item
	 */
	 public T getLeastItem(){
		 T result = data.get(0);
		 for (int i = 1; i < data.size(); i++){
			 if (data.get(i).compareTo(result) < 0){	// compareTo returns negative if it's smaller
				 result = data.get(i);
			 }
		 }
		 return result;
	 }
	
	/**
	 * use compareTo to sort the array.
	 * May require other helper methods.
	 * @param none
	 * @return none
	 */

	public void sort(){
		if (!sorted) bubbleSort(data);
		sorted = true;
	}

	/**
	 * Bubble sort algorithm.
	 */ 
	private void bubbleSort(ArrayList<T> input){
		int n = input.size();
		boolean swapped = false;			// swapped is going to be used in the base case, if nothing is swapped, the list is already in order
		for (int i = 1; i <= n - 1; i++){
			if ( input.get(i - 1).compareTo(input.get(i)) > 0){		// compareTo will return positive if the first is greater than the second
				T temp = input.get(i);								// temp saves current item so we can swap without losing it
				input.set(i, input.get(i - 1));
				input.set(i - 1, temp);
				swapped = true;										// swapped = true means it could possibly still not be in order
				}
			}
		if (swapped){												// if (swapped) equivalent to if (swapped == true) because swapped is already a boolean
			bubbleSort(input);										// recursive call, if the list could possibly not be in order
		}
	}
	

	/**
	 * Search for a given value using binary search. 
	 * @param T item the item being searched for 
	 * @return int the index of the item, or -1 if not found
	 * Pseudocode: 
		int search(int A[], int key){
			if (the array is unsorted)
				sort();
			return binarySearch(key, 0, size of A);
		}	
	 */
	 
	 public int binarySearch(T item){
		 if (!sorted) sort();
		 return binarySearch(item, 0, data.size() - 1);
//		 return -2;
	 }
	
	/**
	 * Binary search for a given value.
	 * @param T item, the item being searched for 
	 * @param int min, the minimum index
	 * @param int max, the maximum index
	 * @return int mid, the index of the item, or -1 if not found
	 * Psuedocode:
		int binary_search(int A[], int key, int imin, int imax){
			// test if array is empty
			if (imax < imin)
				// set is empty, so return value showing not found
				return KEY_NOT_FOUND;
		
				// calculate midpoint to cut set in half
				int imid = midpoint(imin, imax);
				if (imid >= size of A) return KEY_NOT_FOUND;
			  
				// three-way comparison
				if (A[imid] > key)
					// key is in lower subset
					return binary_search(A, key, imin, imid - 1);
				else if (A[imid] < key)
					// key is in upper subset
					return binary_search(A, key, imid + 1, imax);
				else if (A[imid] == key)
					// key has been found
					return imid;		
			}
		*/
	
	private int binarySearch(T value, int min, int max){
		if (data.size() == 0) return VALUE_NOT_FOUND;
		if (max < min) return VALUE_NOT_FOUND;
		int mid = (max + min) / 2;
		if (mid >= data.size()) return VALUE_NOT_FOUND;
		if (data.get(mid).compareTo(value) > 0){
			return binarySearch(value, min, mid - 1);
		}
		if (data.get(mid).compareTo(value) < 0){
			return binarySearch(value, mid + 1, max);
		}
		return mid;
//		return -2;
	}
	
	
	/** 
	 * toString method
	 * @return String concatenation of all items in this ArrayList, separated by spaces.
	 */
	public String toString(){
		String result = "";
		for (T item : data){
			result = result + item + " ";
		}
		return result;
	}
	
	
}
