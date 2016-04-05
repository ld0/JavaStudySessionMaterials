import java.util.ArrayList;

/**
 * @author L.. D..
 * example of inner classes
 * CSCI2120 SI session
 * Fall 2015
 */
public class InnerClassExample{
	
	private ArrayList<Other> list;
	
	public InnerClassExample(){
		list = new ArrayList<Other>();
	}

	/**
	 * I take in a String to add to my ArrayList by making it into type Other.  
	 * I use my setNext method in inner class Other 
	 * to set the previous Other to be pointing to the new one.
	 */
	public void add(String data){
		Other temp = new Other(data);
		if (list.size() > 0){
			list.add(temp);
			list.get(list.size() - 2).setNext(temp);
		}
		/**
		 * If the list is empty, there's nothing for the Other's next
		 * to point to.
		 */
		else list.add(temp);		
	}
	
	/**
	 * I add an Other directly to the list.
	 * Will this work? 
	 */
	public void addOther(Other data){
		if (list.size() > 0){
			list.add(data);
			list.get(list.size() - 2).setNext(data);
		}
		else list.add(data);
	}

	/**
	 * Return teh String at the Other's index
	 */
	public String get(int index){
		return (list.get(index)).getData();
	}

	/**
	 * Can I use Other.getData on this?
	 */
	public Other getOther(int index){
		return list.get(index);
	}

	/**
	 * Everything inside here is accessible to only the other class. 
	 */
	private class Other{
		private Other next;
		private Other previous;
		private String data;
		
		public Other(String data){
			this.data = data;
			next = null;
		}
		
		public void setNext(Other next){
			this.next = next;
		}
		/**
		 * Get what's here. 
		 */
		public String getData(){
			return data;
		}
		/**
		 * Get what it's pointing to
		 */
		public Other getNext(){
			return next;
		}
	}

}	






