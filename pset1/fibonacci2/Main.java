import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int max_n = in.nextInt();
        long arr[] = new long[max_n];
        for (long i:arr)
        {
            i = 0;
        }
        System.out.println(fib(max_n-1,arr));
    }

    public static long fib (int n, long[] arr){
        if (arr[n] != 0) {
            return arr[n];
        }
        else if (n<=1) {
            return n;
        }

        arr[n] = fib(n-1,arr) + fib(n-2,arr);
        return arr[n];
    }    
}
