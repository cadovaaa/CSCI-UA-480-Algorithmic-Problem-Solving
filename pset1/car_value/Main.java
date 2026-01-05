import java.util.Scanner;
import java.util.Arrays;

public class Main
{
    public static void main(String args[])
    {
        //read values
        Scanner in = new Scanner(System.in);
        int loanDuration = in.nextInt();
        float downPayment = in.nextFloat();
        float amntOwed = in.nextFloat();
        int numRecords = in.nextInt();
        
        //read numRecords records
        int recordMonth[] = new int[numRecords];
        float recordPercent[] = new float[numRecords];
        for (int i = 0; i < numRecords; i++)
        {
            recordMonth[i] = in.nextInt();
            recordPercent[i] = in.nextFloat();
        }

        int month = 0;
        float carValue = amntOwed + downPayment;
        float monthlyPayment = amntOwed/loanDuration;
        int recordCounter = 0; //keeps track of depreciation level

        //calculate state at the start of the month
        while (amntOwed > carValue || month == 0){
            //loan payment is not made when car is bought
            if (month > 0){
                amntOwed -= monthlyPayment;
            }
            
            //when the month matches a new depreciation level, move to next level
            for (int i:recordMonth){
                if (month == i && month != 0){
                    recordCounter += 1;
                    //System.out.println(recordPercent[recordCounter]);
                }
            }
            carValue = carValue*(1-recordPercent[recordCounter]);

            month++;
        }

        //values were calculated for start of month, so subtract 1 to get to the "after x months" format
        if (month-1 == 1){
            System.out.println(month-1 + " month");
        } else{
            System.out.println(month-1 + " months");
        }
    }
}
