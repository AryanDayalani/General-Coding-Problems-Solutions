// This is Day 3 of the GCR DSA problems homework. Set matrix to zeroes. Optimized approach - Space Complexity O(1)
// Naive approach uses extra space and more runs.

package DSA_GCR.Week1.Day3;

class MatrixZeroSetter {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        // Check if the first row contains zero
        for (int c = 0; c < cols; c++) {
            if (matrix[0][c] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        // Check if the first column contains zero
        for (int r = 0; r < rows; r++) {
            if (matrix[r][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        // Use the first row and column as markers
        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }

        // Set the marked rows to zero
        for (int r = 1; r < rows; r++) {
            if (matrix[r][0] == 0) {
                for (int c = 1; c < cols; c++) {
                    matrix[r][c] = 0;
                }
            }
        }

        // Set the marked columns to zero
        for (int c = 1; c < cols; c++) {
            if (matrix[0][c] == 0) {
                for (int r = 1; r < rows; r++) {
                    matrix[r][c] = 0;
                }
            }
        }

        // Set the first row to zero if needed
        if (firstRowHasZero) {
            for (int c = 0; c < cols; c++) {
                matrix[0][c] = 0;
            }
        }

        // Set the first column to zero if needed
        if (firstColHasZero) {
            for (int r = 0; r < rows; r++) {
                matrix[r][0] = 0;
            }
        }
    }
}

public class RA2311003010836 {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 }
        };

        MatrixZeroSetter ms = new MatrixZeroSetter();
        ms.setZeroes(matrix);

        System.out.println("Matrix after setting zeroes:");
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}
