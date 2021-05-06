import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class App {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine(); //first line is useless

        String[] numbers = br.readLine().split(" ");
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (String number : numbers) {
            if (!map.containsKey(Integer.parseInt(number))) {
                map.put(Integer.parseInt(number), 1);
            } else {
                map.put(Integer.parseInt(number), map.get(Integer.parseInt(number)) + 1);
            }
        }
        //sort Map by value
        List<Entry<Integer, Integer>> tmpList = new ArrayList<>(map.entrySet());
        tmpList.sort(Collections.reverseOrder(Entry.comparingByValue()));

        Map<Integer, Integer> result = new LinkedHashMap<>();
        tmpList.forEach(entry -> {
            result.put(entry.getKey(), entry.getValue());
        });

        result.entrySet().forEach(entry -> {
            for (int i = 0; i < entry.getValue(); i++) {
                System.out.print(entry.getKey() + " ");
            }
        });

    }
}
