import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());
        String[] results = new String[n];
        boolean ok;
        
        for (int i = 0; i < n; i++) {
            String[] inputString = br.readLine().split(" ");
            int addend1 = Integer.valueOf(inputString[0]);
            int addend2 = Integer.valueOf(inputString[1]);
            double wannaBeResult = Double.valueOf(inputString[2]);
            
            ok = 
                    (addend1 + addend2 == wannaBeResult) ||
                    (addend1 - addend2 == wannaBeResult) ||
                    (addend2 - addend1 == wannaBeResult) ||
                    (addend1 * addend2 == wannaBeResult) ||
                    ((double) addend1 / (double) addend2 == wannaBeResult) ||
                    ((double) addend2 / (double) addend1 == wannaBeResult);
            
            results[i] = ok ? "Possible" : "Impossible";
        }
        for (String result : results) {
            System.out.println(result);
        }

    }

}
