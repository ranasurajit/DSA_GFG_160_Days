//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    /**
     * TC: O(N x M)
     * SC: O(1)
     */
    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        int left = 0;
        int right = m - 1;
        int top = 0;
        int bottom = n - 1;
        int direction = 0;
        ArrayList<Integer> path = new ArrayList<Integer>();
        while (left <= right && top <= bottom) {
            if (direction == 0) {
                // left to right traverse
                for (int i = left; i <= right; i++) {
                    path.add(mat[top][i]);
                }
                top++;
            } else if (direction == 1) {
                // top to bottom traverse
                for (int i = top; i <= bottom; i++) {
                    path.add(mat[i][right]);
                }
                right--;
            } else if (direction == 2) {
                // right to left traverse
                for (int i = right; i >= left; i--) {
                    path.add(mat[bottom][i]);
                }
                bottom--;
            } else if (direction == 3) {
                // bottom to top traverse
                for (int i = bottom; i >= top; i--) {
                    path.add(mat[i][left]);
                }
                left++;
            }
            direction = (direction + 1) % 4;
        }
        return path;
    }
}
