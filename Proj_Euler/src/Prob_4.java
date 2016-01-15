import java.util.ArrayList;
import java.util.Collections;

/*
 * A palindromic number reads the same both ways. The largest palindrome made from the 
 * product of two 2-digit numbers is 9009 = 91 × 99.
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */

/*
 * SOLUTION: Starting from 999, n_left, to 100, I will calculate the product of n_left with every 
 * number from 100 - 999, or n_right. I will then check to see if the product of n_left and 
 * n_right is a palindrome. This should produce a list of all palindromes resulting from 
 * the product of two 3-digit numbers.  
 */
public class Prob_4 {

	public static void main(String[] args) {
		int n_left = 999; 
		int n_right = 999; 
		
		ArrayList<Integer> pal_List = new ArrayList<Integer>(); 
		while (n_left >= 100){
			while (n_right >= 100){
				if (isPalindrome(n_right*n_left))
					pal_List.add(n_right*n_left);
				
				n_right --;
			}
			n_left --; 
			n_right = 999; 
		}
		
		Collections.sort(pal_List);
		System.out.println(pal_List.get(pal_List.size()-1));
	}
	
	/*
	 * @param int number		Integer we want test is a palindrome
	 * @return 					Boolean value with result of test (true if number is palindrome)
	 */
	public static boolean isPalindrome( int number){
		//Covert the number to a string 
		String numTest = Integer.toString(number);
		
		/*
		 * Loop from the beginning to the midpoint to see if the number is a palindrome. 
		 * Will compare first & last digits in the first iteration, 2nd & last-1 digits 
		 * next, etc... 
		 */
		for (int i = 0; i < numTest.length()/2; i++ ){
			if (numTest.charAt(i) != numTest.charAt(numTest.length() - (1+ i)))
				return false; 
		}
		return true; 
	}
}
