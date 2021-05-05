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

        int testCases = Integer.valueOf(br.readLine());

        for (int casesIdx = 0; casesIdx < testCases; casesIdx++) {
            ArrayList<ArrayList<Integer>> vertexList = new ArrayList<>();
            
            String[] citiesAndPilots = br.readLine().split(" ");
            int cityNodes = Integer.parseInt(citiesAndPilots[0]);
            
            //create edgeless graph
            for (int i = 0; i < cityNodes; i++) {
                vertexList.add(new ArrayList<>());
            }
            
            //add edges to the graph based on input
            int pilotEdges = Integer.parseInt(citiesAndPilots[1]);
            for (int pilotsIdx = 0; pilotsIdx < pilotEdges; pilotsIdx++) {
                String[] edgeData = br.readLine().split(" ");
                //undirected graph - symmetric
                vertexList.get(Integer.parseInt(edgeData[1])-1)
                        .add(Integer.parseInt(edgeData[0])-1);
                
                vertexList.get(Integer.parseInt(edgeData[0])-1)
                        .add(Integer.parseInt(edgeData[1])-1);
            }
            //algorithm
            boolean[] visited = new boolean[cityNodes];
            Queue<ArrayList<Integer>> queue = new LinkedList<>();
            int min = Integer.MAX_VALUE;
            int counter = 0;
            
            for (int i = 0; i < cityNodes; i++) {
                visited[i] = true;
                queue.add(vertexList.get(i));
                
                while (!queue.isEmpty()) {                    
                    ArrayList<Integer> actualVertex = queue.remove();
                    for (Integer integer : actualVertex) {
                        if (!visited[integer]) {
                            visited[integer] = true;
                            counter++;
                            queue.add(vertexList.get(integer));
                        }
                    }
                }
                if (counter != 0 && counter < min) {
                    min = counter;
                    counter = 0;
                }
            }
            System.out.println(min);
        }

    }

}
