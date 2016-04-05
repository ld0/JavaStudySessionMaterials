import org.junit.Test;
import static org.junit.Assert.*;

import static org.junit.Assert.*;
import org.junit.Test; 
import org.junit.Before;
import org.junit.After;

public class TestSuperClassPractice{

	private Computer computer1;
	private Computer computer2;
	private Desktop computer3;
	private String[] specs3;

	@Before
	public void setUp(){
//	public Computer(String type, int year, double weight, boolean battery){

		computer1 = new Computer("Lenovo", 2014, 8.0, true);
		computer2 = new Computer("Macbook Pro", 2014, 5.0, true);
		specs3 = {"stuff"};
		computer3 = new Desktop(20, "dsf", specs3);
	}

	@Test
	public void testSpecs(){
		assertEquals(specs3, computer3.getSpecs());
		assertEquals(specs3[0], computer3.getOS());
	}

	@After
	public void tearDown(){
		computer1 = null;
		computer2 = null;
	}

	@Test
	public void testComputerConstructor(){
		assertEquals(computer1.getType(), "Lenovo");
		assertTrue(computer1.getBattery());
		assertEquals(computer1.getYear(), 2014);
		assertTrue(computer1.getYear() == 2014);
		assertTrue(computer1.getWeight() == 8.0);

		assertEquals(computer2.getType(), "Macbook Pro");
	}

	@Test
	public void testComputerChangeBattery(){
		// double check
		assertTrue(computer1.getBattery());
		assertTrue(computer1.getWeight() == 8.0);
		// change status of battery
		computer1.removeBattery();
		assertFalse(computer1.getBattery());
		assertTrue(computer1.getWeight() == 6.0);

		computer1.insertBattery();
		assertTrue(computer1.getBattery());
		assertTrue(computer1.getWeight() == 8.0);
	}

	@Test
	public void testChangeType(){
		// double check
		assertEquals(computer2.getType(), "Macbook Pro");
		computer2.changeType("Macbook");
		assertEquals(computer2.getType(), "Macbook");

		int year = computer2.getYear();

	}

}
