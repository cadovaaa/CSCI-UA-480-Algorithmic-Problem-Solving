import java.util.Scanner;
import java.util.BitSet;

public class Main{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int m = in.nextInt();
        
        BitSet initial = new BitSet((int)Math.pow(2,s));
        initial.set(0,(int)Math.pow(2,s));
        for (int i = 0; i < m; i++){
            int temp = in.nextInt();
            initial.set(temp-1,false);
        }

        BitSet bs1 = new BitSet((int)Math.pow(2,s-1));
        BitSet bs2 = new BitSet((int)Math.pow(2,s-1));
        BitSet result = new BitSet((int)Math.pow(2,s-1));
        int count = 0;

        for (int k = 0; k < Math.pow(2,s); k++){
            if (k%2 == 0){
                bs1.set(k/2, initial.get(k));
            } else{
                bs2.set(k/2, initial.get(k));
            }
        }

        for (int i = 0; i < s; i++){
            if (i > 0){
                for (int k = 0; k < Math.pow(2,s); k++){
                    if (k%2 == 0){
                        bs1.set(k/2, result.get(k));
                    } else{
                        bs2.set(k/2, result.get(k));
                    }
                }
            }

            result = (BitSet) bs1.clone(); //save in bs1 at result
            
            bs1.xor(bs2);
            count += bs1.cardinality();

            result.or(bs2); 
            bs1.clear();
            bs2.clear();
        }
        System.out.print(count);
    }
}
