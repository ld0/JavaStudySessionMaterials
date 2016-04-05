class AnimalStartup
{
	public static void main(String[] args)
	{
		Dog pitbull = new Dog("Princess", 5);
		System.out.println(pitbull.getType());	// using one of the methods of class Animal directly
		System.out.println(pitbull.bark());		// using one of class Dog's own methods

		Cat tomCat = new Cat("Tom", 10);
		System.out.println(tomCat.getAge());	// using one of the methods of class Animal directly
		tomCat.birthday();
		System.out.println(tomCat.getAge());	// using one of the methods of class Animal directly
		System.out.println(tomCat.purr(true));	// usign one of class Cat's own methods

	}
}
