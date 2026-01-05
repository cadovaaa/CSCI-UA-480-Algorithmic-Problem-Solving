import java.util.Scanner;
import java.lang.Math;

public class Main{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int index = 0;
        int a = 0;
        int b = 0;
        for (int i = 0; Math.pow(2,i)-1 < n;i++){
            if ((n&(1 << i)) > 0){
                if (index%2 == 0){
                    a += n&(1 << i);
                    index++;
                } else{
                    b += n&(1 << i);
                    index++;
                }
            }
        }
        System.out.println(a + " " + b);
    }
}
