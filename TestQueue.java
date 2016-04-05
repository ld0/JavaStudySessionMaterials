import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;

// java org.junit.runner.JUnitCore TestQueue
public class TestQueue{

	private Queue<Integer> intQueue;

	@Before
	public void setUp(){
		intQueue = new Queue<Integer>(10, Integer.class);
		
	}

	@Test
	public void testInit(){
		assertTrue(intQueue.isEmpty());
		assertFalse(intQueue.isFull());
		assertTrue(intQueue.getSize() == 0);
		assertTrue(intQueue.getLimit() == 10);
	}

	@Test
	public void testAdd(){
		assertTrue(intQueue.getSize() == 0);
		intQueue.enqueue(7);
		assertTrue(intQueue.getSize() == 1);
		assertEquals(intQueue.toString(), "7 ");
		intQueue.enqueue(-3);
		assertTrue(intQueue.getSize() == 2);
		assertEquals(intQueue.toString(), "7 -3 ");
		intQueue.enqueue(20);
		assertTrue(intQueue.getSize() == 3);
		assertEquals(intQueue.toString(), "7 -3 20 ");
	}

	@After
	public void tearDown(){
		intQueue = null;
	}
}
