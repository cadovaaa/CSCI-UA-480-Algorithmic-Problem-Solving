import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
		int size = n/(2*3*5);

        BitSet numbers = new BitSet(size+1); //a bit for 0 through 20,000,000 -> will never make use of 0 or 1 but makes my life easier
        numbers.set(2,size+1); //set all bits to 1 -> prime (don't need potential count is always behind the next actual prime in the list)
        LinkedList<Integer> primes = new LinkedList<>();

        for (int i = 2; i < size+1; i++){
            if (numbers.get(i)){ //if the loop is still marked prime by the time the loop gets there
				primes.add(i);
				for (int j = i*i; j < size+1 && j > 0; j += i){ //set multiples starting at count^2 false (multiples under already false)
					numbers.set(j,false); 
                }
            }
        }

		int count = 0;
		for (int i = 0; i < primes.size(); i++) {
            int p1 = primes.get(i);
            if (p1 * p1 * p1 * p1 > n || p1 * p1 * p1 * p1 < 0) {
				break;
			} 
            for (int j = i+1; j < primes.size(); j++) {
                int p2 = primes.get(j);
                if (p1 * p2 * p2 * p2 > n || p1 * p2 * p2 * p2 < 0) {
					break;
				}
                for (int k = j+1; k < primes.size(); k++) {
                    int p3 = primes.get(k);
                    if (p1 * p2 * p3 * p3 > n || p1 * p2 * p3 * p3 < 0) {
						break;
					}
                    for (int l = k+1; l < primes.size(); l++) {
                        int p4 = primes.get(l);
						long prod = (long)p1 * p2 * p3 * p4;
                        if (prod > n || prod < 0){
							break;
						}
                        count++;
                    }
                }
            }
        }
		System.out.println(count);
	}
}
