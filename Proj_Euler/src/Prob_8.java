import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/*
 * The four adjacent digits in the 1000-digit number that have the greatest product are 9 × 9 × 8 × 9 = 5832.
 * 7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843
 * 8586156078911294949545950173795833195285320880551112540698747158523863050715693290963295227443043557
 * 6689664895044524452316173185640309871112172238311362229893423380308135336276614282806444486645238749
 * 3035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776
 * 6572733300105336788122023542180975125454059475224352584907711670556013604839586446706324415722155397
 * 5369781797784617406495514929086256932197846862248283972241375657056057490261407972968652414535100474
 * 8216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586
 * 1786645835912456652947654568284891288314260769004224219022671055626321111109370544217506941658960408
 * 0719840385096245544436298123098787992724428490918884580156166097919133875499200524063689912560717606
 * 0588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450
 * Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is 
 * the value of this product?
 */

/*
 * SOLUTION: Put the 1,000 digit number into a file. Read the file and put every integer, or character 
 * of the number, into an array. Next for a single number i, find the greatest 13-digit product found 
 * in the array. Do this for every i greater than one and less than 9 to find the greatest product of 13
 * digits. 
 */


public class Prob_8 {
	
	final static int adjacentDigits = 13; 
	final static int numberOfDigits = 1000; 
	
	public static void main(String[] args) throws IOException{
		try {
			File inputFile = new File("c:\\Users\\Hugo Lucas\\Documents\\Prob_8.txt"); 	
			ArrayList <Integer> listOfNumbers = toArray(inputFile, numberOfDigits); 
			
			long maxProduct = 0; 
			for ( int parseNum = 9; parseNum >= 1; parseNum --){
				long currentProduct = parseInput(parseNum, adjacentDigits, listOfNumbers); 
				if (currentProduct > maxProduct)
					maxProduct = currentProduct; 
			}
			
			System.out.println(maxProduct);
		} catch (Exception e) {
			System.out.println("Check your file path!");
			e.printStackTrace();
		}
	}
	
	/*
	 * @param int headNum				number that will trigger the calculation of the product
	 * @param int adjNum				number of adjacent numbers the product will be calculated from
	 * @param ArrayList<Integer> input	input array list that contains 1,000 digit number 
	 * @return product					the greatest possible product comprised of adjNum integers
	 */
	public static long parseInput (int headNum, int adjNum, ArrayList <Integer> numbers){
		long product = 0;
		for (int index = 0; index < numbers.size(); index ++){
			/*
			 * Looks for the specific "i" mentioned in the solution. If found, the 
			 * statement will also check if there are an additional 12 numbers ahead
			 * of the current number. Since the product must use 13 numbers, we 
			 * disregard any product comprised of less than 13 numbers.  
			 */
			if (headNum == numbers.get(index) & (index + adjNum) < numbers.size()){
				long product_i = numbers.get(index); 
				for (int i = 1; i <= adjNum-1; i++)
					product_i = product_i * numbers.get(index+i); 
				
				if ( product_i > product)
					product = product_i; 
			}
		}
		
		return product; 
	}
	
	/*
	 * @param File input					file containing the large digit number
	 * @param int digits					length of the number, in our case 1,000
	 * @return ArrayList<Integer> list		array list containing each digit of the large number
	 */
	public static ArrayList<Integer> toArray(File input, int digits) throws IOException{
		ArrayList<Integer> list = new ArrayList<Integer> (digits);
		BufferedReader fileReader = new BufferedReader(new FileReader (input)); 
		
		char[] buf = new char[1000];
		fileReader.read(buf);
		
		int index = 0; 
		while (index <= buf.length - 1){
			list.add(Character.getNumericValue(buf[index])); 
			index ++; 
		}
		
		fileReader.close(); 
		return list; 
	}
}
