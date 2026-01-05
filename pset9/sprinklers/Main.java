//take largest sprinkler starting earliest
    //interval is where the boundary intersects the circle
    //sprinklers w/o enough height are useless

import java.util.*;
import java.awt.*;

public class Main {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int N = in.nextInt();
        int L = in.nextInt();
        double W = in.nextDouble();

        
        PriorityQueue<Point> minHeap = new PriorityQueue<>((a,b) -> Double.compare(a.getX(), b.getX()));

        for (int i = 0; i < N; i++){
            double center = in.nextInt();
            double radius = in.nextDouble();
            
            if (radius*2 <= W){
                continue;
            }
            
            double length = Math.sqrt(Math.pow(radius,2) - Math.pow(W/2,2));
            
            Point temp = new Point(center - length, center + length);
            minHeap.add(temp);
        }

        double watered = 0;
        int count = 0;

        while (watered < L && !minHeap.isEmpty()){
            double max = -1; 
            while (!minHeap.isEmpty() && minHeap.peek().getX() <= watered){
                double reach = minHeap.poll().getY();
                if (reach > max){
                    max = reach;
                }
            }
            
            if (max == -1){
                System.out.println("-1");
                return;
            }
            
            watered = max;
            count++;
        }

        System.out.println(count);
    }

    public static class Point {
        double x;
        double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }
    }
}
