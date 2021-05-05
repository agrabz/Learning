import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        long startTime = System.currentTimeMillis();
        final String input = br.readLine();
        final int dictionarySize = Integer.parseInt(br.readLine());
        String[] dictionary = new String[dictionarySize];

        String notIncludedABC = "";

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int j = 0; j < alphabet.length(); j++) {
            if (!input.contains(alphabet.substring(j, j + 1))) {
                notIncludedABC += alphabet.substring(j, j + 1);
            }
        }
        List<String> notOkay = new ArrayList<>(dictionarySize);

        for (int i = 0; i < dictionarySize; i++) {
            dictionary[i] = br.readLine();
            for (int j = 0; j < dictionary[i].length(); j++) {
                for (int k = 0; k < notIncludedABC.length(); k++) {
                    if (dictionary[i].length() < 4
                            || !dictionary[i].contains(input.charAt(0) + "")
                            || dictionary[i].substring(j, j + 1).equals(notIncludedABC.substring(k, k + 1))) {
                        dictionary[i] = "";
                    }
                }
            }
        }
        
//        long endTime = System.currentTimeMillis();
//        System.out.println(endTime-startTime);
        System.out.println(String.join("\n", dictionary).replaceAll("\n+", "\n"));

    }

}
