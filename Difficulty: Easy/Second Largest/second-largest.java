//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSecondLargest(arr);
            System.out.println(ans);

            System.out.println("~");
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
    public int getSecondLargest(int[] arr) {
        int n = arr.length;
        int first = Integer.MIN_VALUE;
        int second = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (first < arr[i]) {
                second = first;
                first = arr[i];
            } else if (second < arr[i] && first != arr[i]) {
                second = arr[i];
            }
        }
        return second == Integer.MIN_VALUE ? -1 : second;
    }
}
