import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int baseFrom = in.nextInt();
        int baseTo = in.nextInt();
        String n = in.next();
        Boolean caught = false;
        String temp = "";

        try{
            temp = Long.toString(Long.parseLong(n, baseFrom), baseTo);
        } catch (Exception e){
             System.out.print(n + " is an illegal base " + baseFrom + " number");
             caught = true;
        }

        if (caught == false){
            System.out.print(n + " base " + baseFrom + " = " + temp.toUpperCase() + " base " + baseTo);
        }
    }
}
