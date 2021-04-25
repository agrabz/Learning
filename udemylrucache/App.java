package com.sap.akos.udemy.udemylrucache;

public class App {

    public static void main(String[] args) {
        
        //TODO fix show().. :)
        
        LRUCache cache = new LRUCache();
        
        cache.put(0, "A");
        cache.put(1, "B");
        cache.put(2, "C");
        cache.put(3, "D");
        cache.put(4, "E");
        cache.put(5, "F");
        cache.put(6, "G");
        
        System.out.println(cache.get(6));
        cache.show();
        System.out.println();
        
        System.out.println(cache.get(3));
        cache.show();
        System.out.println();
    }

}
