//use max + min heap
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int median = -1;
        int n;

        while (in.hasNext()){
            n = in.nextInt();
            
            if (n > median){
                minHeap.add(n);    
            } else {
                maxHeap.add(n);
            }

            if (maxHeap.size() - minHeap.size() > 1){
                minHeap.add(maxHeap.poll());
            } else if (maxHeap.size() - minHeap.size() < -1){
                maxHeap.add(minHeap.poll());
            }

            if (maxHeap.size() - minHeap.size() == 1){
                median = maxHeap.peek();
            } else if (maxHeap.size() - minHeap.size() == -1){
                median = minHeap.peek();
            } else if (maxHeap.size() - minHeap.size() == 0){
                median = (maxHeap.peek() + minHeap.peek())/2;
            }

            System.out.println(median);
        }
    }
}
