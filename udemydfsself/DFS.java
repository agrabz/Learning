package com.akossap.udemy3.udemydfsself;

import java.util.List;
import java.util.Stack;

public class DFS {

    private Stack<Vertex> stack;

    public DFS() {
        this.stack = new Stack<>();
    }

    public void dfs(List<Vertex> vlist) {
        for (Vertex vertex : vlist) {
            if (!vertex.isVisited()) {
                vertex.setVisited(true);
                System.out.println("Root v: " + vertex);
                dfsWithStack(vertex);
            }
        }
    }

    private void dfsWithStack(Vertex rootVertex) {
        
        stack.add(rootVertex);
        rootVertex.setVisited(true);
        
        while (!stack.isEmpty()) {            
            Vertex actualVertex = this.stack.pop();
            for (Vertex neighborVertex : actualVertex.getNeighborList()) {
                if (!neighborVertex.isVisited()) {
                    neighborVertex.setVisited(true);
                    System.out.println(neighborVertex);
                    this.stack.push(neighborVertex);
                } else System.out.println("Is already visisted: " + neighborVertex);
            }
        }
        
        
    }

}
