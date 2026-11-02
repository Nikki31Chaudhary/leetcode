
import java.util.*;

class Solution {
    int n;

    public int sumSubarrayMins(int[] arr) {
        n = arr.length;
        int MOD = (int)(1e9 + 7);

        int[] nse = findNSE(arr);
        int[] psee = findPSEE(arr);

        long total = 0;

        for (int i = 0; i < n; i++) {
            int left = i - psee[i];
            int right = nse[i] - i;

            long freq = left * 1L * right;
            long val = (freq * arr[i]) % MOD;

            total = (total + val) % MOD;
        }

        return (int) total;
    }

    public int[] findNSE(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                res[i] = n;
            } else {
                res[i] = st.peek();
            }

            st.push(i);
        }

        return res;
    }

    public int[] findPSEE(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = st.peek();
            }

            st.push(i);
        }

        return res;
    }
}
