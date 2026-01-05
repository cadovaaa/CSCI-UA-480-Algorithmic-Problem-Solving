//idfk a bitset with 1m bits and then you just do it like the sieve
import java.util.Scanner;
import java.util.BitSet;

public class Main{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        BitSet schedule = new BitSet(1000001);
        BitSet job = new BitSet(1000001);
        Boolean conflict = false;

        int start;
        int end;
        int interval;

        //2 entries
        for (int i = 0; i < n; i++){
            start = in.nextInt();
            end = in.nextInt();
            if (end-start > 1){
                job.set(start+1,end-1);
                if (job.intersects(schedule)){
                    conflict = true;
                } else {
                    schedule.or(job);
                }
            }
            job.clear();
        }

        //3 entries
        for (int i = 0; i < m; i++){
            start = in.nextInt();
            end = in.nextInt();
            interval = in.nextInt();
            if (end-start > 1){
                for (int j = 0; j < 1000002; j+=interval){
                    job.set(start+j+1,end+j-1);
                }
                if (job.intersects(schedule)){
                    conflict = true;
                } else {
                    schedule.or(job);
                }
            }
            job.clear();
        }
        
        if (conflict){
            System.out.println("CONFLICT");
        } else{
            System.out.println("NO CONFLICT");
        }
    }
}
