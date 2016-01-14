/*
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */

/*
 * SOLUTION: Sum all the 3's that are less than the lower bound using the formula
 * 3*summation{n(n+1)/2} where n is the number of 3's below the upper limit (e.g. there
 * are three 3's that are below 10 thus the sum of all 3 multiples is 3*(3*4)/2 = 18). Do this
 * for 5 as well. Now you will have added the multiple of 15 twice. Use another
 * summation formula to subtract that out. 
 * 
 */
public class Prob_1 {

	public static void main(String[] args) {
		//Going to test if method sumMultiplesWorks
		int upB = 10;
		System.out.println("The sum of all multiples of 3 and 5 from 0 to " + 
				(upB - 1) + " is: " + sumMultiples(upB));
		
		//Solution to problem
		upB = 1000;
		System.out.println("The sum of all multiples of 3 and 5 from 0 to " + 
				(upB - 1) + " is: " + sumMultiples(upB));
	}
	
	/*
	 * @param int upperBound	end point of loop for multiples of 3 & 5
	 * @return					sum from 0 to upperBound - 1 of multiples of 3 & 5 
	 */
	public static int sumMultiples (int upperBound){
		int sum = 0; 
		
		//Integers representing the amount of times 3, 5, & 15 appear from 0 to upperBound - 1
		int limit3 = (upperBound - 1) / 3;
		int limit5 = (upperBound - 1) / 5; 
		int limit15 = (upperBound - 1) / 15; 
		
		//Summation formula described above
		sum += 3 * limit3 * (limit3 + 1) / 2; 
		sum += 5 * limit5 * (limit5 + 1) / 2; 
		sum -= 15 * limit15 * (limit15 + 1) / 2; 
		
		return sum; 
	}
}
