import java.util.Scanner;
import java.util.Arrays;

public class Main{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        in.nextLine();

        String line = in.nextLine();
        String instructions[] = line.split(" ");
        
        char N = 'N';
        char x = 'x';
        char y = 'y';
        char z = 'z';
        char plus = '+';
        char minus = '-';
        String position = "+x";
        for (int i = 0; i < length-1; i++){
            //move to next instruction if no bend
            if (instructions[i].charAt(0) == N){
                continue;
            }

            if (position.charAt(1) == x){
                if (position.charAt(0) == plus){
                    position = instructions[i];
                } else {
                    if (instructions[i].charAt(0) != position.charAt(0)){
                        position = "-" + instructions[i].charAt(1);
                    } else {
                        position = "+" + instructions[i].charAt(1);
                    }
                }
            } else if (position.charAt(1) == y){
                if (instructions[i].charAt(1) == z){
                    continue;
                } else {
                    if (instructions[i].charAt(0) == position.charAt(0)){
                        position = "-x";
                    } else {
                        position = "+x";
                    }
                }
            } else if (position.charAt(1) == z){
                if (instructions[i].charAt(1) == y){
                    continue;
                } else {
                    if (instructions[i].charAt(0) == position.charAt(0)){
                        position = "-x";
                    } else {
                        position = "+x";
                    }
                }
            }
        }

        System.out.print(position);
    }
}
