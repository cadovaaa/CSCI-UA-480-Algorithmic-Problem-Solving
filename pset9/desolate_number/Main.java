//as long as i have a pair of 1s remaining i concatenate these blocks: 101
    //pad w 0s if there are more after
import java.util.*;
import java.lang.*;
import java.math.*;


public class Main {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int ones = in.nextInt();
        int zeroes = in.nextInt();
        StringBuilder number = new StringBuilder();

        while (ones > 1 && zeroes > 0){
            number.append("101");
            ones -= 2;
            zeroes--; 
        }

        if (ones > 0 && zeroes > 0){
            number.insert(0,"1");
            ones--;
        }

        while (ones > 0 && zeroes == 0){
            number.append("1");
            ones--;
        }

        number.insert(0,"0");

        System.out.println(new BigInteger(number.toString(), 2));
    }
}
