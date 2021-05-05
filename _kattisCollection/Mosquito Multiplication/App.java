//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String[] input = sc.nextLine().split(" ");
            final int eggLayingPerMosquito = Integer.parseInt(input[3]);
            final int larvaToPupaSurvivalRate = Integer.parseInt(input[4]);
            final int pupaToAdultSurvivalRate = Integer.parseInt(input[5]);
            final int numOfWeeks = Integer.parseInt(input[6]);

            int[][] dpTable = new int[numOfWeeks + 1][3];

            dpTable[0][0] = Integer.parseInt(input[0]);
            dpTable[0][1] = Integer.parseInt(input[1]);
            dpTable[0][2] = Integer.parseInt(input[2]);

            for (int dpIdx = 1; dpIdx < dpTable.length; dpIdx++) {
                dpTable[dpIdx][0] = dpTable[dpIdx - 1][1] / pupaToAdultSurvivalRate;
                dpTable[dpIdx][1] = dpTable[dpIdx-1][2] / larvaToPupaSurvivalRate;
                dpTable[dpIdx][2] = dpTable[dpIdx-1][0] * eggLayingPerMosquito;
            }
            System.out.println(dpTable[numOfWeeks][0]);
        }

    }

}
