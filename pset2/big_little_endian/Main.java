import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int nCopy = n;

        int convert = 0;

        for (int i = 3; i > -1; i--){
            convert += (n&~((~0) << 8)) << 8*i;
            n = n >> 8;
        }

        System.out.print(nCopy + " converts to " + convert);
    }
}
