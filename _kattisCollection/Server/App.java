import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class App {

    private class Vertex {

        int name;
        boolean visited;
        int distance = Integer.MAX_VALUE;
        Vertex predecessor;
        List<Edge> neighborList;
    }

    private class Edge {

        Vertex startVertex;
        Vertex endVertex;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] taskAndTime = br.readLine().split(" ");
        //int taskCount = Integer.parseInt(taskAndTime[0]);
        int timeInMins = Integer.parseInt(taskAndTime[1]);
        
        String[] tasks = br.readLine().split(" ");
        int sum = 0;
        
        for (int i = 0; i < tasks.length; i++) {
            if (Integer.parseInt(tasks[i]) <= timeInMins && sum+Integer.parseInt(tasks[i]) <= timeInMins) {
                sum += Integer.parseInt(tasks[i]);
                if (sum == timeInMins) {
                    System.out.println(i+1);
                    return;
                }
            } else {
                System.out.println(i);
                return;
            }
        }
        System.out.println(tasks.length);
        
    }

}
