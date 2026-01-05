import java.util.*;

public class Main {
    static int M;
    static int N;
    static int[][] price;
    static int[] count;

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        M = in.nextInt();
        N = in.nextInt();
        count = new int[N];
        price = new int[N][20];
        for (int i = 0; i < N; i++){
            count[i] = in.nextInt();
            for (int j = 0; j < count[i]; j++){
                price[i][j] = in.nextInt();
            }
        }

        int sol = shop(M,0);
        if (sol <= 0){
            System.out.println("no solution");
            return;
        }
        System.out.println(sol);
    }

    public static int shop(int m, int level) {
        if (m < 0) {
            return Integer.MIN_VALUE;
        }
        if (level == N) {
            return (M - m);
        }

        int best = -1;
        int curr = -1;
        for (int i = 0; i < count[level]; i++) {
            curr = shop(m - price[level][i], level+1);
            if (curr > best){
                best = curr;
            }
        }
        return best;
    }
}
