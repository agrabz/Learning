//sorry not so nice

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static final String SOUTH = "South";
    public static final String WEST = "West";
    public static final String NORTH = "North";
    public static final String EAST = "East";
    public static int South = 0;
    public static int West = 0;
    public static int North = 0;
    public static int East = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final String[] input = br.readLine().split(" ");

        final String mdfTmp = input[0];
        final int myDirectionFrom = 0;
        switch (mdfTmp) {
            case SOUTH:
                South = 0;
                East = 1;
                North = 2;
                West = 3;
                break;
            case EAST:
                South = 3;
                East = 0;
                North = 1;
                West = 2;
                break;
            case NORTH:
                South = 2;
                East = 3;
                North = 0;
                West = 1;
                break;
            case WEST:
                South = 1;
                East = 2;
                North = 3;
                West = 0;
                break;
            default:
                break;
        }
        final String mdtTmp = input[1];
        int myDirectionTo = 0;
        switch (mdtTmp) {
            case SOUTH:
                myDirectionTo = South;
                break;
            case WEST:
                myDirectionTo = West;
                break;
            case NORTH:
                myDirectionTo = North;
                break;
            case EAST:
                myDirectionTo = East;
                break;
            default:
                break;
        }
        final String odfTmp = input[2];
        int othersDirectionFrom = 0;
        switch (odfTmp) {
            case SOUTH:
                othersDirectionFrom = South;
                break;
            case WEST:
                othersDirectionFrom = West;
                break;
            case NORTH:
                othersDirectionFrom = North;
                break;
            case EAST:
                othersDirectionFrom = East;
                break;
            default:
                break;
        }

        switch (myDirectionTo) {
            case 2:
                if (othersDirectionFrom == 1) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
                break;
            case 3:
                if (othersDirectionFrom == 1 || othersDirectionFrom == 2) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
                break;
            default:
                System.out.println("No");
                break;
        }
    }
}
