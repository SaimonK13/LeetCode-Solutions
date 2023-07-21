/*
 * Name: Add Digits (LeetCode Problem 258)
 * Description: returns digital root of any non-negative integer
*/
public class AddDigits {
	
	//method 1: brute force solution
	static int method1(int num) {
		
		//return the input as result if single digit
		if (num < 10)
			return num;
		
		//else convert the int to an int array, add elements and store in t, and run method1 with t
		else {
			
			int t = 0;
			
			String s = Integer.toString(num);
			int[] arr = new int[s.length()];
			
			for(int k = 0; k < arr.length; k++) {
				
				arr[k] = Character.getNumericValue(s.charAt(k));
			}
			
			for (int j : arr) {
				t += j;
			}
			
			return method1(t);
		}
		
		
	    }
	
	//method 2: optimized solution
	static public int method2(int num) {
        if(num == 0)
        	return 0;
         
        if(num % 9 == 0) //if num is divisible by 9, return 9
        	return 9;
        
        return num % 9;
    }

	//main method
	public static void main(String[] args) {
		
		int n = 38;
		System.out.println("Method 1: " + method1(n));
		System.out.println("Method 2: " + method2(n));

	}
	
	
}
