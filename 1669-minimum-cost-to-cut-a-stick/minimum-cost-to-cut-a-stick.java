import java.util.*;

class Solution {
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;

        int arr[] = new int[c + 2];

        arr[0] = 0;
        arr[c + 1] = n;

        for (int i = 0; i < c; i++) {
            arr[i + 1] = cuts[i];
        }

        Arrays.sort(arr);

        int dp[][] = new int[c + 2][c + 2];

        for (int i = c; i >= 1; i--) {
            for (int j = 1; j <= c; j++) {

                if (i > j) {
                    continue;
                }

                int min = Integer.MAX_VALUE;

                for (int k = i; k <= j; k++) {

                    int cost = arr[j + 1] - arr[i - 1]
                             + dp[i][k - 1]
                             + dp[k + 1][j];

                    min = Math.min(min, cost);
                }

                dp[i][j] = min;
            }
        }

        return dp[1][c];
    }
}