
package com.akossap.udemy3.udemydfsself;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String name;
    private List<Vertex> neighborList;
    private boolean visited;

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex(String name) {
        this.name = name;
        this.neighborList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Vertex> getNeighborList() {
        return neighborList;
    }

    public void addNeighbor(Vertex neighbor) {
        this.neighborList.add(neighbor);
    }

    @Override
    public String toString() {
        return name;
    }
                
}
