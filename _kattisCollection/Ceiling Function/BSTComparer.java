
package com.sap.akos.kattisandroid;

public class BSTComparer {

    public boolean checkIfIdentitcal(Node nodeFromOneTree, Node nodeFromOtherTree){
        if (nodeFromOneTree == null && nodeFromOtherTree == null) {
            return true;
        }
        if (nodeFromOneTree != null && nodeFromOtherTree != null){
            return checkIfIdentitcal(nodeFromOneTree.getLeftChild(), nodeFromOtherTree.getLeftChild()) 
                    && checkIfIdentitcal(nodeFromOneTree.getRightChild(), nodeFromOtherTree.getRightChild());
        }
        return false;
    }

}
