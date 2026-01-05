import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Main{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        int entries;
        int count = 0;
        for (int line = 0; line < n; line++){
            entries = in.nextInt();
            for (int entry = 0; entry < entries; entry++){
                int tmp = in.nextInt();
                minHeap.add(tmp);
                maxHeap.add(tmp);
            }
            int max = maxHeap.poll();
            int min = minHeap.poll();
            count += max;
            count -= min;
            minHeap.remove(max);
            maxHeap.remove(min);
        }
        System.out.println(count);
    }
}
