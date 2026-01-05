//use djset
import java.util.*;
import java.awt.*;

public class Main {
    public static int[] pointerArr;
    public static Point[] arr;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        double D = in.nextDouble();
        arr = new Point[N];
        pointerArr = new int[N];

        for (int i = 0; i < N; i++){
            pointerArr[i] = -1;
            arr[i] = new Point();
            arr[i].setLocation(in.nextDouble(),in.nextDouble());

            for (int j = 0; j < i; j++){
                if (arr[i].distance(arr[j]) <= D){
                    merge(i,j);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++){
            if (pointerArr[i] < 0){
                count++;
            }
        }

        System.out.print(count);
    }

    public static int find(int i){ //i is index of pt to find root of 
        if (pointerArr[i] < 0){
            return i;
        }
        return (find(pointerArr[i]));
    }

    public static void merge(int i, int k){ //i,j are indexes to merge trees of
        int root1 = find(i);
        int root2 = find(k);
        if (root1 == root2){
            return;
        }
        if (pointerArr[root1] <= pointerArr[root2]){
            pointerArr[root1] += pointerArr[root2];
            pointerArr[root2] = root1;
        }
        else if (pointerArr[root1] > pointerArr[root2]){
            pointerArr[root2] += pointerArr[root1];
            pointerArr[root1] = root2;
        }
    }
}
