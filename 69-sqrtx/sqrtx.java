class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;

        int l = 1, h = x / 2;

        while (l <= h) {
            int m = l + (h - l) / 2;

            if ((long)m * m == x) {
                return m;
            } else if ((long)m * m < x) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }

        return h;
    }
}