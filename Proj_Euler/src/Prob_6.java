
/*
 * The sum of the squares of the first ten natural numbers is,
 * 				1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is,
 * 				(1 + 2 + ... + 10)^2 = 552 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers 
 * and the square of the sum is 3025 − 385 = 2640. Find the difference between the sum 
 * of the squares of the first one hundred natural numbers and the square of the sum.
 * 
 */

/*
 * SOLUTION: The sum of the squares for the range 1 to n is given by: 
 * 				Summation{i=1, i=N} (c_i)^2 
 * which is equal to: 
 * 		 		(c_1)^2 + (c_2)^2 + ....
 * The square of the sum for the range 1 to n is: 
 * 				(Summation{i=1, i=N} c_i)^2
 * or, when you distribute,
 * 				(c_1)^2 + (c_1)Summation{i=2, i=N}c_i + ...
 * In general, for the nth term the above summation must skip the nth index. Thus subtracting 
 * you get:
 *				 Summation{i=1, i=N}(c_i * (Summation{j=1, j=N, skip term when j=i}c_i))				
 */
public class Prob_6 {

	public static void main(String[] args) {
		int upperBound = 100;
		int difference = 0; 
		
		for (int i = 1; i <= upperBound; i ++)
			difference += i*sumTo(i, upperBound); 
		
		System.out.println("The difference of the square of the sum and the sum of"
				+ " the squares from 1 to " + upperBound + " is: " + difference);
	}
	
	/*
	 * @param int numToSum			the number will exclude from the summation			
	 * @param int bound				the upper limit of the summation formula 
	 * 
	 * @return						the sum from 1 to bound for all numbers excluding numToSum 								
	 */
	public static int sumTo (int numToSum, int bound){
		int sum = (bound*(bound + 1))/2 - numToSum; 
		return sum;
	}
}
