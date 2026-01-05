import java.util.Scanner;
import java.util.BitSet;

public class Main{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        BitSet numbers = new BitSet(20000001); //a bit for 0 through 20,000,000 -> will never make use of 0 or 1 but makes my life easier
        numbers.set(2,20000000-2); //set all bits to 1 -> prime (don't need potential count is always behind the next actual prime in the list)
        
        int pair_count = 0; 
        int count = 1;
        while (pair_count<n){
            count++; //moved to top so count is at correct # when while loop finishes
            if (numbers.get(count)){ //if the loop is still marked prime by the time the loop gets there
                if (count < Math.pow(19999999,0.5)){
                    for (int i = count*count; i < 20000000; i += count){ //sets multiples starting at count^2 false
                        numbers.set(i,false); 
                    }
                }
                if (numbers.get(count-2)){ //has to be - as list isnt necessarily set properly for count+2
                    pair_count++;
                }
            }
        }
        System.out.println("(" + (count-2) + ", " + count + ")");
    }
}
