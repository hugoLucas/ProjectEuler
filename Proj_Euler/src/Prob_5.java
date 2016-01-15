import java.util.ArrayList;

/*
 * 2520 is the smallest number that can be divided by each of the numbers 
 * from 1 to 10 without any remainder. What is the smallest positive number 
 * that is evenly divisible by all of the numbers from 1 to 20?
 */

/*
 * SOLUTION: I will only test the numbers 11-20, S,  since any number that is 
 * divisible by the numbers in S must also be divisible by any number from 
 * 1-10. Furthermore, any loop must increment by 20 in order 
 * to minimize the number of iterations and to make sure that the resulting 
 * number is divisible by the largest number in S.  
 */

public class Prob_5 {
	//I don't want an infinite loop so I will place a max number of iterations on my while loop
	final static int maxIterations = Integer.MAX_VALUE; 
	
	public static void main(String[] args) {
		//Create a list of all the multiples we will concern ourselves with
		ArrayList <Integer> multiples = new ArrayList <Integer> (10); 
		for (int i = 11; i <= 20; i++)
			multiples.add(i); 
		
		boolean foundNumber = false;			 
		long currentNumber = 0;  
		int iter = 0; 									//This will track the number of iterations
		
		long timeStart = System.currentTimeMillis(); 
		while (!foundNumber & iter <= maxIterations){
			iter += 1; 
			currentNumber += 20;						//Increment by 20 as stated above
			foundNumber = true; 						//Unless proven otherwise, assume the currentNumber what is needed
			
			for (int num : multiples)
				if ( currentNumber % num != 0){
					foundNumber = false; 
					break; 
				}
		}
		long timeEnd = System.currentTimeMillis(); 
		
		if (foundNumber == true){
			System.out.println("Number found: " + currentNumber);
			System.out.println("Found in " + iter + " iterations!");
			System.out.println("And in " + (timeEnd - timeStart) + " ms!");
		}
		else
			System.out.println("Refine your search algorithm!!!");
	}

}
