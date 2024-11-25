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
     * TC: O(N)
     * SC: O(1)
     */
    void pushZerosToEnd(int[] arr) {
        int n = arr.length;
        int zeroPtr = 0;
        int numPtr = 0;
        while (zeroPtr < n && arr[zeroPtr] != 0) {
            zeroPtr++;
        }
        if (zeroPtr == n) {
            return;
        }
        numPtr = zeroPtr + 1;
        while (numPtr < n) { // TC: O(N)
            while (numPtr < n && arr[numPtr] == 0) {
                numPtr++;
            }
            // swap arr elements at index 'zeroPtr' with 'numPtr'
            if (numPtr < n) {
                int temp = arr[numPtr];
                arr[numPtr] = arr[zeroPtr];
                arr[zeroPtr] = temp;
            }
            zeroPtr++;
            numPtr++;
        }
    }
}
