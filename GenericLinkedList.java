/**
 * @author L.. D..
 * Doubly linked list using generic types
 * for SI sessions fall 2015
 * CSCI 2120
 * Create a class called GenericLinkedList and make it of type T
 */
public class GenericLinkedList<T>{
	/**
	 * First, make the inner Node class.
	 * Instance variables this class needs: 
	 * a Node for head, a Node for tail, and the size. 
	 */
	private Node<T> head;
	private Node<T> tail;
	private int size;

	/**
	 * Two constructors. 
	 * One is the default constructor and takes in nothing.
	 * Another starts off with the initial data for the first Node.
	 * @param data of type T to have set as the first node.
	 */
	public GenericLinkedList(T data){
		// what else is needed here?
		head = new Node<T>(data);
		tail = head;
		head.setNext(tail);
		tail.setPrev(head);
		size = 1;
	}
	
	public GenericLinkedList(){
		// what should the instance variables be set to?
		head = null;
		tail = null;
		size = 0;
	}
	

	/**
	 * method addNode that adds a Node to the end of the list. No return.
	 * @param data of type T for the new Node. 
	 * If there's nothing in the linked list yet, 
	 * add the new item as the head. 
	 */
	public void addNode(T data){
		Node<T> temp = new Node<T>(data);
		// if the list is empty
		if (size == 0){
			head = temp;
			tail = temp;
			head.setNext(tail);
			tail.setPrev(head);
			size++;
		}
		else{
			temp.setPrev(tail);
			tail.setNext(temp);
			tail = temp;
			size++;
		}
	}

	/**
	 * method remove that removes the last node in the list.
	 * if the list has 1 item, both head and tail are null.
	 * @return the data from the last node. 
	 * @throws IndexOutOfBoundsException if the list is already empty.
	 */
	public T remove(){
		if (size == 0) throw new IndexOutOfBoundsException("GenericLinkedList.remove() list is empty");
		// if there's only 1 item, head and tail are null
		if (size == 1){
			T temp = tail.getData();
			tail = null;
			head = null;
			size--;
			return temp;
		}
		// otherwise, remove tail
		else{
			T temp = tail.getData();
			tail.getPrev().setNext(null);
			tail = tail.getPrev();
			size--;
			return temp;
		}
	}

	/**
	 * getSize query method.
	 * @return current size of this list. 
	 */
	public int getSize(){
		return size;
	}

	/**
	 * query method to get head data
	 * TODO: throw exception on already empty list
	 */
	public T getHeadData(){
		if (size == 0) throw new IndexOutOfBoundsException("GenericLinkedList.getHeadData() list is already empty");
		return head.getData();
	}

	public T getTailData(){
		if (size == 0) throw new IndexOutOfBoundsException("GenericLinkedList.getTailData() list is already empty");
		return tail.getData();
	}

	/**
	 * isEmpty query method.
	 * @return size == 0
	 */

	/**
	 * OPTIONAL
	 * method getData to return the node's data at the specified position. 
	 * @param int position to get the item at. 
	 * @return the node's data at that position.
	 * @throws IndexOutOfBoundsException if the list is empty 
	 * @throws IndexOutOfBoundsException if the position is non existant (how to determine this?)
	 */

	/**
	 * method toString that returns this list's items concatenated in a String.
	 * @return String representation of this list. 
	 * @throws IndexOutOfBoundsException if the list is empty.
	 */
	public String toString(){
		String result = "";
		/** If the linked list is empty, throw an exception. */
		if (size == 0) throw new IndexOutOfBoundsException("GenericLinkedList.toString(): list is empty");
		/** create a temporary node for the current place. */
		Node<T> temp = head;
		/** if there's only one node, return its data using its type's default toString. */
		if (size == 1) return temp.getData().toString();
		/** else, for each node, concatenate the data's toString wtih a space between. */
		for (int i = 0; i < size - 1; i++){
			result = result + temp.getData().toString() + " ";
			temp = temp.getNext();
		}
		/** the last item shouldn't have a space after it */
		result = result + temp.getData().toString();
		return result;
	}

	/**
	 * Private class Node, of type T. 
	 */
	private class Node<T>{
		/**
		 * Instance variables: 
		 * data of type T for the current item, 
		 * a Node for prev and a Node for next. 
		 */
		private T data;
		private Node<T> prev;
		private Node<T> next;

		/**
		 * Constructor for node. 
		 * @param the data for this node.
		 * What should the other variables be initialized to?
		 */
		public Node(T data){
			this.data = data;
			prev = null;
			next = null;
		}
		

		/**
		 * void methods setNext and setPrev to change the next and prev Nodes of this node. 
		 * @param Node for next and prev, respectievly. 
		 */

		public void setNext(Node<T> next){
			this.next = next;
		}

		public void setPrev(Node<T> prev){
			this.prev = prev;
		}

		/**
		 * getter methods for next and prev nodes, getNext and getPrev. 
		 * @return next and prev nodes, respectively. 
		 */ 
		public Node<T> getNext(){
			return next;
		}

		public Node<T> getPrev(){
			return prev;
		}
		
		/**
		 * method getData that returns the data in this node. 
		 * @return data
		 */
		public T getData(){
			return data;
		}
	}
}

