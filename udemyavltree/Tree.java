package com.sap.akos.udemy.udemyavltree;

public interface Tree<T> { //same as BST
    public void insert(T data);
    public void remove(T data);
    public void traversal();
}
