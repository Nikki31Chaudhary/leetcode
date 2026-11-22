class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n];
        int len = 0;

        for (int num : nums) {
            int low = 0;
            int high = len;

            while (low < high) {
                int mid = low + (high - low) / 2;

                if (arr[mid] < num) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            arr[low] = num;

            if (low == len) {
                len++;
            }
        }

        return len;
    }
}