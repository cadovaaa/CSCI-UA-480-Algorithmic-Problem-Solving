//traverse diagonally right down until you find a number greater than your max
//look at each row to find smallest value in the range
    //can do modified binary search
//find endpoint going down the diagonal to find max value in range 
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();

        int[][] arr = new int[N][M]; 
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                arr[i][j] = in.nextInt();
            }
        }

        int K = in.nextInt();
        for (int i = 0; i < K; i++){
            int P = in.nextInt();
            int Q = in.nextInt();
            int max_size = 0;
            for (int row = 0; row < N; row++) {
                //find smallest # above P in the row
                int left = 0;
                int right = M - 1;
                int column = M;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (arr[row][mid] >= P) {
                        column = mid;
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }

                //find largest square from this point
                for (int size = max_size; row + size < N && column + size < M; size++) {
                    if (arr[row + size][column + size] > Q){
                        break;
                    }
                    max_size = size + 1;
                }
            }
            System.out.println(max_size);
        }
    }
}
