/**
 * @author L.. D..
 * JUnit tests for Employee class
 * For SI Sessions CSCI2120
 * Fall 2015
 */

//	java org.junit.runner.JUnitCore TestArraySerialization

import org.junit.Test;
import static org.junit.Assert.*;

import static org.junit.Assert.*;
import org.junit.Test; 
import org.junit.Before;
import org.junit.After;

import java.lang.IllegalArgumentException;

import java.nio.file.FileSystemException;
import java.io.*;

/**
 * Create the class
 */

public class TestArraySerialization{
	/**
	 * Instance variables.
	 * Make sure to test the different constructors.
	 * Make sure to create some variables for invalid operations,
	 * in order to trigger exceptions.
	 */

	private Employee bob;
	private Employee joe;
	private Employee jane;
	private Employee janeCopy;

	private String[] joeArray;

	private String stringTest;
	private String[] stringArray;

	private Employee invalidEmployee;
	private String[] smallArray;
	private String[] bigArray;

	/**
	 * Method to initialize variables 
	 */
//	public Employee(String name, int id, int classification, double salary, String address){

	@Before
	public void setUp(){
		bob = new Employee("bob", 8765309, 2, 7.45, "123 Main Street");
		jane = new Employee("jane", 1234, 7, 23.02, "456 Main Street");
		smallArray = new String[4];
		bigArray = new String[6];
		joeArray = new String[5];
		joeArray[0] = "joe";
		joeArray[1] = "7";
		joeArray[2] = "23";
		joeArray[3] = "7.25";
		joeArray[4] = "72 Elm Street";
		joe = new Employee(joeArray);

		stringArray = new String[5];
		stringTest = "a b c d e";
	}

	/**
	 * Method to reassign everything to null at the end
	 */
	@After
	public void tearDown(){
		bob = null;
		joe = null;
		jane = null;
	}

	/**
	 * Test methods.
	 * First, test query methods for each of the different types of constructors.
	 */
	@Test
	public void testDefaultConstructor(){
		assertEquals(bob.getName(), "bob");
		assertEquals(bob.getId(), 8765309);
		assertEquals(bob.getClassification(), 2);
		assertTrue(bob.getSalary() == 7.45);
		assertEquals(bob.getAddress(), "123 Main Street");
	}

	/**
	 * Test for constructor that takes in String array
	 */
	@Test
	public void testStringArrayConstructor(){
		assertEquals(joe.getName(), "joe");
		assertEquals(joe.getId(), 7);
		assertEquals(joe.getClassification(), 23);
		assertTrue(joe.getSalary() == 7.25);
		assertEquals(joe.getAddress(), "72 Elm Street");
	}

	/**
	 * Test for constructor that deserializes an Employee object. 
	 */
	@Test
	public void testDeserializedConstructor() throws FileNotFoundException, IOException, ClassNotFoundException{
		/**
		 * Test to ensure that jane was created correctly.
		 */
		assertEquals(jane.getName(), "jane");
		assertEquals(jane.getId(), 1234);
		assertEquals(jane.getClassification(), 7);
		assertTrue(jane.getSalary() == 23.02);
		assertEquals(jane.getAddress(), "456 Main Street");
		jane.serialize("jane");
		/**
		 * Test that jane was serialized correctly. 
		 */
		jane.testFile("jane.ser");
		/**
		 * Test constructor that uses deserialization by making a copy of jane
		 * and then testing them against each other. 
		 */
		//janeCopy = new Employee("jane.ser");
//		assertEquals(jane.getName(),
	//	assertEquals(jane.toString(), janeCopy.toString());
	}

	/**
	 * Test the printing methods.
	 */
	
	

	/**
	 * Test inner methods.
	 */
	@Test
	public void testFileExists() throws FileSystemException{
		joe.testFile("TestArraySerialization.java");
	}

	@Test
	public void testStringToStringArray(){
		stringArray = bob.stringToStringArray(stringTest);
	}

	/**
	 * Test serialization methods.
	 */
	@Test
	public void testSerialize() throws FileNotFoundException, IOException, FileSystemException{
		bob.serialize("bob");
		bob.testFile("bob.ser");
		joe.serialize("joe");
		joe.testFile("joe.ser");
	}


	/**
	 * Test methods to generate exceptions.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorSmallArray(){
		invalidEmployee = new Employee(smallArray);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testConstructorBigArray(){
		invalidEmployee = new Employee(bigArray);
	}

	@Test(expected=FileSystemException.class)
	public void testFileDoesntExist() throws FileSystemException{
		bob.testFile("wfhdfgkjg");
	}

}
