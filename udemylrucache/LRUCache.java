package com.sap.akos.udemy.udemylrucache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private int actualSize;
    private Map<Integer, Node> map;
    private DoublyLinkedList linkedList;

    public LRUCache() {
        this.map = new HashMap<>();
        this.linkedList = new DoublyLinkedList();
    }
    /**
    * Akos javadocja.
    */
    public void put(int id, String data) {

        //if it already exist in the LRUC
        //update it to be head
        if (map.containsKey(id)) {
            Node node = this.map.get(id);
            node.setData(data);

            //be head
            updateHead(node);
            return;
        } //else - not present -> insert
        Node node = new Node(id,data);
        
        //check if it fits in or we have to remove the tail
        if (this.actualSize < Constants.CAPACITY) {
            this.actualSize++;
            add(node);
        } else {
            removeTail();
            add(node);
        }
    }

    private void removeTail() {
        //get the last one
        Node lastNode = this.map.get(this.linkedList.getTailNode().getId());
        
        //set new tail node 
        this.linkedList.setTailNode(this.linkedList.getTailNode().getPreviousNode());
        
        //update the new tail node's next node reference
        if (this.linkedList.getTailNode() != null) {
            this.linkedList.getTailNode().setNextNode(null);
        }
        //remove
        lastNode = null;
    }

    public Node get(int id){
        //check if it contains it at all
        if (!this.map.containsKey(id)) {
            System.out.println("Not present...");
            return null;
        } //else it does contain
        Node node = this.map.get(id);
        //before returning it - move it to the head
        updateHead(node);
        return node;
    }
    
    private void updateHead(Node node) {
        Node previousNode = node.getPreviousNode();
        Node nextNode = node.getNextNode();
        
        //check if it is a middle node
        //check if it's head or not
        if (previousNode != null) {
            previousNode.setNextNode(nextNode);
        } else { //it's head
            this.linkedList.setTailNode(nextNode);
        }
        //check if it's tail or not
        if (nextNode != null) {
            nextNode.setPreviousNode(previousNode);
        } else { //it's the last node
            this.linkedList.setTailNode(previousNode);
        }
        add(node);
    }
    
    public void show(){
        Node actualNode = this.linkedList.getHeadNode();
        
        while(actualNode != null){
            System.out.println(actualNode + " ==> ");
            actualNode = actualNode.getNextNode();
        }
    }
    
    //add node to the begining of the linked list
    private void add(Node node) {
        
        //insert to the begining
        node.setNextNode(this.linkedList.getHeadNode());
        node.setPreviousNode(null);
        
        //update previous head - if any
        if (this.linkedList.getHeadNode() != null) {
            this.linkedList.getHeadNode().setPreviousNode(node);
        }
        
        //let the linkedlist know who is the head
        this.linkedList.setHeadNode(node);
        
        //if there's only one node in the list - it's head and tail at the same time
        if (linkedList.getTailNode() == null) {
            linkedList.setTailNode(node);
        }
        
        //let the map know who is the head
        this.map.put(node.getId(), node);
    }

}
