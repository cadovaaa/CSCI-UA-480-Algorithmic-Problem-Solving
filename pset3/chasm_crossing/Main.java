import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int capacity = in.nextInt();
        int travel_time = in.nextInt();
        int passengers = in.nextInt();

        boolean at_central = true; //true -> position is central, false -> uptown
        int time = 0;

        int[] passenger_arrivals = new int[passengers];
        boolean[] passenger_positions = new boolean[passengers];
        String temp; //for reading in positions

        for (int i = 0; i < passengers; i++){
            passenger_arrivals[i] = in.nextInt();
            temp = in.nextLine();
            if (temp.equals(" Central")){
                passenger_positions[i] = true;
            }
        }

        int passenger_count = 0;
        int[] passenger_departures = new int[passengers];
        int depart_count = 0;
        Queue<Integer> central = new LinkedList<>();
        Queue<Integer> downtown = new LinkedList<>();
        Queue<Integer> station;
        int[] tram = new int[capacity];
        int tram_occupancy = -1;

        while (depart_count<passengers){ //COME BACK AND FIX THIS!!
            //while time is >= to the next p's time, then add that p to the correct station
                //store passenger ID to keep track of what time
            while (passenger_count < passengers && time >= passenger_arrivals[passenger_count]){
                if (passenger_positions[passenger_count]){
                    central.add(passenger_count);
                } else{
                    downtown.add(passenger_count);
                }
                passenger_count += 1;
            }
            
            //depart all ps in the tram if there are any
            for (int i = tram_occupancy; i > -1; i--){ //i is index of the last tram passenger
                passenger_departures[tram[i]] = time;
                depart_count += 1;
                tram_occupancy--;
            }

            //set station to the one tram is at
            if (at_central){
                station = central;
            } else{
                station = downtown;
            }
            //if the station the tram is at has ps, take as many as you can
            while (station.peek() != null && tram_occupancy < capacity-1){ //i is index of the last tram passenger
                tram_occupancy++;
                tram[tram_occupancy] = station.remove();
            }

            //advance time by travel time-1 if the tram is moving + change at_central
            if (tram_occupancy > -1 || central.peek() != null || downtown.peek() != null){
                time += travel_time - 1;
                at_central = !at_central;
            }
            time ++;
        }
        for (int i = 0; i < passenger_departures.length; i ++){
            System.out.println(passenger_departures[i]);
        }
    }
}
