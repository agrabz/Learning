
package com.akossap.udemy6.udemybellmanford;

import java.util.List;

public class BellmanFord {

    private List<Edge> edgeList;
    private List<Vertex> vertexList;

    public BellmanFord(List<Edge> edgeList, List<Vertex> vertexList) {
        this.edgeList = edgeList;
        this.vertexList = vertexList;
    }

    public void bellmanFord(Vertex sourceVertex){
        sourceVertex.setDistance(0);
        
        for (int i = 0; i < vertexList.size()-1; ++i) { //V-1 iterations - we relay all the edges
            for (Edge edge : edgeList) {
                
                Vertex u = edge.getStartVertex();
                Vertex v = edge.getTargetVertex();
                
                if (u.getDistance() == Double.MAX_VALUE) {
                    continue;
                }
                double newDistance = u.getDistance() + edge.getWeight();
                
                if (newDistance < v.getDistance()) {
                    v.setDistance(newDistance);
                    v.setPreviousVertex(u);
                }
            }
        }
        //detect negative cycles
        for (Edge edge : edgeList) { //V-th iteration
            if (edge.getStartVertex().getDistance() != Double.MAX_VALUE){
                if (hasCycle(edge)) {
                    System.out.println("There's a negative cycle detected");
                    return;
                }
            }
            
        }
        
        
        
    }

    private boolean hasCycle(Edge edge) {
        return edge.getStartVertex().getDistance() + edge.getWeight() 
                < edge.getTargetVertex().getDistance();
    }
    
    public void shortestPathTo(Vertex targetVertex){
        if (targetVertex.getDistance() == Double.MAX_VALUE) {
            System.out.println("There's no path from the source to the target");
        }
        System.out.println("There's a path from source to target with cost: " + targetVertex.getDistance());
        Vertex actualVertex = targetVertex;
        while (actualVertex != null) {            
            System.out.print(actualVertex + " - ");
            actualVertex = actualVertex.getPreviousVertex();
        }
    }

}
