//just make all of them
//make sure ur actually using max
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int operations = in.nextInt();
		
		Stack<Integer> stack = new Stack<>();
		Queue<Integer> queue = new LinkedList<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

		boolean isStack = true;
		boolean isQueue = true;
		boolean isPrioQueue = true;
		
		for (int i = 0; i < operations; i++) {
			int instruction = in.nextInt();
			int number = in.nextInt();
			
			if (instruction == 1){
				stack.push(number);
				queue.add(number);
				maxHeap.add(number);
			}

			if (instruction == 2){
				
				if (stack.isEmpty()){
					isStack = false;
					isQueue = false;
					isPrioQueue = false;
					break;
				}
				
				if (isStack){
					if (stack.pop() != number){
						isStack = false;
					}
				}
				if (isQueue){
					if (queue.remove() != number){
						isQueue = false;
					}
				}
				if (isPrioQueue){
					if (maxHeap.poll() != number){
						isPrioQueue = false;
					}
				}
			}
		}
		
		if (!isStack && !isQueue && !isPrioQueue){
			System.out.println("impossible");
		} else if (isStack && !isQueue && !isPrioQueue){
			System.out.println("stack");
		} else if (!isStack && isQueue && !isPrioQueue){
			System.out.println("queue");
		} else if (!isStack && !isQueue && isPrioQueue){
			System.out.println("priority queue");
		} else {
			System.out.println("not sure");
		}
	}
}
