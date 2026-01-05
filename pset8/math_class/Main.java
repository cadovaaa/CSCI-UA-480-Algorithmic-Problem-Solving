import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int N = in.nextInt();
		
        String[] arr = new String[N];
        for (int i = 0; i < N; i++){
            arr[i] = in.next();
        }

        Arrays.sort(arr, (x,y) -> (y+x).compareTo(x+y));

        for (int i = 0; i < N; i++){
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
