/**
 * Example of using arrays
 * For SI Session Feb 24 2015
 */

import java.util.Scanner;

public class UsingArrays
{
	public static void main(String[] args)
	{
		int choice = 0;			// choice variable for making a loop to continue the program. it's initialized to 1 so that it will run the first time
		Scanner input = new Scanner(System.in);		// making a Scanner object for getting info from the user
		System.out.println("Program for using arrays.\n");
		while (choice != 0)		// testing the value of "choice" on whether or not to continue the program
		{
			// method makeArray returns a String, so we get this String and print it out
			String result = makeArray(input);
			System.out.println("Result is " + result + "\n");
			System.out.println("Enter 1 to continue, 0 to quit");
			choice = input.nextInt();	// get the int to decide whether or not to end the program
		}

		String string1 = new String("hi");
		String string2 = new String("bye");
		String string3 = new String("hi");

		System.out.println("string1 == string2 " + (string1 == string2));
		System.out.println("string1 == string3 " + (string1 == string3));
		System.out.println("string1.equals(string2) " + (string1.equals(string2)));
		System.out.println("string1.equals(string3) " + (string1.equals(string3)));
	}
	/**
	 * Making an array and deciding what the values will be.
	 * This takes in a Scanner object, and we call it input, regardless of what it actually is.
	 * It calls on other methods to add up everything in the arrays and store this in a String
	 * and then returns that String to main method.
	 */
	public static String makeArray(Scanner input)
	{
		int choice = 0;
		int size = 0;
		String result = "";
		System.out.println("Enter in the type of array you would like to make: 1 for int, 2 for double, 3 for String, followed by the size of the array");
		choice = input.nextInt();
		size = input.nextInt();		// array dimension
		if (choice == 1)			// if the choice is 1, make an array of int
		{
			int[] array = new int[size];	// creating an int array using the specified dimensions. 
			System.out.println("Enter in the values for the int array.");
			for (int i = 0; i < array.length; i++)	// looping through to add each element. it stops *before* the full array.length size is met, since arrays go from 0 to (length -1)
			{
				array[i] = input.nextInt();
			}
			result = adding(array);		// calling on the adding method, which returns a String. 
		}
		else if (choice == 2) 			//if the choice is 2, make a double array
		{
			double[] array = new double[size];
			System.out.println("Enter in the values for the double array.");
			for (int i = 0; i < array.length; i++)
			{
				array[i] = input.nextDouble();
			}
			result = adding(array);
		}
		else if (choice == 3)			// if the choice is 3, make a String array
		{
			String[] array = new String[size];
			System.out.println("Enter in the values for the String array.");
			for (int i = 0; i < array.length; i++)
			{
				array[i] = input.next();
			}
			result = adding(array);
		}
		return result;
	}

	// the following methods are overloaded, as they use the same name but have different parameters, or things to be passed in. 

	/**
	 * method for adding up elements of an int array.
	 * Takes in int array
	 * Returns a String representation of teh sum
	 */
	public static String adding(int[] array)
	{
		int result = 0;
		for (int i = 0; i < array.length; i++)
		{
			result = result + array[i];
		}
		return ("" + result);
	}

	/**
	 * method for adding up elements of a double array.
	 * Takes in double array
	 * Returns a String representation of the sum. 
	 */
	public static String adding(double[] array)
	{
		double result = 0;
		for (int i = 0; i < array.length; i++)
		{
			result = result + array[i];
		}
		return ("" + result);
	}

	/**
	 * method for concatenating elements of a String array.
	 * Takes in a String array
	 * Returns a String representation of all teh elements, separated by a comma and a space
	 */
	public static String adding(String[] array)
	{
		String result = "";
		for (int i = 0; i < array.length; i++)
		{
			result = (result + array[i]);
			// this is to add a comma and a space behind each element; it stops at length - 1, so the last element won't be followed by a comma and space
			if (i < (array.length - 1))
			{
				result = (result + ", ");
			}
		}
		return ("" + result);
	}
}
