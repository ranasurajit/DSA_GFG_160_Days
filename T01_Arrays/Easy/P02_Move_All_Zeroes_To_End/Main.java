//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().pushZerosToEnd(arr);
            int n = arr.length;
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * Approach III : Using Two-Pointers Without Extra Space
     * 
     * TC: O(N)
     * SC: O(1)
     */
    void pushZerosToEnd(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = 0;
        while (j < n) {
            if (arr[j] != 0) {
                // replace with index i if arr[i] = 0
                if (i != j && arr[i] == 0) {
                    // swap arr[i] with arr[j] - bitwise swap
                    arr[i] = arr[i] ^ arr[j];
                    arr[j] = arr[i] ^ arr[j];
                    arr[i] = arr[i] ^ arr[j];
                }
                i++;
            }
            j++;
        }
    }

    /**
     * Approach II : Simple Iteration Approach Without Extra Space and Single Pass
     * 
     * TC: O(N)
     * SC: O(1)
     */
    void pushZerosToEndApproachII(int[] arr) {
        int n = arr.length;
        int index = 0;
        int i = 0;
        for (i = 0; i < n; i++) { // TC: O(N)
            if (arr[i] != 0) {
                arr[index++] = arr[i];
            }
        }
        while (index < n) {
            arr[index++] = 0;
        }
    }

    /**
     * Approach I : Simple Iteration Approach With Extra Space
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    void pushZerosToEndApproachI(int[] arr) {
        int n = arr.length;
        int[] result = new int[n]; // SC: O(N)
        int index = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (arr[i] != 0) {
                result[index++] = arr[i];
            }
        }
        for (int i = 0; i < n; i++) { // TC: O(N)
            arr[i] = result[i];
        }
    }
}
