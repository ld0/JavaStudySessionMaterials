/**
 * Using arrays
 */

import java.util.ArrayList;

public class Arrays
{
	public static void main(String[] args)
	{
		/**
		 * Create an array of integers
		 * size 5, call it intArray.
		 * Iterate through the array,
		 * and put multiples of 10 in,
		 * using the length of the array
		 * and not just 5.
		 */

		int[] intArray = new int[5];
		for (int i = 0; i < intArray.length; i++)
		{
			intArray[i] = i * 10;
		}

		/**
		 * Create an array of Strings
		 * size 5, call it strArray.
		 * Iterate through the array,
		 * using the length of strArray,
		 * and place the items from intArray into strArray
		 * as Strings.
		 */
		String[] strArray = new String[5];
		for (int i = 0; i < strArray.length; i++)
		{
			strArray[i] = (""+intArray[i]);
		}

		/**
		 * Print out the values in both arrays like this
		 * At index __, intArray contains __ and strArray contains __
		 */
		for (int i = 0; i < intArray.length; i++)
		{
			System.out.println("At index " + i + ", intArray contains " + intArray[i] + " and strArray contains " + strArray[i]);
		}

		/**
		 * Make a double array called doubleArray
		 * with the following items in it
		 * 1.0, 2.0, 3.0.
		 * Print out the size of the array. 
		 */
		double[] doubleArray = {1.0, 2.0, 3.0};
		System.out.println(doubleArray.length);

		/**
		 * Make one more int array,
		 * called intArray2,
		 * size 2.
		 * Inside this one place two arbitrary integers. 
		 */
		int[] intArray2 = new int[2];
		intArray2[0] = 3;
		intArray2[1] = 5;

		/**
		 * Call on the method sum to get the sum of both int arrays
		 * and print it out
		 */
		System.out.println(sum(intArray));
		System.out.println(sum(intArray2));

		/**
		 * Create an ArrayList of type String
		 * and call it 
		 */

	}

	/**
	 * Create a method called sum
	 * that takes in an int array
	 * and returns the sum. 
	 */
	public static int sum(int[] array)
	{
		int result = 0;
		for (int i = 0; i < array.length; i++)
		{
			result = result + array[i];
		}
		return result;
	}
}

