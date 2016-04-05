import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;

// java org.junit.runner.JUnitCore TestStack
public class TestStack{

	private Stack<Integer> intStack;
	private Stack<String> stringStack;

	@Before
	public void setUp(){
		intStack = new Stack<Integer>(10, Integer.class);
		stringStack = new Stack<String>(3, String.class);
		stringStack.push("hi");
	}

	@Test
	public void testInit(){
		assertTrue(intStack.isEmpty());
		assertFalse(intStack.isFull());
		assertTrue(intStack.getSize() == 0);
		assertTrue(intStack.getLimit() == 10);

		assertFalse(stringStack.isEmpty());
		assertFalse(stringStack.isEmpty());
		assertTrue(stringStack.getSize() == 1);
		assertTrue(stringStack.getLimit() == 3);
	}

	@Test
	public void testPushToEmptyStack(){
		assertTrue(intStack.getSize() == 0);
		intStack.push(7);
		assertTrue(intStack.getSize() == 1);
		assertEquals(intStack.toString(), "7 ");
		intStack.push(-3);
		assertTrue(intStack.getSize() == 2);
		assertEquals(intStack.toString(), "7 -3 ");
		intStack.push(20);
		assertTrue(intStack.getSize() == 3);
		assertEquals(intStack.toString(), "7 -3 20 ");
	}

	@Test
	public void testPushNonEmpty(){
		assertTrue(stringStack.getSize() == 1);
		assertFalse(stringStack.isEmpty());
		stringStack.push("mom");
		assertTrue(stringStack.getSize() == 2);
		assertFalse(stringStack.isFull());
		stringStack.push("bye");
		assertTrue(stringStack.getSize() == 3);
		assertTrue(stringStack.isFull());
		assertEquals(stringStack.toString(), "hi mom bye ");
	}

	@Test
	public void testPopToEmpty(){
		assertFalse(stringStack.isEmpty());
		assertTrue(stringStack.getSize() == 1);
		assertEquals(stringStack.toString(), "hi ");
		stringStack.pop();
		assertTrue(stringStack.isEmpty());
		assertFalse(stringStack.getSize() == 1);
	}

	@Test
	public void testPushAndPop(){
		assertTrue(intStack.isEmpty());
		intStack.push(7);
		assertFalse(intStack.isEmpty());
		for (int i = 0; i < 7; i++){
			intStack.push(i);
			assertTrue(intStack.getSize() == i + 2);
		}
		for (int i = 6; i >= 0; i--){
			assertEquals(intStack.pop(), (Integer)i);
		}
		assertFalse(intStack.isEmpty());
		intStack.pop();
		assertTrue(intStack.isEmpty());
	}

	@Test(expected=IndexOutOfBoundsException.class)
	public void testToStringExcp(){
		assertTrue(intStack.isEmpty());
		intStack.toString();
	}

	@After
	public void tearDown(){
		intStack = null;
	}
}
