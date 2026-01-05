import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<Integer> arr = new ArrayList<>();
        while (in.hasNextInt()) {
            arr.add(in.nextInt());
        }

        List<Integer> flips = new ArrayList<>();
        pancakeSort(arr, flips);

        System.out.print(0);
    }

    static void pancakeSort(List<Integer> arr, List<Integer> flips) {
        int N = arr.size();
        for (int size = N; size > 1; size--) {
            int max = 0;
            for (int i = 1; i < N; i++) {
                if (arr.get(i) > arr.get(max)) {
                    max = i;
                }
            }

            if (max == size - 1)
                continue;

            if (max != 0) {
                flip(arr, max);
                System.out.print((max+1) + " ");
            }
            flip(arr, size - 1);
            System.out.print(size);
        }
    }

    static void flip(List<Integer> arr, int k) {
        int i = 0;
        while (i < k) {
            int temp = arr.get(i);
            arr.set(i, arr.get(k));
            arr.set(k, temp);
            i++;
            k--;
        }
    }

}
