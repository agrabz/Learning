package com.sap.akos.udemy.udemybinarysearchtreeself2;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    Node<T> root;

    @Override
    public void insertData(T data) {
        if (root == null) {
            root = new Node<>(data, null, Node.ParentRelation.NO_PARENT);
            return;
        }
        insertData(data, root);
    }

    private void insertData(T data, Node<T> node) {
        if (node.getData().compareTo(data) < 0) {
            //goes to the right
            if (node.getRightChildNode() == null) {
                node.setRightChildNode(new Node<T>(data, node, Node.ParentRelation.IS_RIGHT_CHILD));

                //update parent's child count
                if (node.getLeftChildNode() == null) {
                    node.setChildCountAndRelation(Node.ChildCountAndRelation.ONE_RIGHT_CHILD);
                } else {
                    node.setChildCountAndRelation(Node.ChildCountAndRelation.TWO_CHILDREN);
                }
                return;
            }
            insertData(data, node.getRightChildNode());
        } else { //equality is allowed...
            //goes to the left
            if (node.getLeftChildNode() == null) {
                node.setLeftChildNode(new Node<T>(data, node, Node.ParentRelation.IS_LEFT_CHILD));

                //update parent's child count
                if (node.getRightChildNode() == null) {
                    node.setChildCountAndRelation(Node.ChildCountAndRelation.ONE_LEFT_CHILD);
                } else {
                    node.setChildCountAndRelation(Node.ChildCountAndRelation.TWO_CHILDREN);
                }
                return;
            }
            insertData(data, node.getLeftChildNode());
        }
    }

    @Override
    public void removeData(T data) {
        if (root == null) {
            System.out.println("Empty tree...");
            return;
        }
        removeData(data, root);

    }

    private void removeData(T data, Node<T> node) {
        //find Node of data
        node = findNodeOfData(data, node);

        //determine children count
        // no children: null
        if (node.getChildCountAndRelation() == null) {
            System.out.println("Removing node with no children...");
            //if no parent either ==> root to null
            if (node.getParentRelation().equals(Node.ParentRelation.NO_PARENT.toString())) {
                root = null;

                //if it's a LEFT child, null it and update its parent child count    
            } else if (node.getParentRelation().equals(Node.ParentRelation.IS_LEFT_CHILD.toString())) {
                node.getParentNode().setLeftChildNode(null);
                node.getParentNode().decreaseChildCount(Node.ParentRelation.IS_LEFT_CHILD);

            }
            //if it's a RIGHT child, null it and update its parent child count
            node.getParentNode().setRightChildNode(null);
            node.getParentNode().decreaseChildCount(Node.ParentRelation.IS_RIGHT_CHILD);
            return;
        } //it has one LEFT child
        else if (node.getChildCountAndRelation().equals(Node.ChildCountAndRelation.ONE_LEFT_CHILD.toString())) {
            System.out.println("Removing node with one LEFT child...");
            if (node.getParentRelation().equals(Node.ParentRelation.IS_LEFT_CHILD.toString())) {
                node.getParentNode().setLeftChildNode(node.getLeftChildNode());
                node.getLeftChildNode().setParentNode(node.getParentNode());

            } else if (node.getChildCountAndRelation().equals(Node.ParentRelation.IS_RIGHT_CHILD.toString())) {
                node.getParentNode().setRightChildNode(node.getLeftChildNode());
                node.getLeftChildNode().setParentNode(node.getParentNode());

            } else { //root
                root = node.getLeftChildNode();
                node.getLeftChildNode().setParentNode(null);
            }
            return;
        } //it has one RIGHT child
        else if (node.getChildCountAndRelation().equals(Node.ChildCountAndRelation.ONE_RIGHT_CHILD.toString())) {
            System.out.println("Removing node with one RIGHT child...");
            if (node.getParentRelation().equals(Node.ParentRelation.IS_LEFT_CHILD.toString())) {
                node.getParentNode().setLeftChildNode(node.getRightChildNode());
                node.getRightChildNode().setParentNode(node.getParentNode());

            } else if (node.getParentRelation().equals(Node.ParentRelation.IS_RIGHT_CHILD.toString())) {
                node.getParentNode().setRightChildNode(node.getRightChildNode());
                node.getRightChildNode().setParentNode(node.getParentNode());

            } else { //root
                root = node.getRightChildNode();
                node.getRightChildNode().setParentNode(null);
            }
            return;
        } //it has two children
        //successor implementation
        System.out.println("Removing node with two children...");

        Node<T> successorNode = findSuccessor(node.getRightChildNode());

        T temp = successorNode.getData();
        successorNode.setData(node.getData());
        node.setData(temp);

        removeData(data, successorNode);

    }

    private Node<T> findSuccessor(Node<T> node) {
        return getMin(node);
    }

    @Override
    public Node<T> findNodeOfData(T data, Node<T> node) {
        if (node.getData().compareTo(data) < 0) {
            //right
            return findNodeOfData(data, node.getRightChildNode());
        } else if (node.getData().compareTo(data) > 0) {
            //left
            return findNodeOfData(data, node.getLeftChildNode());
        } else {
            return node;
        }
    }

    @Override
    public void traverse() {
        if (root == null) {
            return;
        }
        traverse(root);
    }

    private void traverse(Node<T> node) {
        if (node.getLeftChildNode() != null) {
            traverse(node.getLeftChildNode());
        }
        System.out.print(node + " ==> ");
        if (node.getRightChildNode() != null) {
            traverse(node.getRightChildNode());
        }
    }

    @Override
    public T getMin() {

        if (root == null) {
            return null;
        }
        return getMin(root).getData();
    }

    private Node<T> getMin(Node<T> node) {
        if (node.getLeftChildNode() != null) {
            return getMin(node.getLeftChildNode());
        }
        return node;

    }

    @Override
    public T getMax() {
        if (root == null) {
            return null;
        }
        return getMax(root);
    }

    private T getMax(Node<T> node) {
        if (node.getRightChildNode() != null) {
            return getMax(node.getRightChildNode());
        }
        return node.getData();
    }

}
