import java.util.*;

public class Main {
    public static int[] pointerArr;
    public static long[] sumArr;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        HashMap<Integer, Integer> groupMap = new HashMap<>();
        
        int numGroups = in.nextInt();
        Queue<Integer>[] subQueues = new LinkedList[numGroups];
        for (int i = 0; i < numGroups; i++){
            int numMembers = in.nextInt();
            for (int j = 0; j < numMembers; j++){
                int member = in.nextInt();
                groupMap.put(member, i);
            }
            subQueues[i] = new LinkedList<>();
        }

        Queue<Integer> groupQueue = new LinkedList<>(); 

        while (true){
            String command = in.next();
            if (command.equals("Push")){
                int n = in.nextInt();
                int groupIndex = groupMap.get(n);
                Queue<Integer> subQueue = subQueues[groupIndex];
                if (subQueue.isEmpty()){
                    groupQueue.add(groupIndex);
                }
                subQueue.add(n);
            } 
            
            else if (command.equals("Pop")){
                int groupIndex = groupQueue.peek();
                Queue<Integer> subQueue = subQueues[groupIndex];
                System.out.println(subQueue.remove());
                if (subQueue.isEmpty()){
                    groupQueue.remove();
                }
            }
            
            else if (command.equals("Shutdown")){
                break;
            }
        }
    }
}
