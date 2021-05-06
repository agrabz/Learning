import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numOfTestCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < numOfTestCases; i++) {
            int numOfCandidates = Integer.parseInt(br.readLine());

            int allVotes = 0;
            int winnerNumber = 0;
            boolean oneWinner = false;
            int max = 0;
            int currentCandidatesVotes;
            
            for (int j = 0; j < numOfCandidates; j++) {
                currentCandidatesVotes = Integer.parseInt(br.readLine());
                allVotes += currentCandidatesVotes;
                if (max < currentCandidatesVotes) {
                    max = currentCandidatesVotes;
                    winnerNumber = j + 1;
                    oneWinner = true;
                } else if (max == currentCandidatesVotes) {
                    oneWinner = false;
                }
            }

            if (!oneWinner) {
                System.out.println("no winner");
                continue;
            }
            int half = allVotes / 2;
            if (half < max) {
                System.out.println("majority winner " + winnerNumber);
            } else {
                System.out.println("minority winner " + winnerNumber);
            }
        }
    }
}
