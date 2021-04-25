package com.sap.akos.udemy.udemybinarysearchtreeself2;

public interface Tree<T> {
    public void insertData(T data);
    public T getMin();
    public T getMax();
    public void removeData(T data);
    public void traverse();
    public Node<T> findNodeOfData(T data, Node<T> node);
}
