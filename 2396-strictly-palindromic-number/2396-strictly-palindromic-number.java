class Solution {
    public boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i <= n - 2; i++) {
            String num = toBaseN(n, i);
            if (!checkPalindrome(num)) {
                return false;
            }
        }
        return true;
    }
    public boolean checkPalindrome(String n) {
        int l = 0, r = n.length() - 1;
        while (l < r) {
            if (n.charAt(l) != n.charAt(r)) {
                return false;
            }
            l++; r--;
        }
        return true;
    }
    public String toBaseN(int num, int n) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % n);
            num /= n;
        }
        return sb.reverse().toString();
    }
}