/*
 * The sequence of triangle numbers is generated by adding the natural numbers. 
 * So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first 
 * ten terms would be:
 * 		1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 * Let us list the factors of the first seven triangle numbers:
 * 		1: 1
 * 		3: 1,3
 * 		6: 1,2,3,6
 * 		10: 1,2,5,10
 * 		15: 1,3,5,15
 * 		21: 1,3,7,21
 * 		28: 1,2,4,7,14,28
 * We can see that 28 is the first triangle number to have over five divisors.
 * What is the value of the first triangle number to have over five hundred 
 * divisors?
 */

/*
 * SOLUTION: Iterate through every possible triangular number and calculate the 
 * number of divisors. If the number of divisors is >= 501, then stop and print 
 * the result. 
 */

public class Prob_12 {
	
	final public static int divisorsNeeded = 500; 
	
	public static void main(String[] args) {
		for (int ith_TriNum = 1; ith_TriNum <= Integer.MAX_VALUE; ith_TriNum++){
			int div = numberOfDivisors(calculateTriangularNumber(ith_TriNum)); 
			if (div > divisorsNeeded){
				System.out.println("Success! " + calculateTriangularNumber(ith_TriNum));
				break; 
			}
			
			//System.out.println(calculateTriangularNumber(ith_TriNum));
		}
	}
	
	/*
	 * Using the basic summation law (n(n+1)/2) this will calculate the ith
	 * triangular number. 
	 */
	public static int calculateTriangularNumber (int i_th_triNum){
		return ((i_th_triNum)*(i_th_triNum + 1))/2; 
	}
	
	/*
	 * Using the method described here:
	 * http://mathschallenge.net/library/number/number_of_divisors
	 * we calculate the number of divisors. My first solution involved
	 * checking to see if the number % n, where n is 1->number/2, but 
	 * this solution took several minutes to run. 
	 */
	public static int numberOfDivisors (int number){
		if( number == 1)
			return 1; 
		else{
			int div = 2; 
			for(int i = 2; i <= Math.sqrt(number); i ++)
				if (number % i == 0)
					div = div + 2;
			
			return div;
		}
	}
}
