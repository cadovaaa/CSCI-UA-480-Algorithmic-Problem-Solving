import java.io.*;
import java.util.*;

public class Main {
    static int[] volume;
    static String max;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        volume = new int[N];
        int sum = 0;
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int entry = Integer.parseInt(st2.nextToken());
            if (entry > W || sum > W * 2) {
                N = i;
                break;
            }
            sum += entry;
            volume[i] = entry;
        }

        max = "";
        put(0, W, W, "");

        System.out.println(max.length());
        for (int i = 0; i < max.length(); i++) {
            if (max.charAt(i) == '1') {
                System.out.println("1st");
            } else if (max.charAt(i) == '2') {
                System.out.println("2nd");
            }
        }
    }

    public static void put(int i, int capacity1, int capacity2, String location) {
        if (location.length() > max.length()) {
            max = location;
        }

        if (i == N){
            return;
        }

        if (volume[i] <= capacity1) {
            put(i + 1, capacity1 - volume[i], capacity2, location + "1");
        }

        if (volume[i] <= capacity2) {
            put(i + 1, capacity1, capacity2 - volume[i], location + "2");
        }
    }
}
