class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Integer> st = new ArrayDeque<>();
        st.push(0);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(0);
            }
            else {
                int val = st.pop();
                int score = Math.max(2 * val, 1);
                int val2 = st.pop();
                st.push(score + val2);
            }
        }

        return st.peek();
    }
}