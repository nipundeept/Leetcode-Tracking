class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, ans = Integer.MIN_VALUE, n = s.length();
        Set<Character> set = new HashSet<>();
        while (right < n) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                ans = Math.max (right - left + 1, ans);
                right++;
            }
            else {
                while (set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left));
                    left++;
                }
            }
        }
        return (ans == Integer.MIN_VALUE) ? 0 : ans;
    }
}