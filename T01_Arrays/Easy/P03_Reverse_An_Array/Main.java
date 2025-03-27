package T01_Arrays.Easy.P03_Reverse_An_Array;

//{ Driver Code Starts
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String str[] = br.readLine().split(" ");
            int arr[] = new int[str.length];

            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            Solution obj = new Solution();

            obj.reverseArray(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    /**
     * Approach II : Two Pointers Without Extra Space
     * 
     * TC: O(N / 2) ~ O(N)
     * SC: O(1)
     */
    public void reverseArray(int arr[]) {
        int n = arr.length;
        int i = 0;
        int j = n - 1;
        while (i < j) { // TC: O(N / 2)
            // swap
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            // snrink the array pointers for next swap operation
            i++;
            j--;
        }
    }

    /**
     * Approach I : Using Extra Space and Iteration (2 Pass)
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public void reverseArrayApproachI(int arr[]) {
        int n = arr.length;
        int[] rev = new int[n]; // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            rev[i] = arr[n - i - 1];
        }
        for (int i = 0; i < n; i++) { // TC: O(N)
            arr[i] = rev[i];
        }
    }
}
