import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
       
        int one = in.nextInt();
        int two = in.nextInt();
        int three = in.nextInt();
        int four = in.nextInt();
        int five = in.nextInt();
        int six = in.nextInt();

        int count = 0;
        
        count += six; //use all 6

        count += five; //use all 5
        one -= five * 11;
        if (one < 0){
            one = 0;
        }

        count += four; //use all 4
        two -= four * 5;
        if (two < 0){
            one += two * 4;
            two = 0;
        } if (one < 0){
            one = 0;
        }

        count += three/4; //use 3s in sets of 4
        three -= (three/4) * 4;
        if (three > 0){
            count++;
        }
        if (three == 3){ //use remaining 3s
            two -= 1;
            if (two < 0){ //if two == -1
                one -= 4;   
            }
            one -= 5;
        } else if (three == 2){
            two -= 3;
            if (two < 0){ // if two is -1 -2 or -3
                one += (two * 4);
            }
            one -= 6;
        } else if (three == 1){
            two -= 5;
            if (two < 0){
                one -= 7 - (two * 4);
            } 
            one -= 7;
        }
        if (two < 0){
            two = 0;
        }
        if (one < 0){
            one = 0;
        }

        count += two/9; //use twos in sets of 9
        two -= (two/9) * 9;
        if (two > 0){
            count++;
        }
        two -= 9;
        one += (two * 4);
        if (one < 0){
            one = 0;
        }

        count += one/36; //use ones in sets of 9
        one -= (one/36) * 36;
        if (one > 0){
            count++;
        }

        System.out.println(count);
    }
}
