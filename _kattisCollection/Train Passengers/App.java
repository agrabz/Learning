import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] capAndStationsTmp = br.readLine().split(" ");
        final int capacity = Integer.parseInt(capAndStationsTmp[0]);
        final int stations = Integer.parseInt(capAndStationsTmp[1]);
        //Left | Entered | CurrentlyIn | WaitedInTheStation
        int[][] dpTable = new int[stations + 1][4];
        boolean ok = true;

        for (int i = 1; i <= stations; i++) {
            String[] stationData = br.readLine().split(" ");
            int justLeft = Integer.parseInt(stationData[0]);
            int justEntered = Integer.parseInt(stationData[1]);
            int justStayed = Integer.parseInt(stationData[2]);
            dpTable[i][0] = justLeft;
            dpTable[i][1] = justEntered;
            dpTable[i][2] = dpTable[i - 1][2] - justLeft + justEntered;
            dpTable[i][3] = justStayed;
            if (i == 1 && dpTable[i][0] != 0) {
                
                ok = false;
                break;
            } else if (dpTable[i][0] > dpTable[i - 1][2]) {
                
                ok = false;
                break;
            } else if (dpTable[i][2] > capacity) {
                
                ok = false;
                break;
            } else if (dpTable[i][3] > 0 && dpTable[i][2] != capacity) {
                
                ok = false;
                break;
            } else if (i == stations) {

                if (dpTable[i][1] != 0
                        || dpTable[i][2] != 0
                        || dpTable[i][3] != 0) {
                    
                    ok = false;
                    break;
                }
            }
        }
        if (ok) {
            System.out.println("possible");
        } else {
            System.out.println("impossible");
        }

    }
}
