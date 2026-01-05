import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[] arr = new int[N];
        int max_length = 0;
        int curr_length = 0;
        int left = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++){
            arr[i] = in.nextInt();
            
            while (set.contains(arr[i])){
                set.remove(arr[left]);
                left++;
                curr_length--;
            }

            set.add(arr[i]);
            curr_length++;

            if (curr_length > max_length){
                max_length = curr_length;
            }
        }
        
        System.out.println(max_length);
    }
}
