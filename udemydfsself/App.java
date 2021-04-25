package com.akossap.udemy3.udemydfsself;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        
        List<Vertex> vlist = new ArrayList<>();

        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        
        vlist.add(a);
        vlist.add(b);
        vlist.add(c);
        vlist.add(d);
        vlist.add(e);
        
        a.addNeighbor(c);
        a.addNeighbor(b);
        
        b.addNeighbor(d);
        b.addNeighbor(c);
        
        d.addNeighbor(e);
        
        DFS dfs = new DFS();
        
        dfs.dfs(vlist);

    }

}
