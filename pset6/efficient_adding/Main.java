import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();

        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        long temp;
        for (int i = 0; i < n; i++){
            temp = in.nextInt();
            minHeap.add(temp);
        }

        long count = 0;
        while (minHeap.size()>1){
            temp = minHeap.poll();
            temp += minHeap.poll();
            count += temp;
            minHeap.add(temp);
        }
        
        System.out.println(count);
    }
}
