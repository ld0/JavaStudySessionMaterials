import java.util.ArrayList;


/**
 * Class for Binary Tree.
 * @author L.. D..
 * for SI Sessions CSCI2120 Nov 2015
 */
public class BTree<T>{
	/** It only needs to keep track of the root node. */
	private Node<T> root;
	
	/** Default constructor. */
	public BTree(){
		root = null;
	}
	
	/**
	 * Constructor that takes an initial node
	 */
	public BTree(T item){
		root = new Node<T>(item, null);
	}
	
	/**
	 * Make a method called insert
	 * @param item to be inserted
	 */
	
	public void insert(T item){
		/** If there is no root node, insert */
		if (root == null){
			root = new Node<T>(item, null);
			return;
		}
		/** Beginning to a private recursive internal method */
		insert(item, root);
	} 

	/**
	 * Private internal method that recursively finds the position to insert the node at.
	 * @param item the element to be inserted
	 * @param current the node whose left and right children will be inspected
	 */
	 private void insert(T item, Node<T> current){
		/** If there's no left node, insert a new node there. */
		if (current.getLeft() == null){
			current.setLeft(new Node<T>(item, current));
		}
		/** If there's instead no right node, insert a new node there. */
		else if (current.getRight() == null){
			current.setRight(new Node<T>(item, current));
		}
		/** If there is both a left and a right, continue recursively to the left. */
		else{
			insert(item, current.getLeft());
		}
	}
	/**
	 * Method to initialize from an array of items.
	 * @param sequence an array of generic type
	 * TODO finish rest of method
	 */
	public void initialize(T[] sequence){
		root = new Node<T>(sequence[0], null);
		for (int i = 0; i < sequence.length - 2; i++){
		}
		
	}

	/**
	 * Breadth first traversal. 
	 * @return String representation of the tree in breadth-first. 
	 * What data structure can we use here?
	 * Queue
	 */
		/** Create a result string that starts off as empty. */
		/** If there is no root, the empty string is returned. */
		/** Otherwise, create the data structure and add the root. */
		/** 
		 * While the data structure isn't empty... 
		 * If there is a left node, add it to the data structure. 
		 * If there is a right node, add it to the data structure. 
		 * Add the current node's data to the result string. 
		 * Remove the first added item and then continue until the while condition is no longer met. 
		 */
	
	/**
	 * preOrder, inOrder, and postOrder public methods. 
	 * They should call on private internal recursive methods by nodes.
	 * @return String representation of preOrder, inOrder, and postOrder traversals, respectively. 
	 */
	

	/**
	 * Method for preOrder traversal.
	 * Remember that in preOrder, the order is me, my left, my right.
	 * Create a new string, and add items to it in the correct order. 
	 * If the node in this case has left and/or right children, recursively traverse those as well.
	 * Once the node has neither left nor right children, return the result.
	 * @param current the node currently being looked at.
	 * @return String representation of this tree in preOrder traversal.
	 */	

	/**
	 * Method for inOrder traversal. 
	 * Inner workings the same as preOrder.
	 * inOrder is my left, me, my right. 
	 * @param current the node currently being looked at
	 * @return String representation of this tree in inOrder traversal. 
	 */

	/**
	 * Method for postOrder traversal. 
	 * Inner workings the same as the previous two.
	 * postOrder is my left, my right, me.
	 * @param current the node currently being looked at 
	 * @return String representation of this tree in postOrder traversal. 
	 */
	
	
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
		private Node<T> parent;
		private Node<T> left;
		private Node<T> right;

		/**
		 * Constructor for node. 
		 * @param the data for this node.
		 * What should the other variables be initialized to?
		 */
		public Node(T data, Node<T> parent){
			this.data = data;
			left = null;
			right = null;
			this.parent = parent;
		}
		
		/**
		 * void methods setRight and setLeft to change the right and left Nodes of this node. 
		 * @param Node for right and left, respectievly. 
		 */

		public void setRight(Node<T> right){
			this.right = right;
		}

		public void setLeft(Node<T> left){
			this.left = left;
		}

		/**
		 * getter methods for next and prev nodes, getNext and getPrev. 
		 * @return next and prev nodes, respectively. 
		 */
		 
		public Node<T> getLeft(){
			return left;
		}

		public Node<T> getRight(){
			return right;
		}
		
		/**
		 * method getData that returns the data in this node. 
		 * @return data
		 */
		public T getData(){
			return data;
		}
	}
	
	/**
	 * Private inner class Queue. For use in the breadth first traversal. 
	 */
		/** ArrayList as the underlying data structure. Initialize. */
		
		/** Constructor for Queue. Should take no arguments and change nothing. */

		/**
		 * Enqueue. 
		 * Method enqueue adds an item to the end of the list.
		 * @param item the element to be inserted
		 */

		/**
		 * Dequeue.
		 * Method dequeue takes an item from the beginning of the list. 
		 * It must return a value but also remove it. 
		 * @return the value at the front of the Queue. 
		 */

		/**
		 * atIndex.
		 * Method to fetch an item at the specified index. 
		 * @param index integer for the location in the list.
		 * @return the item at that location. 
		 * TODO: throw exception if illegal operation is attempted. 
		 */

		/**
		 * isEmpty.
		 * @return if the size of the list is 0.
		 */
	
}
