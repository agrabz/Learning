package com.akossap.udemy.breadthfirstsearch;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    
    public void traverse(Vertex root){
        
        Queue<Vertex> queue = new LinkedList<>();
        
        root.setVisited(true);
        queue.add(root);
        
        while (!queue.isEmpty()) {            
            Vertex actualVertex = queue.remove();
            System.out.println("Actual visited vertex: " + actualVertex);
            for (Vertex neighborVertex : actualVertex.getAdjacencyList()) {
                if (!neighborVertex.isVisited()) {
                    neighborVertex.setVisited(true);
                    queue.add(neighborVertex);
                    System.out.println("---added: " + neighborVertex);
                }
            }
        }
    }
    
}
