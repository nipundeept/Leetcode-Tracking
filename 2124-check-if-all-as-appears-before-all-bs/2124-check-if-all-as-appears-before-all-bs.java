class Solution {
    public boolean checkString(String s) {
        boolean foundB = false;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (ch == 'b') {
                foundB = true;
            }

            if (ch == 'a' && foundB) {
                return false;
            }
        }

        return true;
    }
}