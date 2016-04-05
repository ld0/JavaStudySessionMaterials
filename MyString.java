public class MyString
{
	private char[] array;
	private int size;

	public MyString(char[] input)
	{
		array = input;
		size = input.length;
	}

	public int length()
	{
		return size;
	}

	private void newData(char[] data)
	{
		array = data;
		size = data.length;
	}

	public char charAt(int index)
	{
		return array[index];
	}

	public void concat(MyString newString)
	{
		int newSize = size + newString.length();
		char[] temp = new char[newSize];
		for (int i = 0; i < size; i++)
		{
			temp[i] = this.charAt(i);
		}
		int j = 0;
		for (int i = size; i < newSize; i++)
		{
			temp[i] = newString.charAt(j);
			j++;
		}
		newData(temp);
	}

	public void mytoString()
	{
		for (int i = 0; i < (size); i++)
		{
			System.out.print(charAt(i));
		}
		System.out.print("\n");
	}
}






