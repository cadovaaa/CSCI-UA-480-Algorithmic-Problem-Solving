import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        
        long N = in.nextLong();
		long L = in.nextLong();
		long R = in.nextLong();
		//long x = (~N)&(~(0L)>>>32); //32 bits with only the ones not in N set\
		long x = L;

		for (int i = 31; i > -1; i--){
			long candidate = x | (1L << i);
            if (candidate <= R) {
                if ((candidate | N) > (x | N)) {
                    x = candidate;
                }
            }
		}

		System.out.println(x);
    }
}
