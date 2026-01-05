import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int arr[] = new int[N];
        int prev = 0;
        int curr = 0;
        for (int i = 0; i < N; i++){
            curr = in.nextInt();
            arr[i] = curr-prev;
            prev = curr;
        }

        int max = -1;
        int rocket_power = 0;
        int curr_power = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > max){
                max = arr[i];
                rocket_power = max;
                curr_power = max-1;
            } else if (arr[i] == curr_power){
                curr_power--;
            } else if (arr[i] > curr_power){
                rocket_power++;
                curr_power = rocket_power;
            }
            //System.out.println(curr_power);
        }
        System.out.println(rocket_power);
    }
}
