class Solution {
    public int countSubstrings(String s) {
        //bruteforce
        int n = s.length(), count = 0;
        for (int i = 0; i < n; i++) {
            String str = new String();
            for (int j = i; j < n; j++) {
                str += s.charAt(j);
                if (isPalindrome(str)) {
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}