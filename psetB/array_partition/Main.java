import java.util.*;

public class Main {
    static int[] arr;
    static int N;
    static int M;
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        M = in.nextInt();

        arr = new int[N];
        long high = 0;
        for (int i = 0; i < N; i++){
            arr[i] = in.nextInt();
            high += arr[i];
        }

        long low = 0;
        long mid = -1;
        while(low < high){
            //System.out.println(low + " " + high);
            mid = (low + high)/2;
            if (check(mid)){
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        mid = (low + high)/2;
        System.out.println(mid);
    }

    public static boolean check(Long mid){
        int count = 1;
        long sum = 0;
        for (int i = 0; i < N; i++){
            if (arr[i] > mid){
                return false;
            }
                
            if (sum + arr[i] > mid){
                count++;
                sum = arr[i];
            } else{
                sum += arr[i];
            }
        }
        
        return (count <= M);
    }
}
