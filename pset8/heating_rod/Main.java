//smth smth c++ library that computes arcsins...
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

        double L = in.nextDouble();
        double T = in.nextDouble();
        double C = in.nextDouble();
        double theta = 0;
        double low = 0;
        double high = 4;
        double ratio;

        while (high - low > 1e-12){
            theta = (low + high)/2;
            ratio = theta/(2 * Math.sin(theta/2));
            if (ratio >= (1 + T*C)){
                high = theta;
            } 
            else{
                low = theta;
            }
        }

        double radius = L/(2 * Math.sin(theta/2));
        double displacement =  radius * (1 - Math.cos(theta/2));
        System.out.printf("%.3f%n",displacement);
    }
}

