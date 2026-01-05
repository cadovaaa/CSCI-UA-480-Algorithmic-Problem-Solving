import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();

        long counter = 2;
        long sum = 1;
        while (counter * counter < n){
            if (n%counter == 0){
                sum += counter + n/counter;
            }
            counter++;
        }

        if (sum==n && n!=1){
            System.out.println("PERFECT");
        } else {
        System.out.println("NOT PERFECT");
        }
    }
}
