/**
 * @author L.. D..
 * Example of Generic Array List 
 * SI Sessions CSCI 2120 Fall 2015
 */

import java.lang.reflect.Array;

/**
 * T is the generic type, so whatever type we want to use. 
 */
public class GenericArrayList<T>{
	/**
	 * Array of our data, of type T
	 * current size of our list
	 * What class we use
	 */
	private T[] data;
	private int size;
	private Class clazz;
	
	/**
	 * Constructor for our list. 
	 * @param the class to be used. 
	 */
	@SuppressWarnings("unchecked")
	public GenericArrayList(Class<T> clazz){
		size = 0;
		this.clazz = clazz;
		// using "reflection"
		data = (T[]) Array.newInstance(clazz, 0);
		// below would be with casting
	//	data = (T[]) new Object[0];
	}

	/**
	 * Add an item to the end of teh array list.
	 * Calls on private inner method to grow the array first. 
	 * @param the item to be inserted. 
	 */
	public void add(T item){
		growArray();
		data[size] = item;
		size++;
	}

	/**
	 * Private inner method to grow the array. 
	 * An array one spot bigger is created, 
	 * and the items are added one by one. 
	 */
	@SuppressWarnings("unchecked")
	private void growArray(){
		T[] temp = (T[]) Array.newInstance(clazz, size + 1);
		for (int i = 0; i < size; i++){
			temp[i] = data[i];
		}
		data = temp;
	}

	/**
	 * Query method for the current size. 
	 * @return this.size 
	 */
	public int getSize(){
		return size;
	}
	
	/**
	 * Method to get the item at the specified index.
	 * @param the index
	 * @return the item at the index
	 * @throws IndexOutOfBoundsException if the index is out of bounds
	 */
	public T get(int index){
		if (index > size - 1 || index < 0) throw new IndexOutOfBoundsException("GenericArrayList.get : index does not exist");
		return data[index];
	}
	
	
	/**
	 * Method to remove the last item. 
	 * Calls on private internal method to shrink the array. 
	 * @return the last item, which is removed. 
	 * @throws IndexOutOfBoundsException if the list is already empty.
	 */
	public T remove(){
		if (size == 0) throw new IndexOutOfBoundsException("GenericArrayList.remove list is already empty");
		T result = data[size - 1];
		shrinkArray();
		size--;
		return result;
	}
	

	/**
	 * Private internal method to shrink the array. 
	 */
	@SuppressWarnings("unchecked")
	private void shrinkArray(){
		T[] temp = (T[]) Array.newInstance(clazz, size - 1);
		for (int i = 0; i < size - 1; i++){
			temp[i] = data[i];
		}
		data = temp;
	}
	
	/**
	 * toString method that concatenates all the items in the arraylist as strings
	 * and returns as a string, separated by spaces.
	 * @return contents of the array as string. 
	 */

}
