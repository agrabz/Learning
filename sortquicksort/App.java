package com.sap.akos.sort.sortquicksort;

import java.util.Arrays;
import java.util.Random;

public class App {

    //https://www.youtube.com/watch?v=Fiot5yuwPAg
    public static void main(String[] args) {

        App qs = new App();
        int[] arrayToSort = {9, 0, 1, 3, 4, 5, 2, 9, 8, 7, 6, 5, 9, 1, 0, 9};
        System.out.println(Arrays.toString(arrayToSort));
        qs.quickSort(arrayToSort);
        System.out.println(Arrays.toString(arrayToSort));

    }

    public void quickSort(int[] arrayToSort) {
        quickSort(arrayToSort, 0, arrayToSort.length - 1);
    }

    private void quickSort(int[] arrayToSort, int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex + 1) {
            int pivot = partition(arrayToSort, lowerIndex, higherIndex);
            quickSort(arrayToSort, lowerIndex, pivot - 1); //left partition
            quickSort(arrayToSort, pivot + 1, higherIndex); //right partition
        }
    }

    private void swapValuesOfArrayBehindIndexes(int[] arrayToSort, int index1, int index2) {
        int tmp = arrayToSort[index1];
        arrayToSort[index1] = arrayToSort[index2];
        arrayToSort[index2] = tmp;
    }

    private int getPivotIndexBetween(int lowerIndex, int higherIndex) {
        Random rand = new Random();
        int pivotIndex = rand.nextInt((higherIndex - lowerIndex) + 1) + lowerIndex;
        System.out.println("pivotIndex: [" + pivotIndex + "]");
        return pivotIndex;

    }

    private int partition(int[] arrayToSort, int lowerIndex, int higherIndex) {
        int tmpPvtInd = getPivotIndexBetween(lowerIndex, higherIndex);
        swapValuesOfArrayBehindIndexes(arrayToSort, lowerIndex, tmpPvtInd);
        int pivotIndex = lowerIndex;
        int border = pivotIndex + 1;
        int pivotValue = arrayToSort[pivotIndex];

        for (int i = border; i <= higherIndex; i++) {
            int currentComperableValue = arrayToSort[i];
            if (currentComperableValue < pivotValue) {
                swapValuesOfArrayBehindIndexes(arrayToSort, i, border);
                border++;
            }
        }
        swapValuesOfArrayBehindIndexes(arrayToSort, pivotIndex, border - 1);
        int newPivotIndex = border - 1;
        return newPivotIndex;
    }
}
