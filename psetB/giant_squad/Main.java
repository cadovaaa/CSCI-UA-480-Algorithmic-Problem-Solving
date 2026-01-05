import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int entry = 0;
        for (int i = 0; i < N/2+1; i++){
            entry = in.nextInt();
        }

        System.out.println(entry);
    }
}
