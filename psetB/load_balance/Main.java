import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();
        int[] arr = new int[M];
        double avg = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < M; i++){
            arr[i] = in.nextInt();
            avg += arr[i];
            maxHeap.add(arr[i]);
        }
        avg = avg/N;

        int[] nodes = new int[N];
        
        int nodes_left = Math.min(M,N);
        for (int i = 0; i < nodes_left; i++){
            nodes[N-i-1] = maxHeap.poll();
        }
        nodes_left = maxHeap.size();
        for (int i = 0; i < nodes_left; i++){
            nodes[i] += maxHeap.poll();
        }

        double imbalance = 0; 
        for (int i = 0; i < N; i++){
            //System.out.println(nodes[i]);
            imbalance += Math.abs(avg-nodes[i]);
        }

        System.out.printf("IMBALANCE = %.5f%n",imbalance);
    }
}
