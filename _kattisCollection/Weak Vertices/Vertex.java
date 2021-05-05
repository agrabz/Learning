import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private int name;
    private List<Vertex> adjacencyList;
    private List<Vertex> triangleNeighborList;
    private boolean inTriangle;

    public boolean isInTriangle() {
        return inTriangle;
    }

    public void setInTriangle(boolean inTriangle) {
        this.inTriangle = inTriangle;
    }

    public List<Vertex> getTriangleNeighborList() {
        return triangleNeighborList;
    }

    public void addTriangleNeighbor(Vertex v) {
        if (!this.triangleNeighborList.contains(v)) {
            this.triangleNeighborList.add(v);
        }
    }

    public List<Vertex> getNeighborList() {
        return adjacencyList;
    }

    public int getName() {
        return name;
    }

    public Vertex(int name) {
        this.name = name;
        this.adjacencyList = new ArrayList<>();
        this.triangleNeighborList = new ArrayList<>();
    }

    public void addNeighbor(Vertex v) {
        this.adjacencyList.add(v);
    }

    @Override
    public String toString() {
        return name + "";
    }

}
