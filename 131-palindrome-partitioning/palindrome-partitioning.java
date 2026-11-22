
import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();

        solve(0, s, new ArrayList<>(), ans);

        return ans;
    }

    void solve(int index, String s, List<String> ds,
               List<List<String>> ans) {

        if (index == s.length()) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < s.length(); i++) {

            if (isPalindrome(s, index, i)) {

                ds.add(s.substring(index, i + 1));

                solve(i + 1, s, ds, ans);

                ds.remove(ds.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int start, int end) {

        while (start < end) {

            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
