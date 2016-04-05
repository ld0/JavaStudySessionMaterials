/**
 * @author L.. D..
 * Stack class implemented using generic array
 * SI Session CSCI2120 Fall 2015
 */

import java.lang.reflect.Array;
/**
 * Create a class called Stack that uses the generic type T
 */
public class Stack<T>{	
	/**
	 * Instance variables: an int for limit and size, and an array for data
	 */
	private int limit;
	private int size;
	private T[] data;

	/**
	 * Constructor that takes in a limit and class. 
	 * It should set the instance variable for limit and set it accordingly. 
	 * Size should be initialized to 0. 
	 * Create an array using the limit and the class passed in.
	 * In what case should we throw an exception?
	 */
	@SuppressWarnings("unchecked")
	public Stack(int limit, Class clazz){
		size = 0;
		if (limit <= 0) throw new IllegalArgumentException("Stack constructor: limit must be greater than 0.");
		data = (T[]) Array.newInstance(clazz, limit);
		// casting with object array
		//data = (T[]) new Object[limit];
		this.limit = limit;
	}

	/**
	 * Stack's "push" method adds an item to the stack. 
	 * Where should the item be added? 
	 * In what case should we throw an exception?
	 */

	public void push(T input){
		if (isFull()) throw new IndexOutOfBoundsException("Stack.push(item) exception: cannot add to already full stack");
		data[size] = input;
		size++;
	}

	/**
	 * Stack's "pop" method removes an item from the stack and returns it. 
	 * Where should the item be removed from?
	 * In what case should we throw an exception?
	 */
	public T pop(){
		if (isEmpty()) throw new IndexOutOfBoundsException("Stack.pop cannot pop from already empty stack");
		T result = data[size - 1];
		size--;
		return result;
	}
	


	/**
	 * Simple getter methods:
	 * isEmpty should return whetehr or not the stack is empty.
	 * isFull should return whether or not the stack is full.
	 * getSize should return the size. 
	 * getLimit should return the limit. 
	 */

	public boolean isEmpty(){
		return (size == 0);
	}

	public boolean isFull(){
		return (size == limit);
	}

	public int getSize(){
		return size;
	}

	public int getLimit(){
		return limit;
	}

	/**
	 * toString method.
	 * should this throw any exceptions?
	 */
	public String toString(){
		if (isEmpty()) throw new IndexOutOfBoundsException("Stack.toString : stack is empty");
		String result = "";
		for (int i = 0; i < size; i++){
			result = result + data[i] + " ";
		}
		return result;
	}
}
