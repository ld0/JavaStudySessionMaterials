/**
 * SI Fall 2015
 * CSCI 2120
 */

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
// java org.junit.runner.JUnitCore TestGenericArrayList
public class TestGenericArrayList{

	private GenericArrayList<String> stringArray;
	private GenericArrayList<Integer> intArray;

	/**
	 * setup method initializes our variables
	 */
	@Before
	public void setUp(){
		stringArray = new GenericArrayList<String>(String.class);
		intArray = new GenericArrayList<Integer>(Integer.class);
		for (int i = 0; i < 10; i++){
			intArray.add(i);
		}
	}

	/**
	 * Test that 1) constructor doesn't throw errors
	 * 2) our size changes correctly
	 */
	@Test
	public void testConstructor(){
		assertTrue(stringArray.getSize() == 0);
		assertEquals(intArray.getSize(), 10);
	}

	/**
	 * Test that our add method both increments size
	 * and adds items correctly.
	 */
	@Test
	public void testAdd(){
		assertTrue(stringArray.getSize() == 0);
		stringArray.add("hi");
		assertTrue(stringArray.getSize() == 1);
		assertEquals(stringArray.get(0), "hi");
		stringArray.add("bye");
		assertTrue(stringArray.getSize() == 2);
		assertEquals(stringArray.get(1), "bye");
	}

	/**
	 * Test remove method on intArray
	 */
	@Test
	public void testRemove(){
		assertEquals(intArray.getSize(), 10);
		assertEquals(intArray.remove(), (Integer)9);
		assertEquals(intArray.getSize(), 9);
		assertEquals(intArray.remove(), (Integer)8);
		for (int i = 7; i >= 0; i--){
			assertEquals(intArray.getSize(), i + 1);
			assertEquals(intArray.remove(), (Integer)i);
		}
	}

	/**
	 * Test the exception
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public void testGetExceptionNegativeIndex(){
		stringArray.get(-1);
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void testGetExceptionInvalidIndex(){
		assertTrue(stringArray.getSize() < 11);
		stringArray.get(10);
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void testRemovePastEmpty(){
		assertTrue(stringArray.getSize() == 0);
		stringArray.remove();
	}
	
	
	@After
	public void tearDown(){
		stringArray = null;
	}
}
