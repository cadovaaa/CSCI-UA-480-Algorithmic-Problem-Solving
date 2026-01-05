import java.util.*;

public class Main {
    static int T;
    static int[][] paths = new int[21][21];
    static int count;

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        T = in.nextInt();
        while (true){
            int temp = in.nextInt();
            int temp2 = in.nextInt();
            if (temp == 0){
                break;
            }
            paths[temp][temp2] = 1;
            paths[temp2][temp] = 1;
        }

        BitSet visited = new BitSet(21);
        visited.set(1);
        dfs(1, "1", visited);
        System.out.print("There are " + count + " routes from the initial position to corner " + T + ".");
    }

    public static void dfs(int node, String path, BitSet visited) {
        if (node == T) {
            System.out.println(path);
            count++;
        }
        
        for (int next = 1; next < 21; next++) {
            if (paths[node][next] == 1 && !visited.get(next)) {
                BitSet visited_copy = (BitSet) visited.clone();
                visited_copy.set(next);
                dfs(next, path + " " + next, visited_copy);
            }
        }
        return;
    }
}
