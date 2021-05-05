
package com.sap.akos.kattisandroid;

public class Node{

    private final int value;
    private final Node parentNode;
    private Node leftChild, rightChild;

    public Node(int value, Node parentNode) {
        this.value = value;
        this.parentNode = parentNode;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public int getValue() {
        return value;
    }

    public Node getParentNode() {
        return parentNode;
    }
    
    
    
    @Override
    public String toString() {
        return value+"";
    }
 

}
