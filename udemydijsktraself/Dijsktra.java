package com.akossap.udemy6.udemydijsktraself;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Dijsktra {
    
    private void computePath(Vertex startVertex){
        
        startVertex.setDistance(0);
        
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        
        priorityQueue.add(startVertex);
        
        while (!priorityQueue.isEmpty()) {            
            Vertex currentVertex = priorityQueue.poll();
            
            for (Edge edge : currentVertex.getNeighborList()) {
                Vertex targetVertex = edge.getEndVertex();
                
                double newDistance = currentVertex.getDistance() + edge.getWeight();
                
                if (newDistance < targetVertex.getDistance()) {
                    priorityQueue.remove(targetVertex);
                    targetVertex.setDistance(newDistance);
                    targetVertex.setPredecessor(currentVertex);
                    priorityQueue.add(targetVertex);
                }                
            }
        }                
    }
    public void getShortestPathViaDijsktraTo(Vertex startVertex, Vertex targetVertex) {
        computePath(startVertex);
        
        List<Vertex> vertexList = new ArrayList<>();
        
        for (Vertex v = targetVertex; v != null; v = v.getPredecessor()){
            vertexList.add(v);
        }
        Collections.reverse(vertexList);
        System.out.println(vertexList);
        
    }

}
