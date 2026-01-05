import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int L = in.nextInt();
        int N = in.nextInt();

        int[] cuts = new int[N+2];
        cuts[0] = 0;
        cuts[N+1] = L;

        for (int i = 1; i < N+1; i++){
            cuts[i] = in.nextInt();
            //System.out.println(cuts[i]);
        }

        int[][] costs = new int[N+2][N+2];

        for (int start = 0; start < N+1; start++){
            int end = start+1;
            costs[start][end] = 0;
        }

        for (int segments_used = 2; segments_used < N+2; segments_used++){
            for (int start = 0; start < N+2-segments_used; start++){
                int end = start+segments_used;
                int segment_price = cuts[end]-cuts[start];
                int min = Integer.MAX_VALUE;
                for (int split = start + 1; split < end; split++){
                    int diff = costs[start][split] + costs[split][end];
                    if (diff < min){
                        min = diff;
                    }
                    //System.out.println(start + " " + split + " " + end + " " + min + " " + segment_price);
                }
                costs[start][end] = min + segment_price;
            }
        }

        /*
        for (int i = 0; i < N+2; i ++){
            for (int j = 0; j < N+2; j ++){
                System.out.print(costs[i][j] + " ");
            }
            System.out.println();
        }
        */
        System.out.println(costs[0][N+1]);
    }
}
