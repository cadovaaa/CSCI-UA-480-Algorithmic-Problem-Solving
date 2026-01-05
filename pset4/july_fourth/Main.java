import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        
        if (find(n,0)){
            System.out.println("July Fourth Family Number");
        } else{
            System.out.println("Not in the family");
        }
        
    }

    public static boolean find(long n, long d){
        if (d>n){
            return false;
        } else if (d != 0 && n % d == 0){
            return true;
        } else if (d<922337203685477580L){
            return (find(n, d*10+4) || find(n, d*10+7));
        } else{
            return false;
        }
    }
}
