import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        long[] arr = new long[N];
        arr[0] = in.nextLong();
        for (int i = 1; i < N; i++){
            long entry = in.nextInt();
            arr[i] = Math.max(entry,arr[i-1] + entry);
        }

        long max = arr[0];
        for (int i = 0; i < N; i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }

        System.out.println(max);
    }
}
