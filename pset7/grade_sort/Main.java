import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int size = 0;
        String string_arr = "";
        try {
            size = Integer.parseInt(in.readLine());
            string_arr = in.readLine();
        } catch (IOException e) {
            System.err.println("error");
        }
        
        int arr_size = string_arr.length();
        int num = 0;
        int[] grades = new int[101];
        for (int i = 0; i < arr_size; i++){
            char temp = string_arr.charAt(i);
            if (temp == ' '){
                grades[num]++; 
                num = 0;
            } else{
                num *= 10;
                num += temp - '0';
            }
        }
        grades[num]++;

        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            int space_count = size;

            for (int i = 0; i < 101; i++){
                int count = grades[i];
                for (int j = 0; j < count; j++){
                    space_count--;
                    if (space_count != 0){
                        writer.write(i + " ");
                    } else {
                        writer.write(i + "\n");
                    }   
                }
            }
            writer.flush();
        } catch (IOException e) {
            System.err.println("error");
        }
    }
}
