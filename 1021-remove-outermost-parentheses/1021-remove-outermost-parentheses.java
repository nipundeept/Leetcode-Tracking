class Solution {
    public String removeOuterParentheses(String s) {
        String str = "";
        int balance = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (balance >= 1) {
                    str += ch;
                }
                balance++;
            }
            else {
                balance--;
                if (balance >= 1) {
                    str += ch;
                }
            }
        }

        return str;
    }
}