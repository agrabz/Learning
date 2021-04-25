package com.sap.akos.udemy.udemybinarysearchtreeself2;

public class App {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
        
        bst.insertData(2);
        bst.insertData(0);
        bst.insertData(3);
        bst.insertData(-1);
        bst.insertData(5);
        bst.insertData(4);
        bst.insertData(6);
        bst.insertData(7);
        
        System.out.println(bst.getMin());
        System.out.println(bst.getMax());
        bst.removeData(5);
        bst.traverse();
    }

}
