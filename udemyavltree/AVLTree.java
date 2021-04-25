package com.sap.akos.udemy.udemyavltree;

public class AVLTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    @Override
    public void insert(T data) {

        if (root == null) {
            root = new Node<>(data, null);
        } else {
            insert(data, root);
        }
    }

    private void insert(T data, Node<T> node) {

        if (node.getData().compareTo(data) > 0) {
            if (node.getLeftChild() != null) {
                insert(data, node.getLeftChild());
            } else {
                node.setLeftChild(new Node<>(data, node));
            }
        } else { // <
            if (node.getRightChild() != null) {
                insert(data, node.getRightChild());
            } else {
                node.setRightChild(new Node<>(data, node));
            }
        }

        //update Height+settle the violation | AVL
        updateHeight(node);
        settleViolations(node);
    }

    @Override //in-order traversal
    public void traversal() {
        if (root == null) {
            return;

        }
        traversal(root);
    }

    private void traversal(Node<T> node) {

        if (node.getLeftChild() != null) {
            traversal(node.getLeftChild());
        }
        System.out.print(node + " - ");
        if (node.getRightChild() != null) {
            traversal(node.getRightChild());
        }
    }

    private void settleViolations(Node<T> node) {

        //we have to check up to the root node
        while (node != null) {
            updateHeight(node);
            settleViolationsHelper(node);
            node = node.getParentNode();
        }

    }

    private void settleViolationsHelper(Node<T> node) {

        int balance = getBalance(node);

        //left heavy situation
        if (balance > 1) {
            //left-right
            if (getBalance(node.getLeftChild()) < 0) {
                leftRotation(node.getLeftChild());
            }
            //needed in both cases: left-right & left-left
            rightRotation(node);

        }
        //right heavy situation
        if (balance < -1) {
            //right-left
            if (getBalance(node.getRightChild()) > 0) {
                rightRotation(node.getRightChild());
            }
            //needed in both cases: left-right & left-left
            leftRotation(node);

        }
    }

    public T getMin() {
        if (root == null) {
            return null;
        }
        return getMin(root);
    }

    private T getMin(Node<T> node) {
        if (node.getLeftChild() != null) {
            return getMin(node.getLeftChild());
        }
        return node.getData();
    }

    public T getMax() {
        if (root == null) {
            return null;
        }
        return getMax(root);
    }

    private T getMax(Node<T> node) {
        if (node.getRightChild() != null) {
            return getMax(node.getRightChild());
        }
        return node.getData();
    }

    @Override
    public void remove(T data) {
        if (root == null) {
            return;
        }
        remove(data, root);
    }

    private void remove(T data, Node<T> node) {
        if (node == null) {
            return;
        }
        //first find it
        if (data.compareTo(node.getData()) < 0) {
            remove(data, node.getLeftChild());
        } else if (data.compareTo(node.getData()) > 0) {
            remove(data, node.getRightChild());
        } else {
            //leaf node
            if (node.getLeftChild() == null && node.getRightChild() == null) {
                System.out.println("Removing a node without children");
                //check if left or right of its parent
                Node<T> parent = node.getParentNode();
                if (parent != null && parent.getLeftChild() == node) {
                    parent.setLeftChild(null);
                } else if (parent != null && parent.getRightChild() == node) {
                    parent.setRightChild(null);
                }
                //if we want to remove the parent
                if (parent == null) {
                    root = null;
                }

                node = null;

                //AVL
                updateHeight(parent);
                settleViolations(parent);

                //if it has ONE child
                //if it has a RIGHT child
            } else if (node.getLeftChild() == null && node.getRightChild() != null) {
                System.out.println("Removing a node with one right child");
                Node<T> parent = node.getParentNode();

                //if it is a left child, replace it with its RIGHT child
                if (parent != null && parent.getLeftChild() == node) {
                    parent.setLeftChild(node.getRightChild());
                    //if it is a right child, replace it with its RIGHT child    
                } else if (parent != null && parent.getRightChild() == node) {
                    parent.setRightChild(node.getRightChild());
                }

                //to delete the root node
                if (parent == null) {
                    root = root.getRightChild();
                }
                //update the right child's parent
                node.getRightChild().setParentNode(parent);
                node = null;

                //AVL
                updateHeight(parent);
                settleViolations(parent);

            } //if it has a LEFT child
            else if (node.getLeftChild() != null && node.getRightChild() == null) {
                System.out.println("Removing a node with one left child");
                Node<T> parent = node.getParentNode();

                //if it is a left child, replace it with its RIGHT child
                if (parent != null && parent.getLeftChild() == node) {
                    parent.setLeftChild(node.getLeftChild());
                    //if it is a right child, replace it with its RIGHT child    
                } else if (parent != null && parent.getRightChild() == node) {
                    parent.setRightChild(node.getLeftChild());
                }

                //to delete the root node
                if (parent == null) {
                    root = root.getLeftChild();
                }
                //update the right child's parent
                node.getLeftChild().setParentNode(parent);
                node = null;

                //AVL
                updateHeight(parent);
                settleViolations(parent);

            } //if it has TWO children
            else {
                System.out.println("Removing a node with two children");
                //find predecessor (leftmost item in the left subtree)
                Node<T> predecessor = getPredecessor(node.getLeftChild());

                //swap
                T temp = predecessor.getData();
                predecessor.setData(node.getData());
                node.setData(temp);

                //call the delete recursively on the pred
                remove(data, predecessor);
            }
        }

        //settle the violations | AVL
    }

    //predecessor is the max item in the left subtree
    private Node<T> getPredecessor(Node<T> node) {

        if (node.getRightChild() != null) {
            return getPredecessor(node.getRightChild());
        }
        return node;

    }

    //Kth smallest implementation
    private int treeSize(Node<T> node) {
        if (node == null) {
            return 0;
        }

        return (treeSize(node.getLeftChild()) + treeSize(node.getRightChild()) + 1);
    }

    public Node<T> getKSmallest(Node<T> node, int k) {
        //we're searching for "smallest" thus starting from the left
        int n = treeSize(node.getLeftChild()) + 1;

        if (n == k) {
            return node;
        }

        //determine if in the left or in the right
        if (n > k) {
            return getKSmallest(node.getLeftChild(), k);
        }

        if (n < k) {
            return getKSmallest(node.getRightChild(), k - n);
        }

        return null;

    }

    private int height(Node<T> node) {
        if (node == null) {
            return -1;
        }

        return node.getHeight();
    }

    private void updateHeight(Node<T> node) {
        node.setHeight(Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1);
    }

    private int getBalance(Node<T> node) {
        if (node == null) {
            return 0;
        }

        return height(node.getLeftChild()) - height(node.getRightChild());
    }

    private void rightRotation(Node<T> node) {
        System.out.println("Right rotation on node " + node);        
        Node<T> tempLeftChild = node.getLeftChild();
        Node<T> grandChild = tempLeftChild.getRightChild();

        //rotation
        tempLeftChild.setRightChild(node);
        node.setLeftChild(grandChild);

        if (grandChild != null) {
            grandChild.setParentNode(node);
        }

        Node<T> tempParent = node.getParentNode();
        node.setParentNode(tempLeftChild);

        tempLeftChild.setParentNode(tempParent);

        //update its parent
        if (tempLeftChild.getParentNode() != null
                && tempLeftChild.getParentNode().getLeftChild() == node) {
            tempLeftChild.getParentNode().setLeftChild(tempLeftChild);
        }

        if (tempLeftChild.getParentNode() != null
                && tempLeftChild.getParentNode().getRightChild() == node) {
            tempLeftChild.getParentNode().setRightChild(tempLeftChild);
        }

        //if it was the root
        if (node == root) {
            root = tempLeftChild;
        }
        //after rotations the height can change
        updateHeight(node);
        updateHeight(tempLeftChild);
    }

    private void leftRotation(Node<T> node) {
        System.out.println("Left rotation on node " + node);
        Node<T> tempRightChild = node.getRightChild();
        Node<T> grandChild = tempRightChild.getLeftChild();

        //rotation
        tempRightChild.setLeftChild(node);
        node.setRightChild(grandChild);

        if (grandChild != null) {
            grandChild.setParentNode(node);
        }

        Node<T> tempParent = node.getParentNode();
        node.setParentNode(tempRightChild);

        tempRightChild.setParentNode(tempParent);

        //update its parent
        if (tempRightChild.getParentNode() != null
                && tempRightChild.getParentNode().getLeftChild() == node) {
            tempRightChild.getParentNode().setLeftChild(tempRightChild);
        }

        if (tempRightChild.getParentNode() != null
                && tempRightChild.getParentNode().getRightChild() == node) {
            tempRightChild.getParentNode().setRightChild(tempRightChild);
        }

        //if it was the root
        if (node == root) {
            root = tempRightChild;
        }
        //after rotations the height can change
        updateHeight(node);
        updateHeight(tempRightChild);
    }

}
