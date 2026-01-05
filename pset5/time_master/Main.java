//balanced bst
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		PriorityQueue<Long> minHeap = new PriorityQueue<>();
		Map<Long,Long> dict = new HashMap<>();


		while (in.next().equals("Register")){
			long id = in.nextLong();
			long interval = in.nextLong();
			long register = interval*10000 + id;
			dict.put(id, interval);
			minHeap.add(register); 
		}

		int number = in.nextInt();
		for (int i = 0; i < number; i++){
			long register = minHeap.poll(); 
			long id = register % 10000;
			long interval = register/10000;
			
			System.out.println(id);

			register += dict.get(id) *10000;
			minHeap.add(register);
		}
	}
}


