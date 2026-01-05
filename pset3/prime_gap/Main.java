//find primes using the sieve and then calc all differences and then j find the lowest/largest
import java.util.Scanner;
import java.util.BitSet;

//adapted from my prime pairs solution
public class Main{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        int sqrtb = (int)Math.pow(b,0.5);
        BitSet numbers = new BitSet(sqrtb); //a bit for 0 through 20,000,000 -> will never make use of 0 or 1 but makes my life easier
        numbers.set(2,sqrtb+1); //set all bits to 1 -> prime (don't need potential count is always behind the next actual prime in the list)
        BitSet range = new BitSet(b-a+1); //for marking a to b range -> index 0 is a
        int protect_1 = 0;
        if (a == 1){
            protect_1 = 1;
        }
        range.set(protect_1,b-a+1);

        int a_start;
        for (int count = 2; count < sqrtb+1; count++){ //find the primes
            if (numbers.get(count)){ //if the loop is still marked prime by the time the loop gets there
                //System.out.println(count);
                for (int i = count*count; i < sqrtb+1; i += count){ //set multiples starting at count^2 false (multiples under already false)
                    numbers.set(i,false);
                }
                a_start = count*count;
                if (count*count < a){
                    a_start = a + (count - a%count);
                    if (a%count == 0){
                        a_start -= count;
                    }
                }
                if (a_start < 0){
                    a_start = 2147483647;
                }
                int b_end = b+1;
                if (b == 2147483647){
                    b_end = 2147483647;
                }
                //System.out.println("a_start: " + count);
                for (int i = a_start; i < b_end && i > 0; i += count){ //set multiples starting at count^2 false (multiples under already false)
                    if (i > 0){
                        //System.out.println(i);
                    }   
                    range.set(i-a,false);
                    
                }
            }
        }
        //System.out.println(range.toString());

        if (range.cardinality() < 2){ //if theres not 2 primes between a and b
            System.out.println(-1);
        } else {
            int prev = range.nextSetBit(0);
            int curr = range.nextSetBit(prev+1);
            int min_diff = curr-prev;
            int max_diff = curr-prev;
            int p1 = prev;
            int p3 = prev;
            int p2 = curr;
            int p4 = curr;
            while (curr != -1) {
                //System.out.println(prev + " " + curr);
                if (curr-prev < min_diff){
                    p1 = prev;
                    p2 = curr;
                    min_diff = curr-prev;
                    //System.out.println("min: " + min_diff);
                } if (curr-prev > max_diff){
                    p3 = prev;
                    p4 = curr;
                    max_diff = curr-prev;
                    //System.out.println("max: " + min_diff);
                }
                prev = curr;
                curr = range.nextSetBit(curr + 1);
            }
            System.out.println((p1+a) + " " + (p2+a) + " " + (p3+a) + " " + (p4+a));
        }
    }
}

