//smth smth doesnt matter if sort is stable
import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

        int size = in.nextInt(); //read in array
        int arr[] =  new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = in.nextInt();
        }

        int temp[] = new int[size];
        System.out.println(counter(arr, temp, 0, size-1));
    }

    static long counter(int[] arr, int[] temp, int left, int right){
        long count = 0;

        if (right > left){
            int mid = (left + right)/2;
            count += counter(arr, temp, left, mid);
            count += counter(arr, temp, mid+1, right);
            count += merge(arr, temp, left, mid+1, right);
        }

        return count;
    }

    static long merge(int[] arr, int[] temp, int left, int mid, int right){
        long count = 0;
        int i = left;
        int j = mid;
        int k = left; 

        while ((i <= mid - 1) && (j <= right)){
            if (arr[i] <= arr[j]){
                temp[k++] = arr[i++];
            }
            else{
                temp[k++] = arr[j++];
                count = count + (mid - i);
            }
        }

        while (i <= mid - 1){
            temp[k++] = arr[i++];
        }
        while (j <= right){
            temp[k++] = arr[j++];
        }
        for (i=left; i <= right; i++){
            arr[i] = temp[i];
        }

        return count;
    }
}

