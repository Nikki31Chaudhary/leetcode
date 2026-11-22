class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        int freq[] = new int[128];

        for (int i = 0; i < t.length(); i++) {
            freq[t.charAt(i)]++;
        }

        int left = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int count = t.length();

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            if (freq[ch] > 0) {
                count--;
            }

            freq[ch]--;

            while (count == 0) {

                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char c = s.charAt(left);
                freq[c]++;

                if (freq[c] > 0) {
                    count++;
                }

                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLen);
    }
}