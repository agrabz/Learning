package com.sap.akos.udemydp.quickselect;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSelect {

    private int[] nums;

    public QuickSelect(int[] nums) {
        this.nums = nums;
    }

    public int select(int k) {
        return quickSelect(0, nums.length - 1, k - 1);
    }
    
    private int quickSelect(int firstIndex, int lastIndex, int k) {
        int pivotIndex = partition(firstIndex, lastIndex);

        if (pivotIndex < k) {
            //check the right
            System.out.println("      Pivot returned is smaller than " + k + ". Thus recursion with pivot value: " + pivotIndex + 1 + " last index: " + lastIndex + " k: " + k);
            return quickSelect(pivotIndex + 1, lastIndex, k);
        } else if (pivotIndex > k) {
            //check left
            System.out.println("      Pivot returned is greater than " + k + ". Thus recursion with pivot value: " + pivotIndex + 1 + " last index: " + lastIndex + " k: " + k);
            return quickSelect(firstIndex, pivotIndex - 1, k);
        }
        return nums[pivotIndex];
    }

    private int partition(int firstIndex, int lastIndex) {
        int pivotIndex = ThreadLocalRandom.current().nextInt(firstIndex, lastIndex);
        
        System.out.println("Pivot chosen: " + nums[pivotIndex] + ". Swapping pivot with " + nums[lastIndex] + ". Before swapping: " + Arrays.toString(nums));
        swapElementsAtIndexes(pivotIndex, lastIndex);
        System.out.println("After swapping: " + Arrays.toString(nums));

        for (int i = firstIndex; i < lastIndex; i++) {
            System.out.println("Comparing " + nums[i] + " and " + nums[lastIndex]);
            if (nums[i] > nums[lastIndex]) {
                System.out.println(nums[i] + " is greater than " + nums[lastIndex] + ". Swapping: " + nums[i] + " and " + nums[firstIndex] + "\nBefore swap: " + Arrays.toString(nums) + " ===>");
                swapElementsAtIndexes(i, firstIndex);
                System.out.println("After swap: " + Arrays.toString(nums));
                firstIndex++;
            } else {
                System.out.println("  " + nums[i] + " is smaller than " + nums[lastIndex]);
            }
        }
        System.out.println("   End of partition. Swapping " + nums[lastIndex] + " and " + nums[firstIndex] + ". Before swapping: " + Arrays.toString(nums));
        swapElementsAtIndexes(lastIndex, firstIndex);
        System.out.println("   After swapping: " + Arrays.toString(nums));
        System.out.println("        Pivot to return: " + firstIndex);
        return firstIndex;
    }


    private void swapElementsAtIndexes(int pivot, int lastIndex) {

        int tmp = nums[pivot];
        nums[pivot] = nums[lastIndex];
        nums[lastIndex] = tmp;
    }

}
