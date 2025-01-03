//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            // Read capacity
            int capacity = Integer.parseInt(br.readLine());

            // Read values
            String[] valInput = br.readLine().split(" ");
            int[] val = new int[valInput.length];
            for (int i = 0; i < valInput.length; i++) {
                val[i] = Integer.parseInt(valInput[i]);
            }

            // Read weights
            String[] wtInput = br.readLine().split(" ");
            int[] wt = new int[wtInput.length];
            for (int i = 0; i < wtInput.length; i++) {
                wt[i] = Integer.parseInt(wtInput[i]);
            }

            // Call the knapSack function and print the result
            System.out.println(Solution.knapSack(capacity, val, wt));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to return max value that can be put in knapsack of capacity.
    static int knapSack(int capacity, int val[], int wt[]) {
        int n = wt.length;
        // return solveRecursion(n - 1, capacity, val, wt);
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                dp[i][j] = -1;
            }
        }
        return solveMemoization(n - 1, capacity, val, wt, dp);
    }

    /**
     * Using Memoization
     * 
     * TC: O(N x W)
     * SC: O(N x W + N)
     */
    private static int solveMemoization(int index, int w, int val[], int wt[], int[][] dp) {
        // base case - minimum valid testcase
        if (w == 0) {
            return 0;
        }
        if (index == 0) {
            return wt[0] <= w ? val[0] : 0;
        }
        if (dp[index][w] != -1) {
            return dp[index][w];
        }
        /**
         * if wt[index] <= w, i.e current weight is less than 
         * capacity 'w' then we have two choices 
         * 1. to pick
         * 2. not to pick
         * 
         * so we need to take maximum of them to fill the knapsack
         */
        if (wt[index] <= w) {
            return dp[index][w] = 
                Math.max(
                    val[index] + solveMemoization(index - 1, w - wt[index], val, wt, dp),
                    solveMemoization(index - 1, w, val, wt, dp)
                );
        } else {
            // we have no option to pick this
            return dp[index][w] = solveMemoization(index - 1, w, val, wt, dp);
        }
    }
 
    /**
     * Using Recursion
     * 
     * TC: O(2 ^ N)
     * SC: O(2 ^ N)
     */
    private static int solveRecursion(int index, int w, int val[], int wt[]) {
        // base case - minimum valid testcase
        if (w == 0) {
            return 0;
        }
        if (index == 0) {
            return wt[0] <= w ? val[0] : 0;
        }
        /**
         * if wt[index] <= w, i.e current weight is less than 
         * capacity 'w' then we have two choices 
         * 1. to pick
         * 2. not to pick
         * 
         * so we need to take maximum of them to fill the knapsack
         */
        if (wt[index] <= w) {
            return Math.max(
                val[index] + solveRecursion(index - 1, w - wt[index], val, wt),
                solveRecursion(index - 1, w, val, wt)
            );
        } else {
            // we have no option to pick this
            return solveRecursion(index - 1, w, val, wt);
        }
    }
}
