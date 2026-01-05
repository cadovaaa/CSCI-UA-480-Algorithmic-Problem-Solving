// do it recursively -> at every option can i or o -> end line of questioning when u get bad string idk lol
import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String start_word = in.nextLine();
        String goal = in.nextLine();
        
        System.out.println("[");
        move("","",start_word,"",start_word.length(),start_word.length(),goal);
        System.out.println("]");
    }

    public static void move (String stack, String end_word, String start_word, String moves_done, int output_count, int input_count, String goal){ //take in array of stack of size n, keeping string for past moves, and int for stack height
        //keep counter of what move # u are on
        if (input_count == 0 && output_count == 0 && end_word.equals(goal)){
            System.out.println(moves_done.substring(0,moves_done.length()-1));
        } else {
            if (input_count>0){
                move(stack + start_word.charAt(0), end_word, start_word.substring(1,start_word.length()), moves_done + "i ", output_count, input_count - 1, goal);
            }
            if (output_count>0 && output_count>input_count){
                move(stack.substring(0,stack.length()-1), end_word + stack.charAt(stack.length()-1), start_word, moves_done + "o ", output_count - 1, input_count, goal);
            }
        }
    }    
}
