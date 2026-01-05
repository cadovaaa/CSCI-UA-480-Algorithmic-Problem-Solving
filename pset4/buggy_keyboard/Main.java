import java.util.Scanner;
import java.util.Stack;

public class Main{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String n = in.nextLine();
        
        StringBuilder keys = new StringBuilder();
        for (int i = 0; i < n.length(); i++){
            if (n.charAt(i) == '<'){
                if (keys.length() > 0){
                    keys.deleteCharAt(keys.length() - 1);
                }
            } else{
                keys.append(n.charAt(i));
            }
        }
        System.out.print(keys.toString());
    }
}
