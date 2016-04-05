/**
 * Super class Animal
 */

public class Animal
{
	/**
	 * All the below instance variables
	 * can be used with any subclass of type Animal
	 */
	private String name;
	private String type;
	private int age;

	/**
	 * Animal constructor
	 */
	public Animal(String name, String type, int age)
	{
		this.name = name;
		this.type = type;
		this.age = age;
	}

	/**
	 * All the below methods can be used
	 * by any subclass of class Animal
	 */
	
	public void changeName(String newName)
	{
		name = newName;
	}

	public void birthday()
	{
		age++;
	}

	public int getAge()
	{
		return age;
	}

	public String getName()
	{
		return name;
	}

	public String getType()
	{
		return type;
	}

	public boolean isType(String newType)
	{
		return (type.equals(newType));
	}
}

/**
 * class Dog extends Animal,
 * so Animal is a superclass and Dog is its superclass.
 */
class Dog extends Animal
{
		
	public Dog(String name, int age)
	{
		/** 
		 * using Animal's default constructor.
		 * Note that dog only takes two parameters, name and age,
		 * since "dog" is always the type.
		 */
		super(name, "dog", age);
	}

	/**
	 * this is a method of class Dog
	 * that is unique to it.
	 * Dog does not need to repeat any methods of class Animal to use them directly.
	 */ 
	public String bark()
	{
		return "bark";
	}

}

/**
 * Another subclass of Animal.
 */
class Cat extends Animal
{
	/**
	 * An instance variable of class Cat that doesn't exist in super class Animal
	 */
	private String purr;
	
	public Cat(String name, int age)
	{
		/**
		 * Using the super class' constructor,
		 * again with only one type. 
		 */
		super(name, "cat", age);
		/**
		 * a special instance variable of cat
		 */ 
		purr = "purr";
	}

	/**
	 * These two methods only exist in class Cat.
	 * Again, cat doesn't need to retype out the methods of its super class to use them. 
	 */
	public String meow()
	{
		return "meow";
	}

	public String purr(boolean ifPurr)
	{
		if (ifPurr) return purr;
		else return "";
	}
}


