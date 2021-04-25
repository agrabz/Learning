package com.sap.akos.udemydp.sudoku;

public class Algorithm {

    private int[][] sudokuTable;

    public Algorithm(int[][] sudokuTable) {
        this.sudokuTable = sudokuTable;
    }

    public void solveProblem() {
        if (solve(0, 0)) {
            showResult();
        } else {
            System.out.println("No solution");
        }
    }

    private void showResult() {
        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            if (i % 3 == 0) {
                System.out.println(" ");
            }
            for (int j = 0; j < Constants.BOARD_SIZE; j++) {
                if (j % 3 == 0) {
                    System.out.print(" ");
                }
                System.out.print(sudokuTable[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    private boolean solve(int rowIndex, int columnIndex) {
        if (rowIndex == Constants.BOARD_SIZE
                && ++columnIndex == Constants.BOARD_SIZE) {
            return true;
        }
        //column by column
        if (rowIndex == Constants.BOARD_SIZE) {
            rowIndex = 0;
        }
        //empty ==> zero
        if (sudokuTable[rowIndex][columnIndex] != 0) {
            return solve(rowIndex + 1, columnIndex);
        }

        for (int number = Constants.MIN_NUMBER; number <= Constants.MAX_NUMBER; number++) {
            if (isValid(rowIndex, columnIndex, number)) {
                sudokuTable[rowIndex][columnIndex] = number;
                if (solve(rowIndex + 1, columnIndex)) {
                    return true;
                }
            }
        }
        //BACKTRACK
        sudokuTable[rowIndex][columnIndex] = 0;
        
        return false;

    }

    private boolean isValid(int rowIndex, int columnIndex, int actualNumber) {

        //is already in the row?
        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            if (sudokuTable[i][columnIndex] == actualNumber) {
                return false;
            }
        }
        //is alrady in the column?
        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            if (sudokuTable[rowIndex][i] == actualNumber) {
                return false;
            }
        }
        //is already in the 3x3 box?
        int boxRowOffset = (rowIndex / 3) * Constants.BOX_SIZE;
        int boxColumnOffset = (columnIndex / 3) * Constants.BOX_SIZE;

        for (int i = 0; i < Constants.BOX_SIZE; i++) {
            for (int j = 0; j < Constants.BOX_SIZE; j++) {
                if (actualNumber == sudokuTable[boxRowOffset + i][boxColumnOffset + j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
