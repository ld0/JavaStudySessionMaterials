/**
 * Sample program to test
 * the use of different Access Modifiers in Java.
 */

public class AccessModifiers
{
	public static void main(String[] args)
	{
		/**
		 * Create a Student1 object
		 * using the following values:
		 * String name Jane
		 * double array of courses 4.0, 3.4, 2.8
		 * Print out the value of the gpa.
		 */
		String firstName = new String("Bob");
		double[] firstCourses = {3.0, 3.0, 2.9, 3.1};
		Student1 first = new Student1(firstName, firstCourses);
		System.out.println(first.getGPA());

		/**
		 * Create a Student2 object
		 * using the following values:
		 * String name Bob
		 * double array of courses 3.0, 2.0, 2.9, 3.1
		 * Print out the value of the gpa.
		 * Since the internal method calculateGPA is now public,
		 * attempt to call it on an array of all 4.0
		 */
		String secondName = new String("Jane");
		double[] secondCourses = {4.0, 3.4, 2.8};
		Student2 second = new Student2(secondName, secondCourses);
		System.out.println(second.getGPA());
		double[] newCourses = {4.0, 4.0, 4.0};
		second.calculateGPA(newCourses);
		System.out.println(second.getGPA());

		/**
		 * Create a Student3 object
		 * using the following values:
		 * String name Mary
		 * double array of courses 2.9, 3.8, 3.5, 3.0
		 * Print out thevalue of gpa.
		 * Since the gpa instance variable is now public,
		 * attempt to directly access it and change it,
		 * and print out the value of gpa afterwards. 
		 */
		String thirdName = new String("Mary");
		double[] thirdCourses = {2.9, 3.8, 3.5, 3.0};
		Student3 third = new Student3(thirdName, thirdCourses);
		System.out.println(third.getGPA());
		third.gpa = 0.0;
		System.out.println(third.getGPA());
	}
}

/**
 * Make a Student1 class
 * The instance variables needed are
 * String for name,
 * double for gpa,
 * and int for number of courses.
 * Instance variables should have the access modifier private. 
 */

class Student1
{
	private String name;
	private double gpa;
	private int numCourses;

	/**
	 * Create a Student1 constructor
	 * that takes in a String for name
	 * and an array of doubles as courses.
	 * Reassign the number of courses int vaule
	 * to the length of the array of doubles.
	 * Call upon an internal method called calculate gpa
	 * with the double array.
	 */
	public Student1(String name, double[] courses)
	{
		this.name = name;
		numCourses = courses.length;
		calculateGPA(courses);
	}

	/**
	 * Create an internal method called calculateGPA
	 * that returns void, and takes in a double array.
	 * This method should iterate through the length of the double array
	 * and add each value to a temporary variable.
	 * At the end, this temporary variable's value
	 * should be divided by the number of courses int
	 * and then the result saved in the gpa double.
	 */

	private void calculateGPA(double[] courses)
	{
		double temp = 0.0;
		for(int i = 0; i < courses.length; i++)
		{
			temp = temp + courses[i];
		}
		temp = temp / courses.length;
		gpa = temp;
	}

	/**
	 * Optional: create a method called addGPA
	 * which takes a double array of courses
	 * to add the new scores to hte old GPA.
	 * This should be a public method and return void.
	 */

	public void addGPA(double[] courses)
	{
		double temp = 0.0;
		double oldCourses = gpa * numCourses;
		for (int i = 0; i < courses.length; i++)
		{
			temp = temp + courses[i];
		}
		temp = temp + oldCourses;
		numCourses = numCourses + courses.length;
		temp = temp / numCourses;
		gpa = temp;
	}

	/**
	 * Make a getter method
	 * to return the gpa.
	 */
	public double getGPA()
	{
		return gpa;
	}
}

/**
 * Make a class Student2
 * identical to Student1
 * except the internal method calculateGPA
 * is now public, and not private.
 * You can copy and paste Student1 over,
 * with just changing the class name, constructor name,
 * and access modifier of calculateGPA.
 */ 

class Student2
{
	private String name;
	private double gpa;
	private int numCourses;

	public Student2(String name, double[] courses)
	{
		this.name = name;
		numCourses = courses.length;
		calculateGPA(courses);
	}

	public void calculateGPA(double[] courses)
	{
		double temp = 0.0;
		for(int i = 0; i < numCourses; i++)
		{
			temp = temp + courses[i];
		}
		temp = temp / numCourses;
		gpa = temp;
	}

	public void addGPA(double[] courses)
	{
		double temp = 0.0;
		double oldCourses = gpa * numCourses;
		for (int i = 0; i < courses.length; i++)
		{
			temp = temp + courses[i];
		}
		temp = temp + oldCourses;
		numCourses = numCourses + courses.length;
		temp = temp / numCourses;
		gpa = temp;
	}
	public double getGPA()
	{
		return gpa;
	}
}

/**
 * Make a class Student3
 * which is identical to the first one
 * except all instance variables are public.
 * You can copy and paste Student1 over,
 * just changing the access modifiers of the instance variables.
 */


class Student3
{
	public String name;
	public double gpa;
	public int numCourses;

	public Student3(String name, double[] courses)
	{
		this.name = name;
		numCourses = courses.length;
		calculateGPA(courses);
	}

	private void calculateGPA(double[] courses)
	{
		double temp = 0.0;
		for(int i = 0; i < courses.length; i++)
		{
			temp = temp + courses[i];
		}
		temp = temp / courses.length;
		gpa = temp;
	}

	public void addGPA(double[] courses)
	{
		double temp = 0.0;
		double oldCourses = gpa * numCourses;
		for (int i = 0; i < courses.length; i++)
		{
			temp = temp + courses[i];
		}
		temp = temp + oldCourses;
		numCourses = numCourses + courses.length;
		temp = temp / numCourses;
		gpa = temp;
	}

	public double getGPA()
	{
		return gpa;
	}
}
