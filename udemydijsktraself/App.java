package com.akossap.udemy6.udemydijsktraself;

public class App {

    public static void main(String[] args) {

        Vertex aVertex = new Vertex("A");
        Vertex bVertex = new Vertex("B");
        Vertex cVertex = new Vertex("C");
        Vertex dVertex = new Vertex("D");
        Vertex eVertex = new Vertex("E");
        Vertex fVertex = new Vertex("F");
        Vertex gVertex = new Vertex("G");
        Vertex hVertex = new Vertex("H");

        aVertex.addNeighbor(new Edge(5, aVertex, bVertex));
        aVertex.addNeighbor(new Edge(8, aVertex, hVertex));
        aVertex.addNeighbor(new Edge(9, aVertex, eVertex));
        
        bVertex.addNeighbor(new Edge(15, bVertex, dVertex));
        bVertex.addNeighbor(new Edge(12, bVertex, cVertex));
        bVertex.addNeighbor(new Edge(4, bVertex, hVertex));
        
        hVertex.addNeighbor(new Edge(7, hVertex, cVertex));
        hVertex.addNeighbor(new Edge(6, hVertex, fVertex));
        
        eVertex.addNeighbor(new Edge(5, eVertex, hVertex));
        eVertex.addNeighbor(new Edge(4, eVertex, fVertex));
        eVertex.addNeighbor(new Edge(20, eVertex, gVertex));
        
        dVertex.addNeighbor(new Edge(9, dVertex, gVertex));
        
        cVertex.addNeighbor(new Edge(3, cVertex, dVertex));
        cVertex.addNeighbor(new Edge(11, cVertex, gVertex));
        
        fVertex.addNeighbor(new Edge(1, fVertex, cVertex));
        fVertex.addNeighbor(new Edge(13, fVertex, gVertex));
        
        Dijsktra d = new Dijsktra();
        d.getShortestPathViaDijsktraTo(aVertex, gVertex);
    }

}
