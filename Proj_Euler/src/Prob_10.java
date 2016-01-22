/*
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 */
public class Prob_10 {
	
	final static long bound = 2000000; 
	
	public static void main(String[] args) {
		
		long currentNum = 2;
		long sum = 0; 
		
		while ( currentNum <= bound){
			if (isPrime(currentNum))
				sum+= currentNum; 
			
			currentNum ++; 
		}
		
		System.out.println(sum); 
	}

	public static boolean isPrime (long candidate){
		if (candidate <= 3)
			return true; 
		else if (candidate % 2 == 0 || candidate % 3 == 0)
			return false; 
		
		long index = 5; 
		while (index*index <= candidate){
			if (candidate % index == 0 || candidate % (index + 2) == 0)
				return false; 
			
			index += 6; 
		}
		
		return true; 
	}	
}
