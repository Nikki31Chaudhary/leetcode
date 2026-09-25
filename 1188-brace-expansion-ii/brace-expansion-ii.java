class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> set = solve(expression, 0, expression.length());
        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }

    Set<String> solve(String s, int l, int r) {
        Set<String> result = new HashSet<>();
        result.add("");

        int i = l;

        while (i < r) {
            if (s.charAt(i) == ',') {
                Set<String> right = solve(s, i + 1, r);
                result.addAll(right);
                break;
            }

            Set<String> cur = new HashSet<>();

            if (s.charAt(i) == '{') {
                int count = 1;
                int j = i + 1;

                while (count > 0) {
                    if (s.charAt(j) == '{') count++;
                    else if (s.charAt(j) == '}') count--;
                    j++;
                }

                cur = solve(s, i + 1, j - 1);
                i = j;
            } else {
                cur.add(String.valueOf(s.charAt(i)));
                i++;
            }

            Set<String> next = new HashSet<>();

            for (String a : result) {
                for (String b : cur) {
                    next.add(a + b);
                }
            }

            result = next;
        }

        return result;
    }
}