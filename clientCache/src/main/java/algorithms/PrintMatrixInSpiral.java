package algorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrintMatrixInSpiral {
    public static void main(String args[]) {

        int[][] matrix = {
                {1, 2, 3, 4, 6},
                {5, 6, 7, 8, 9},
                {2, 5, 4, 7, 4},
                {9, 8, 3, 1, 0},
                {1, 1, 1, 6, 6}
        };

//        printMatrixInSpriral(matrix);

        printMatrixClockWiseSpiral(matrix);
    }

    //Extra space
    static void printMatrixInSpriral(int[][] matrix) {
        int size = matrix.length;

        Queue<Integer> topRow = new LinkedList<>();
        Queue<Integer> lastColumn = new LinkedList<>();
        Stack<Integer> lastRow = new Stack<>();
        Stack<Integer> firstRow = new Stack<>();
        Queue<Integer> lastSection = new LinkedList<>();

        for (int row = 0; row < size; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (row == 0) topRow.add(matrix[row][column]);
                if (column == matrix[row].length - 1 && row > 0) lastColumn.add(matrix[row][column]);
                if (row == matrix.length - 1 && column < matrix[row].length - 1) lastRow.add(matrix[row][column]);
                if (column == 0 && row > 0 && row < matrix.length - 1) firstRow.add(matrix[row][column]);
                if (row == 1 && column > 0 && column < matrix[row].length - 1) lastSection.add(matrix[row][column]);
            }
        }

        topRow.forEach(System.out::print);
        lastColumn.forEach(System.out::print);

        while (lastRow.iterator().hasNext()) {
            System.out.print(lastRow.pop());
        }

        while (firstRow.iterator().hasNext()) {
            System.out.print(firstRow.pop());
        }

        lastSection.forEach(System.out::print);
    }

    static void printMatrixClockWiseSpiral(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int start = 0;

        while (columns > start * 2 && rows > start * 2) {
            printRing(matrix, start);

            ++start;
        }
    }

    static void printRing(int[][] matrix, int start) {

        System.out.println("\n>>"+ start +"<<\n");

        int rows = matrix.length;
        int columns = matrix[0].length;
        int endX = columns - 1 - start;
        int endY = rows - 1 - start;
        // Print a row from left to right
        for (int i = start; i <= endX; ++i) {
            int number = matrix[start][i];
            printNumber(number);
        }
        // print a column top down
        if (start < endY) {
            for (int i = start + 1; i <= endY; ++i) {
                int number = matrix[i][endX];
                printNumber(number);
            }
        }
        // print a row from right to left
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; --i) {
                int number = matrix[endY][i];
                printNumber(number);
            }
        }

        // print a column bottom up
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; --i) {
                int number = matrix[i][start];
                printNumber(number);
            }
        }
    }

    static void printNumber(int number) {
        System.out.print(" " +number);
    }
}