//smth smth doesnt matter if sort is stable
import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		PriorityQueue<Long> minHeap = new PriorityQueue<>(Collections.reverseOrder());

        int problems = in.nextInt();
		for(int i = 0; i < problems; i++){
			long solve_time = in.nextLong();
			long grade_time = in.nextLong();
			long problem = grade_time*100000 + solve_time;
			minHeap.add(problem); 
		}

        long start_time = 0;
        long max_grade_time = 0;
		for (int i = 0; i < problems; i++){
			long problem = minHeap.poll(); 
			long solve_time = problem % 100000;
			long grade_time = problem/100000;

			start_time += solve_time;
            if (max_grade_time < grade_time+start_time){
                max_grade_time = grade_time+start_time;
            }
		}

        System.out.println(max_grade_time);
    }
}
