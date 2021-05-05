import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 100; i++) {
            List<Vertex> vertexList = new ArrayList<>();
            int n = Integer.valueOf(sc.nextLine());

            if (n == -1) {
                break;
            }

            char[][] adjacencyMatrix = new char[n][n];

            for (int j = 0; j < n; j++) {
                adjacencyMatrix[j] = sc.nextLine().replaceAll(" ", "").toCharArray();
                vertexList.add(new Vertex(j));
            }
//           System.out.println(Arrays.deepToString(adjacencyMatrix));
//           System.out.println(Arrays.asList(vertexList));

            for (int j = 0; j < adjacencyMatrix.length; j++) {
                for (int k = 0; k < adjacencyMatrix.length; k++) {
                    if (adjacencyMatrix[j][k] == '1') {
                        vertexList.get(j).addNeighbor(vertexList.get(k));
                    }
                }
            }

            for (Vertex vertex : vertexList) {
                for (Vertex neighbor1 : vertex.getNeighborList()) {
                    for (Vertex neighborNeighbor : neighbor1.getNeighborList()) {
                        for (Vertex neighbor2 : vertex.getNeighborList()) {
                            if (neighbor2.getName() == neighborNeighbor.getName()) {
                                //System.out.println(neighbor2.getName() + " | " + neighbor1.getName() + " | "+vertex.getName());
                                vertex.addTriangleNeighbor(neighbor2);
                                vertex.addTriangleNeighbor(neighbor1);
                                neighbor2.addTriangleNeighbor(neighbor1);
                            }
                        }
                    }
                }
            }
//            System.out.println("\nNeighbors:\n");
//            for (int j = 0; j < n; j++) {
//                System.out.println(vertexList.get(j).getNeighborList());
//            }

            //System.out.println("\ninTriangle\n");
            for (Vertex vertex : vertexList) {
                if (vertex.getTriangleNeighborList().isEmpty()) {
                    System.out.print(vertex.getName() + " ");
                }
            }
            System.out.println();

        }

    }

}
