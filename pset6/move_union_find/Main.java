import java.util.*;
import java.awt.*;

public class Main {
    public static int[] pointerArr;
    public static long[] sumArr;
    public static int[] nodeLocationArr;
    public static int nextNode;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

        int numNodes = in.nextInt();
        int numCommands = in.nextInt();
        pointerArr = new int[numNodes + numCommands + 1];
        sumArr = new long[numNodes + numCommands + 1];
        nodeLocationArr = new int[numNodes + 1];
        nextNode = numNodes + 1;

        for (int i =  1; i < numNodes+1; i++){
            pointerArr[i] = -1;
            sumArr[i] = i;
            nodeLocationArr[i] = i;
        }

        for (int i =  0; i < numCommands; i++){
            int command = in.nextInt();
            if (command == 1){
                merge(in.nextInt(),in.nextInt());
            } else if (command == 2){
                move(in.nextInt(),in.nextInt());
            } else if (command == 3){
                show(in.nextInt());
            }
        }
    }

    public static int find(int i){ //i is index of pt to find root of 
        if (pointerArr[i] < 0){
            return i;
        }
        int temp = find(pointerArr[i]);
        pointerArr[i] = temp;
        return (temp);
    }

    public static void merge(int i, int k){ //i,j are indexes to merge trees of
        int root1 = find(nodeLocationArr[i]);
        int root2 = find(nodeLocationArr[k]);
        if (root1 == root2){
            return;
        }
        if (pointerArr[root1] <= pointerArr[root2]){
            pointerArr[root1] += pointerArr[root2];
            sumArr[root1] += sumArr[root2];
            pointerArr[root2] = root1;
        }
        else if (pointerArr[root1] > pointerArr[root2]){
            pointerArr[root2] += pointerArr[root1];
            sumArr[root2] += sumArr[root1];
            pointerArr[root1] = root2;
        }
    }

    public static void move(int i, int k){ //i,j are indexes to move
        int root1 = find(nodeLocationArr[i]);
        int root2 = find(nodeLocationArr[k]);
        if (root1 == root2){
            return;
        }

        pointerArr[root1] += 1;
        pointerArr[root2] -= 1;

        nodeLocationArr[i] = nextNode;
        nextNode++;
        pointerArr[nodeLocationArr[i]] = root2;

        sumArr[root1] -= i;
        sumArr[root2] += i;
    }

    public static void show(int i){
        int root1 = find(nodeLocationArr[i]);
        System.out.println((pointerArr[root1] * -1) + " " + (sumArr[root1]));
    }
}
