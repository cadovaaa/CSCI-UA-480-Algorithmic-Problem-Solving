import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int capacity = in.nextInt();
		int number = in.nextInt();
		
		int[] weights = new int[number];
		for (int i = 0; i < number; i++){
			weights[i] = in.nextInt();
		}
		Arrays.sort(weights);
		
		int sum = 0;
		int count = 0;
		while (count < number-1 && (sum + weights[count+1]) <= capacity){
			sum += weights[count];
			count++;
		}
		if (sum + weights[count] <= capacity){
			count++;
		}
		System.out.print(count);

	}

}
