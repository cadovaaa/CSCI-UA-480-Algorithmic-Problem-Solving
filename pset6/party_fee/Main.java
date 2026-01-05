import java.util.*;
import java.awt.*;

public class Main {
    public static Point[] arr;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

        int numPeople = in.nextInt();
        int numFriends = in.nextInt();
        arr = new Point[numPeople];

        for (int i =  0; i < numPeople; i++){
            arr[i] = new Point(-1,in.nextInt());
        }

        int temp;
        for (int i =  0; i < numFriends; i++){
            temp = in.nextInt();
            merge(temp, in.nextInt());
        }

        for (int i =  0; i < numPeople; i++){
            if (arr[i].x < 0 && arr[i].y != 0){
                System.out.println("IMPOSSIBLE");
                return;
            }
        }

        System.out.println("POSSIBLE");

    }

    public static int find(int i){ //i is index of pt to find root of 
        if (arr[i].x < 0){
            return i;
        }
        return (find(arr[i].x));
    }

    public static void merge(int i, int k){ //i,j are indexes to merge trees of
        int root1 = find(i);
        int root2 = find(k);
        if (root1 == root2){
            return;
        }
        if (arr[root1].x <= arr[root2].x){
            arr[root1].y += arr[root2].y;
            arr[root1].x += arr[root2].x;
            arr[root2].x = root1;
        }
        else if (arr[root1].x > arr[root2].x){
            arr[root2].y += arr[root1].y;
            arr[root2].x += arr[root1].x;
            arr[root1].x = root2;
        }
    }
}
