//have array, keep track of head + tail
//keep track of # of D and if its > len then return error
//when printing keep track of whether R is odd/even and if odd print using i--
import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String instructions = in.nextLine();
        int n = in.nextInt();
        String line = in.nextLine();
        line = in.nextLine();
        String[] arr = line.split(",");

        if (n!=0){
            arr[0] = arr[0].substring(1,arr[0].length());
            arr[arr.length-1] = arr[arr.length-1].substring(0,arr[arr.length-1].length()-1);
        }

        int head = 0;
        int tail = n-1;
        int arrLength = n;
        boolean reversed = false;

        for (int i = 0; i < instructions.length(); i++){
            if (instructions.charAt(i) == 'R'){
                reversed = !reversed;
            }
            else{ 
                if (arrLength == 0){
                    System.out.println("error");
                    return;
                }
                
                if (reversed){
                    tail -= 1;
                } else {
                    head += 1;
                }
                arrLength -= 1;
            }
        }

        System.out.print("[");
        if (!reversed && arrLength != 0){
            for (int i = head; i < tail; i++){
                System.out.print(arr[i] + ",");
            }
            System.out.print(arr[tail]);
        } else if (arrLength != 0){
            for (int i = tail; i > head; i--){
                System.out.print(arr[i] + ",");
            }
            System.out.print(arr[head]);
        }
        System.out.println("]");
    }
}
