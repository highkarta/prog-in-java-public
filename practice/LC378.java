package practice;

/**
 * LC378
 */
public class LC378 {

	
}

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countLessOrEqual(matrix, mid, n);

            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    /*
    private int countLessOrEqual(int[][] matrix, int target, int n) {
        int count = 0;
        int row = n - 1; // start at bottom-left
        int col = 0;

        while (row >= 0 && col < n) {
            if (matrix[row][col] <= target) {
                // matrix[0..row][col] are all <= target
                count += (row + 1);
                col++;
            } else {
                row--;
            }
        }

        return count;
    }
    */

    private int countLessOrEqual(int[][] matrix, int target, int n) {
        int count = 0;
        int row = 0;          // start at top row
        int col = n - 1;      // start at rightmost column
    
        while (row < n && col >= 0) {
            if (matrix[row][col] <= target) {
                // matrix[row][0...col] are all <= target
                count += (col + 1);
                row++; // move to the next row
            } else {
                col--; // value is too large, move left
            }
        }
    
        return count;
    }
}