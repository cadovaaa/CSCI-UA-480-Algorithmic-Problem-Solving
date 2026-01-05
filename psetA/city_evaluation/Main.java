//n is small enough, can just mark each cell
    //iterate thru all of the squares
    //can use bitset
    //only need 2 decimal places

//we only need to gaf abt corners, can use that as the splitting points (like instead of to 2 decimal places)
    //gives us x and y intervals, iterate thru

import java.util.*;

public class Main {
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
       
        TreeSet<Double> x_splits = new TreeSet<>();
        TreeSet<Double> y_splits = new TreeSet<>();

        int N = in.nextInt();
        Box[] boxes = new Box[N];
        for (int i = 0; i < N; i++){
            double X = in.nextDouble();
            double Y = in.nextDouble();
            double R = in.nextDouble();

            double x1 = X-R;
            double x2 = X+R;
            double y1 = Y-R;
            double y2 = Y+R;

            x_splits.add(x1);
            x_splits.add(x2);
            y_splits.add(y1);
            y_splits.add(y2);

            Box temp = new Box(x1,x2,y1,y2);
            boxes[i] = temp;
        }   

        double count = 0;
        double x_start;
        double x_end = x_splits.pollFirst();
        int x_size = x_splits.size();
        for (int i = 0; i < x_size; i++){
            x_start = x_end;
            x_end = x_splits.pollFirst();

            TreeSet<Double> y_copy = (TreeSet<Double>) y_splits.clone();
            double y_start;
            double y_end = y_copy.pollFirst();
            int y_size = y_copy.size();
            for (int j = 0; j < y_size; j++){
                y_start = y_end;
                y_end = y_copy.pollFirst();

                for (int k = 0; k < N; k++){
                    if (boxes[k].within(x_start,y_start)){
                        count += (x_end-x_start)*(y_end-y_start); 
                        //System.out.println(x_start +" " +x_end+ " " +y_start+ " " +y_end+ " " +count);
                        break;
                    }
                }
                
            }
        }

        System.out.printf("%.2f",count);
    }

    public static class Box {
        double x1;
        double x2;
        double y1;
        double y2;

        public Box(double x1, double x2, double y1, double y2){
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }

        public double getX1() {
            return x1;
        }

        public double getX2() {
            return x2;
        }

        public double getY1() {
            return y1;
        }

        public double getY2() {
            return y2;
        }

        public boolean within(double x_start, double y_start){
            return  (this.x1 <= x_start && x_start < this.x2 && this.y1 <= y_start && y_start < this.y2);
        }
    }
}
