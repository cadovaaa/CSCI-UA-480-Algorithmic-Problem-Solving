import java.util.*;

public class Main {
    public static int[] next;
    public static int[] seen;
    public static BitSet curr_seen;
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        next = new int[N+1];
        seen = new int[N+1];
        curr_seen = new BitSet(N+1);

        for (int i = 1; i < N+1; i++){
            next[i] = in.nextInt();
            seen[i] = -1;
        }

        int best_event = 1;
        int max_events = 0;
        for (int i = 1; i < N+1; i++){
            if (seen[i] == -1){
                curr_seen.clear();
                search(i);
            }
           
            if (seen[i] > max_events){
                max_events = seen[i];
                best_event = i;
            }
            
            //System.out.println(seen[i]);
        }

        System.out.println(best_event);
    }

    public static int search(int index) {
        //System.out.println(index);
        if (seen[index] != -1){
            return seen[index];
        }
        curr_seen.set(index);

        int curr = next[index];
        if (curr_seen.get(curr)){
            int cycle_length = 1;
            while (curr != index){
                cycle_length++;
                curr = next[curr];
            }

            curr = next[index];
            while (curr != index){
                seen[curr] = cycle_length;
                curr = next[curr];
            }
            seen[index] = cycle_length;
            
            return cycle_length;
        }


        int events_triggered = search(next[index]);
        
        if (seen[next[index]] != seen[index]) {
            events_triggered++;
        }
        
        seen[index] = events_triggered;
        return events_triggered;
    }
}
