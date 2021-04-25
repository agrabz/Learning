package com.sap.akos.udemy.udemybinarysearchtreeself2;

public class Node<T> {

    private T data;
    private Node<T> rightChildNode;
    private Node<T> leftChildNode;
    private Node<T> parentNode;
    private String parentRelation;
    private String childCountAndRelation;

    public enum ParentRelation {
        IS_LEFT_CHILD, IS_RIGHT_CHILD, NO_PARENT;
    }

    public enum ChildCountAndRelation {
        //null is NO_CHILDREN
        ONE_LEFT_CHILD, 
        ONE_RIGHT_CHILD, 
        TWO_CHILDREN;
    }

    public Node(T data, Node<T> parentNode, ParentRelation parentRelation) {
        this.data = data;
        this.parentNode = parentNode;
        this.parentRelation = parentRelation.toString();
    }
    
    public void decreaseChildCount(ParentRelation parentRelationToRemove){
        if (childCountAndRelation == null) {
            return;
        }
        if (this.childCountAndRelation.equals(ChildCountAndRelation.ONE_LEFT_CHILD.toString()) 
                || this.childCountAndRelation.equals(ChildCountAndRelation.ONE_RIGHT_CHILD.toString())) {
            this.setChildCountAndRelation(null);
            return;
        } //else it has two children
        if (parentRelationToRemove.toString().equals(ParentRelation.IS_LEFT_CHILD)) {
            this.setChildCountAndRelation(ChildCountAndRelation.ONE_RIGHT_CHILD);
            return;
        } //else it's RIGHT
        this.setChildCountAndRelation(ChildCountAndRelation.ONE_LEFT_CHILD);
    }

    public String getParentRelation() {
        return parentRelation;
    }

    public String getChildCountAndRelation() {
        return childCountAndRelation;
    }

    public void setChildCountAndRelation(ChildCountAndRelation childCountAndRelation) {
        if (childCountAndRelation == null) {
            this.childCountAndRelation = null;
        } else
            this.childCountAndRelation = childCountAndRelation.toString();
    }
    


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getRightChildNode() {
        return rightChildNode;
    }

    public void setRightChildNode(Node<T> rightChildNode) {
        this.rightChildNode = rightChildNode;
    }

    public Node<T> getLeftChildNode() {
        return leftChildNode;
    }

    public void setLeftChildNode(Node<T> leftChildNode) {
        this.leftChildNode = leftChildNode;
    }

    public Node<T> getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node<T> parentNode) {
        this.parentNode = parentNode;
    }

    @Override
    public String toString() {
        return data + "";
    }

}