import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] startTmp = br.readLine().split(" ");
        String[] destiTmp = br.readLine().split(" ");
        int charge = Integer.parseInt(br.readLine());
        int startX = Integer.parseInt(startTmp[0]);
        int startY = Integer.parseInt(startTmp[1]);
        int destiX = Integer.parseInt(destiTmp[0]);
        int destiY = Integer.parseInt(destiTmp[1]);

        int distance = Math.abs(startX - destiX) + Math.abs(startY - destiY);

        if (charge < distance) {
            System.out.println("N");
        } else if (charge % 2 == 0 && distance % 2 == 0) {
            System.out.println("Y");
        } else if (charge % 2 != 0 && distance % 2 != 0) {
            System.out.println("Y");
        } else {
            System.out.println("N");
        }

    }
}
