import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputOne = br.readLine().split(" ");
        String[] inputTwo = br.readLine().split(" ");

        //int occasions = Integer.parseInt(inputOne[0]);
        double speedUpPercent = Double.parseDouble(inputOne[1]) / 100;
        double spedUpLength = Double.parseDouble(inputOne[2]);

        //startTime | endTime | currentSpeed | originalTime | sum
        double[][] dpTable = new double[inputTwo.length + 1][5];
        dpTable[0][0] = 0;
        dpTable[0][1] = Double.parseDouble(inputTwo[0]);
        dpTable[0][2] = 1; //100%
        dpTable[0][3] = dpTable[0][1];
        dpTable[0][4] = dpTable[0][3];
        dpTable[inputTwo.length][1] = spedUpLength;
        //System.out.println(Arrays.toString(dpTable[0]));

        for (int i = 1; i < dpTable.length; i++) {
            dpTable[i][0] = dpTable[i - 1][1];
            if (i != inputTwo.length) {
                dpTable[i][1] = Double.parseDouble(inputTwo[i]);
            }
            dpTable[i][2] = dpTable[i - 1][2] + speedUpPercent;
            dpTable[i][3] = (dpTable[i][1] - dpTable[i][0]) * dpTable[i][2];
            dpTable[i][4] = dpTable[i - 1][4] + dpTable[i][3];
            //System.out.println(Arrays.toString(dpTable[i]));
        }
        System.out.println(dpTable[inputTwo.length][4]);

    }

}
