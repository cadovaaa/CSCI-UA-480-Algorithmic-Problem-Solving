import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int count = 0;
		
		String line1 = scanner.nextLine();
		
		String[] input = line1.split(" ");
		
		String line2 = scanner.nextLine();
		scanner.close();
		
		String[] jobs = line2.split(" ");
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for(String i: jobs) {
			arr.add(Integer.parseInt(i));
		}
		
		int boarding = arr.get(Integer.parseInt(input[1]));
		int position = Integer.parseInt(input[1]);
		
		
		while (position >= 0) {
			int maxJob = arr.get(0);
			for (int k : arr) {
				if (k > maxJob) {
					maxJob = k;
				}
			}
			
			
				if (arr.get(0) == maxJob && position > 0){
					//System.out.print(arr.get(0));
					arr.remove(0);
					count ++;
				} else if (arr.get(0) == maxJob) {
					arr.remove(0);
				} else {
					arr.add(arr.get(0));
					arr.remove(0);
					if (position == 0) {
						position += arr.size();
					}
				}
				position --;
				//System.out.print("p: " + position);
				//System.out.println(arr);
		}
		
		
		System.out.println((count+1));
	}
}
