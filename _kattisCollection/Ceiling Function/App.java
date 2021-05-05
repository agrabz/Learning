package com.sap.akos.kattisandroid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //5 3
        String[] typeAndLayerDetails = br.readLine().split(" ");
        List<BinarySearchTree> bstList = new ArrayList<>();
        List<List<BinarySearchTree>> results = new ArrayList<>();

        //0..5
        for (int idx = 0; idx < Integer.parseInt(typeAndLayerDetails[0]); idx++) {
            //2 7 1
            String[] layersOfCurrentType = br.readLine().split(" ");
            BinarySearchTree bst = new BinarySearchTree();
            bstList.add(bst);
            //2-7-1
            for (String layer : layersOfCurrentType) {
                //2
                bst.addNode(Integer.parseInt(layer));
            }

        }
        BSTComparer bstc = new BSTComparer();
        for (BinarySearchTree bst1 : bstList) {
            if (bst1.isEqualWithAnotherBST()) {
                continue;
            }
            bst1.setEqualWithAnotherBST(true);
            List<BinarySearchTree> newBstList = new ArrayList<>();
            newBstList.add(bst1);
            for (BinarySearchTree bst2 : bstList) {

                if (bst2.isEqualWithAnotherBST() || bst1 == bst2) { //bst1 ==? bst2
                    boolean one = bst1 == bst2;
                    boolean two = bst2.isEqualWithAnotherBST();
                    continue;
                }
                if (bstc.checkIfIdentitcal(bst1.getRoot(), bst2.getRoot())) {
                    bst2.setEqualWithAnotherBST(true);
                    newBstList.add(bst2);
                }
            }
            results.add(newBstList);
        }
        System.out.println(results.size());
    }
}
