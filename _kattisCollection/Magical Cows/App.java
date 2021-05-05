import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner intSc = new Scanner(System.in);

        int maxNumOfCows = intSc.nextInt();
        int initNumOfFarms = intSc.nextInt();
        int numOfInspectionDays = intSc.nextInt();
        //int[] initialCows = new int[initNumOfFarms];
        int[] inspectionDays = new int[numOfInspectionDays];
        
        long[][] dp = new long[51][maxNumOfCows + 1];

        for (int i = 0; i < initNumOfFarms; i++) {
            int cows = intSc.nextInt();
            dp[0][cows]++;
        }

        for (int dayRow = 0; dayRow < 50; dayRow++) {
            for (int farmWithNCowColumn = 1; farmWithNCowColumn <= maxNumOfCows; farmWithNCowColumn++) {
                if (farmWithNCowColumn <= maxNumOfCows / 2) {
                    dp[dayRow + 1][2 * farmWithNCowColumn] += dp[dayRow][farmWithNCowColumn];

                } else {
                    dp[dayRow + 1][farmWithNCowColumn] += 2 * dp[dayRow][farmWithNCowColumn];

                }
            }
        }

        for (int i = 0; i < numOfInspectionDays; i++) {
            int day = intSc.nextInt();
            long farms = 0;
            for (int j = 0; j < dp[day].length; j++) {
                farms += dp[day][j];
            }
            System.out.println(farms);
        }


    }

    

}
