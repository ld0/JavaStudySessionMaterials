/**
 * Small program to run the compare to method from class ComparingType
 * @author L.. D..
 * SI Session CSCI 2120 Fall 2015
 */
import java.util.ArrayList;

public class Comparing{
	
	public static void main(String[] args){

		/** ArrayList of Booleans */
		ArrayList<Boolean> boolArray = new ArrayList<Boolean>();
		boolArray.add(true);
		boolArray.add(true);
		boolArray.add(false);
		ComparingType<Boolean> boolComp = new ComparingType<Boolean>(boolArray);
		
		System.out.println(boolComp.toString());
		boolComp.deleteDuplicates();			// the extra true should be deleted
		System.out.println(boolComp.toString());
		System.out.println("Greatest item is " + boolComp.getGreatestItem().toString());
		System.out.println("Smallest item is " + boolComp.getLeastItem().toString());
		boolComp.sort();
		System.out.println(boolComp.toString());
		
		/** ArrayList of Integers */
		ArrayList<Integer> intArray = new ArrayList<Integer>();
		for (int i = 0; i < 20; i++){
			if (i % 3 == 0){			// all multiples of 3 will be added twice
				intArray.add(i);
			}
			intArray.add(i);
		}
		ComparingType<Integer> intComp = new ComparingType<Integer>(intArray);

		System.out.println(intComp.toString());
		intComp.deleteDuplicates();
		System.out.println(intComp.toString());
		System.out.println("Greatest item is " + intComp.getGreatestItem().toString());
		System.out.println("Smallest item is " + intComp.getLeastItem().toString());
		intComp.sort();
		System.out.println(intComp.toString());
		System.out.println("10 is located at " + intComp.binarySearch(10));
		System.out.println("20 is located at " + intComp.binarySearch(20));

		/** ArrayList of Strings */
		ArrayList<String> strArray = new ArrayList<String>();
		strArray.add("hi");
		strArray.add("werwrwrw");
		strArray.add("bye!");
		strArray.add("werwrwrw"); 
		strArray.add("werwrwrw");
		strArray.add("bye!");
		strArray.add("a");
		strArray.add("A");
		ComparingType<String> strComp = new ComparingType<String>(strArray);

		System.out.println(strComp.toString());
		strComp.deleteDuplicates();
		System.out.println(strComp.toString());
		System.out.println("Greatest item is " + strComp.getGreatestItem().toString());
		System.out.println("Smallest item is " + strComp.getLeastItem().toString());
		strComp.sort();
		System.out.println(strComp.toString());	
		System.out.println("werwrwrw is located at " + strComp.binarySearch("werwrwrw"));
		
		/**
		 * The below will not work, since ArrayList is not comparable, i.e. it doesn't implement interface Comparable, 
		 * as required in our ComparingType class. 
		 * Comparing.java:58: error: type argument ArrayList<Character> is not within bounds of type-variable T
		 * Comment out to check.
		 */
		ArrayList<ArrayList<Character>> invalidArr = new ArrayList<ArrayList<Character>>();
		//ComparingType<ArrayList<Character>> invalidComp = new ComparingType<ArrayList<Character>>(invalidArr);
	}

}


