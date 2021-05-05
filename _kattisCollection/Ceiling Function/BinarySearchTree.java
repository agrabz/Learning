package com.sap.akos.kattisandroid;

public class BinarySearchTree {

    private Node root;
    private boolean equalWithAnotherBST = false;
    public String tmp = "";

    public void addNode(int valueOfNodeToAdd) {
        if (root == null) {
            root = new Node(valueOfNodeToAdd, null);
            tmp += valueOfNodeToAdd;
        } else {
            addNode(valueOfNodeToAdd, root);
        }
    }

    private void addNode(int valueOfNodeToAdd, Node nodeToCompare) {
        if (valueOfNodeToAdd < nodeToCompare.getValue()) {
            if (nodeToCompare.getLeftChild() != null) {
                addNode(valueOfNodeToAdd, nodeToCompare.getLeftChild());
            } else {
                nodeToCompare.setLeftChild(new Node(valueOfNodeToAdd, nodeToCompare));
                tmp += valueOfNodeToAdd;
            }
        } else {
            if (nodeToCompare.getRightChild() != null) {
                addNode(valueOfNodeToAdd, nodeToCompare.getRightChild());
            } else {
                nodeToCompare.setRightChild(new Node(valueOfNodeToAdd, nodeToCompare));
                tmp += valueOfNodeToAdd;
            }
        }
    }

    public Node getRoot() {
        return root;
    }

    public boolean isEqualWithAnotherBST() {
        return equalWithAnotherBST;
    }

    public void setEqualWithAnotherBST(boolean equalWithAnotherBST) {
        this.equalWithAnotherBST = equalWithAnotherBST;
    }

    @Override
    public String toString() {
        return tmp;
    }

}
