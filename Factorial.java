public class Factorial{

	public static void main(String[] args){
		//System.out.println(factorial(4));
		System.out.println(palindrome("apple"));
		System.out.println(palindrome("racecar"));

	}

	public static int factorial(int n){
		if (n == 1) return 1;
		return n * factorial(n-1);
	}

	public static boolean palindrome(String input){
		String result = "";
		result = trim(result, input, input.length() - 1);
		return result.equals(input);
	}

	private static String trim(String result, String input, int location){
		if (location < 0) return result;
		result = result + input.charAt(location);
		return trim(result, input, location - 1);
	}

}
