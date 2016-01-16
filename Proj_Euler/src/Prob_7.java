/*
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 
 * 6th prime is 13.What is the 10,001st prime number?
 */

/*
 * SOLUTION: Use previous isPrime algorithm to find the 10,001st prime. Will add to an
 * array list, the size() method will track how many elements are in the array 
 */
import java.util.ArrayList;

public class Prob_7 {

	public static void main(String[] args) {
		ArrayList<Long> primeList = new ArrayList<Long>(10001); //Any prime greater than the 10,001 is not needed 
		
		long currentNumber = 2; 
		while (primeList.size() != 10001){
			if(isPrime(currentNumber))
				primeList.add(currentNumber); 
			currentNumber++; 
		}
		
		System.out.println(primeList.get(primeList.size()-1));
	}
	
	/*
	 * @param long candidate		the number we want to test if prime
	 * @return 						boolean value, true if number is prime 
	 */
	public static boolean isPrime (long candidate){
		if (candidate <= 3)									//Will not input 1, so any number less than 3 is prime
			return true; 
		else if (candidate % 2 == 0 || candidate % 3 == 0)	//Time saving condition, no odd or even number greater than 3 is prime
			return false; 
		
		long index = 5; 
		while (index*index <= candidate){					//Set limit to sqrt(n), e.g. i^2
			if (candidate % index == 0 || candidate % (index + 2) == 0)		
				return false; 
			
			index += 6; 									//Add 6 to skip odd & even numbers after 5
		}
		
		return true; 
	}
}
