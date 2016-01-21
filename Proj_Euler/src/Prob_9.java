
/*
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * 								a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2. There exists exactly one Pythagorean 
 * triplet for which a + b + c = 1000. Find the product a*b*c.
 */

/*
 * SOLUTION: Brute force the a and b by iterating through a from 1 to 1,000 and b from the current a to 1,000. 
 * The solutions where a + b + c > 1,000 should be ignored so the loops will terminate should the sum exceed 
 * 1,000. Furthermore, if c = sqrt(a^2 + b^2) is not an integer then the program will should ignore that current
 * iteration set. 
 */
public class Prob_9 {

	final static int additionCondition = 1000; 
	
	public static void main(String[] args) {
		int a = 1, b = 1;
		
		boolean stop = false; 
		while (a <= 1000 & !stop){
			while (b <= 1000){
				double c = calculateC(a,b); 
				
				/*
				 * Checks to see if a + b + c > 1,000. If so then
				 * the the while loop should terminate. 
				 */
				if (meetsAdditionCondition(a, b, (int)c) == 1)
					break; 
				
				/*
				 * Statement only true if a and b are both not even or odd and
				 * c is an integer (hence the mod 1 check).
				 */
				if (!bothOddOrEven(a, b) & (c%1 == 0)){
					if ( meetsAdditionCondition(a, b, (int)c) == 0){
						System.out.println(a + ", " + b + ", " + (int)c);
						System.out.println((int)c * a * b);
						stop = true; 
					}
				}
				b++;
			}
			
			b = a + 1; 
			a++; 
		}
	}
	
	/*
	 * Given a and b, this method will calculate c
	 */
	public static double calculateC (int a , int b){
		return  Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)); 
	}
	
	/*
	 * Returns true only if a and b are both not even or not odd.
	 * This is a fundamental property of pythog. triples so I figured
	 * I should include it in the program to save some time.  
	 */
	public static boolean bothOddOrEven (int a, int b){
		boolean bothEven = (a%2 == 0) & (b%2 == 0); 
		boolean bothOdd = (a%3 == 0) & (b%3 == 0);

		return bothEven || bothOdd; 
	}
	
	/*
	 * Space saving method to see how large the sum of a, b, and c is
	 */
	public static int meetsAdditionCondition (int a, int b, int c){ 
		if (a+b+c == additionCondition)
			return 0; 
		if (a+b+c < additionCondition)
			return -1; 
		return 1; 
	}
}
