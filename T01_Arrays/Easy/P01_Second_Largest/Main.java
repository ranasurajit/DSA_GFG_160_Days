//{ Driver Code Starts
// Initial Template for Java
import java.util.*;

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
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * Approach II : Using Simple Iteration
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public int getSecondLargest(int[] arr) {
        int n = arr.length;
        int first = -1;
        int second = -1;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (first < arr[i]) {
                second = first;
                first = arr[i];
            } else if (second < arr[i] && first != arr[i]) {
                second = arr[i];
            }
        }
        return second;
    }

    /**
     * Approach I : Using Max-Heap (PriorityQueue) Approach
     * 
     * TC: O(2 x N x log(N)) ~ O(N x log(N))
     * SC: O(N)
     */
    public int getSecondLargestApproachI(int[] arr) {
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((p, q) -> q - p); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            pq.offer(arr[i]); // TC: O(log(N))
        }
        int first = pq.poll();
        while (!pq.isEmpty() && pq.peek() == first) { // TC: O(N)
            pq.poll(); // TC: O(log(N))
        }
        return pq.isEmpty() ? -1 : pq.poll();
    }
}
