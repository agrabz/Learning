
package com.akossap.udemy6.udemydijsktraself;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex>{

    private String name;
    private double distance = Double.MAX_VALUE;
    private Vertex predecessor;
    private List<Edge> neighborList;

    public Vertex(String name) {
        this.name = name;
        this.neighborList = new ArrayList<>();
    }    

    @Override
    public String toString() {
        return name;
    }
    
    @Override
    public int compareTo(Vertex other) {
        return Double.compare(this.distance, other.distance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public List<Edge> getNeighborList() {
        return neighborList;
    }

    public void addNeighbor(Edge edge) {
        this.neighborList.add(edge);
    }
    
    
    

}
