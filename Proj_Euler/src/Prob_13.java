import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Work out the first ten digits of the sum of the following one-hundred 
 * 50-digit numbers.
 * 
 * [See file for number]
 */

public class Prob_13 {
	
	final static int numberOfIntegers = 100;
	final static int lengthOfIntegers = 50;
	final static int numbersNeeded = 10; 
	
	static ArrayList<ArrayList<Integer>> inputMatrix;
	
	public static void main(String[] args) {
		try{
			
			File inputFile = new File("c:\\Users\\Hugo Lucas\\Documents\\Prob_13_Info.txt"); 
			inputMatrix = fileToMatrix(inputFile);  
			for(int i = addMatrix(inputMatrix).size() - 1; i > addMatrix(inputMatrix).size() - 10; i--)
				System.out.print(addMatrix(inputMatrix).get(i));
			
		}catch (IOException e){
			
			System.out.println("Check file path!");
			e.printStackTrace();
			
		}
	}
	
	public static ArrayList <Integer> addMatrix (ArrayList<ArrayList<Integer>> matrix){
		int ith_sum = 0, carryover = 0; 
		ArrayList <Integer> numList = new ArrayList<Integer> (lengthOfIntegers); 
		
		for(int i = lengthOfIntegers - 1; i >= 0; i--){
			ith_sum = carryover;
			
			for(int j = 0; j < numberOfIntegers; j++)
				ith_sum += matrix.get(j).get(i);
			
			numList.add(ith_sum % 10);
			
			carryover = (int) ith_sum / 10; 
		}
		
		numList.add(carryover); 
		
		return numList; 
	}

	public static ArrayList<ArrayList<Integer>> fileToMatrix (File input) throws IOException{
		
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>> (numberOfIntegers);
		for(int i = 0; i < numberOfIntegers; i++)
			matrix.add(new ArrayList<Integer>(lengthOfIntegers)); 
		
		BufferedReader fileReader = new BufferedReader(new FileReader (input));
		
		int row = 0; 
		while(fileReader.ready()){
			char buf[] = fileReader.readLine().toCharArray();
			for(int i = 0; i < buf.length; i ++)
				matrix.get(row).add(Character.getNumericValue(buf[i]));
			
			row ++; 
		}
		
		fileReader.close();
		return matrix;
	}
}
