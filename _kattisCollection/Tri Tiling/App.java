import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    static final int NUMBER_OF_POSSIBLE_STATES = 8;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> result = new ArrayList<>();

        for (;;) {
            int lengthOfBoard = sc.nextInt();
            if (lengthOfBoard == -1) {
                break;
            }
            int[][] dp = new int[lengthOfBoard + 1][NUMBER_OF_POSSIBLE_STATES];

            dp[0][7] = 1;

            for (int i = 1; i < lengthOfBoard + 1; i++) {
                dp[i][0] += dp[i - 1][7]; //numOfEmptyStatesInCurrCol = numOfFullStatesInPreviousCol

                dp[i][1] += dp[i - 1][6];

                //dp[i][2] += dp[i - 1][5];
                dp[i][3] += dp[i - 1][7];
                dp[i][3] += dp[i - 1][4];

                dp[i][4] += dp[i - 1][3];

                //dp[i][5] += dp[i-1][2];
                dp[i][6] += dp[i - 1][7];
                dp[i][6] += dp[i - 1][1];

                dp[i][7] += dp[i - 1][3];
                dp[i][7] += dp[i - 1][6];
                dp[i][7] += dp[i - 1][0];
            }
            result.add(dp[lengthOfBoard][7]);

        }
        result.forEach(res -> {
            System.out.println(res);
        });

    }

}
