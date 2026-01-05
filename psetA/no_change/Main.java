import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int M = in.nextInt();
        int N = in.nextInt();

        int[] coins = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            coins[i] = in.nextInt();
            sum += coins[i];
        }

        int[] coins_used = new int[sum + 1];
        coins_used[0] = 0;
        for (int i = 1; i < sum + 1; i++){
            coins_used[i] = Integer.MAX_VALUE-20;
        }

        for (int c : coins) {
            for (int i = sum; i >= c; i--) {
                coins_used[i] = Math.min(coins_used[i], coins_used[i - c] + 1);
            }
        }


        for (int i = M; i <= sum; i++){
            if (coins_used[i] < Integer.MAX_VALUE-20){
                System.out.println(i + " " + coins_used[i]);
                 return;
            }
        }
    }    
}
