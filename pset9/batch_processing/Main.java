//divide n conquer to find max load to put on machines
    //from the back
    //you can do a binary search for.. something?
//greedy to pick as many jobs as u can w/o shifting division pts
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
        int right = 0;
        for (int i = 0; i < N; i++){
            arr[i] = in.nextInt();
            right += arr[i];
        }

        int left = arr[N-1];
        int mid = (left + right)/2;

        int answer = right;
        while(left <= right){
            mid = (left + right)/2;
            if (check(mid)){
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        long sum = 0;
        int groups = M;
        System.out.print(arr[0]);
        for (int i = 1; i < N; i++) {
            if (sum + arr[i] > answer || (N - i == M - groups)) {
                System.out.print(" /");
                groups++;
                sum = 0;
            }
            sum += arr[i];
            System.out.print(" " + arr[i]);
        }
        System.out.println();
        //System.out.print(answer);
    }

    public static boolean check(int answer){
        int count = 1;
        long sum = 0;
        for (int i = 0; i < N; i++){
            if (arr[i] > answer){
                return false;
            }
                
            if (sum + arr[i] > answer){
                count++;
                sum = arr[i];
            } else{
                sum += arr[i];
            }
        }
        
        return (count <= M);
    }
}


