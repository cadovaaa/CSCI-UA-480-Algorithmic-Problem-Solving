import java.util.*;

public class Main {
    static int N;
    static int H;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        N = in.nextInt();
        H = in.nextInt();
        char[] arr = new char[N];
		recurse(arr, 0, 0);
	}
	
	public static void recurse(char[] seq, int count1, int count0) {
		if (N == count0 + count1) {
			System.out.println(seq);
		}
		
        if (count1 + (N - H) < H) {
            return;
        }

		if (count0 < (N - H)) {
			seq[count1 + count0] = '0';
			recurse(seq, count1, count0 + 1);
		}
		
		if (count1 < H) {
			seq[count1 + count0] = '1';
			recurse(seq, count1 + 1, count0);
		}
	}
}

