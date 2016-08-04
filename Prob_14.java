import java.util.Arrays;

/**
 * Created by Hugo Lucas on 8/4/2016.
 * The algorithm is essentially base on this basic principle: store the number of steps it takes to reach 1 from a given number n.
 * Once n is encountered again rather than continuing to evaluate the Collatz sequence, we add the current number of steps
 * to the steps it took to reach 1 from n.
 */
public class Prob_14 {
    public static void main (String [] args) {

        /**
         * Creates table and fills it with dummy values
         */
        long[] stepsToCompletion = new long[1000000];
        Arrays.fill(stepsToCompletion, -1);

        /**
         * Rather than search the table for the maximum element, we keep track of the max steps and index
         * to save a bit of time
         */
        long steps = 0;
        long index = 0;
        for (long i = 1; i < stepsToCompletion.length; i++){
            long j = findSteps(i, stepsToCompletion);
            if (j > steps) {
                steps = j;
                index = i;
            }
        }

        System.out.println(index + ", " + steps);
    }

    /**
     * This performs the Collatz sequence algorithm and checks to see if the resulting number is in the table
     * of known steps
     * @param number    the starting number of the current Collatz sequence
     * @param array     the table storing all known steps to 1
     * @return          the number of steps it took to reach 1
     */
    public static long findSteps(long number, long [] array){
        long steps = 0, n = number;

        while(n != 1){
            if(n % 2 == 0)
                n = n / 2;
            else
                n = 3*n + 1;

            steps ++;

            /**
             * Checks table each iteration to see if the number of steps from the current number
             * to 1 is known.
             */
            if(n < array.length)
                if(array[(int)n] > -1){
                    steps += array[(int)n];
                    n = 1;
                }
        }
        array[(int)number] = steps;
        return steps;
    }
}
