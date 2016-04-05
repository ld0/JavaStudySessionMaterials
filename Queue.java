/**
 * @author L.. D..
 * Queue class for SI Session
 * CSCI 2120 Fall 2015
 */
import java.lang.reflect.Array;


/**
 * Create a class called Queue that's generic type.
 * What's the difference between a queue and a queue?
 */


public class Queue<T>{	
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
	public Queue(int limit, Class clazz){
		size = 0;
		if (limit <= 0) throw new IllegalArgumentException("queue constructor: limit must be greater than 0.");
		data = (T[]) Array.newInstance(clazz, limit);
		// casting with object array
		//data = (T[]) new Object[limit];
		this.limit = limit;
	}

	/**
	 * Queue's "enqueue" method adds an item to the queue. 
	 * Where should the item be added? 
	 * In what case should we throw an exception?
	 */
	public void enqueue(T input){
		if (isFull()) throw new IndexOutOfBoundsException("queue.enqueue(item) exception: cannot add to already full queue");
		data[size] = input;
		size++;
	}

	/**
	 * queue's "dequeue" method removes an item from the queue and returns it. 
	 * Where should the item be removed from?
	 * In what case should we throw an exception?
	 * TODO: change it to FIFO
	 */
	public T dequeue(){
		if (isEmpty()) throw new IndexOutOfBoundsException("queue.dequeue cannot dequeue from already empty queue");
		T result = data[0];
		size--;
		for (int i = 0; i < size; i++){
			data[i] = data[i + 1];
		}
		return result;
	}
	


	/**
	 * Simple getter methods:
	 * isEmpty should return whetehr or not the queue is empty.
	 * isFull should return whether or not the queue is full.
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
		if (isEmpty()) throw new IndexOutOfBoundsException("queue.toString : queue is empty");
		String result = "";
		for (int i = 0; i < size; i++){
			result = result + data[i] + " ";
		}
		return result;
	}
}
