class Solution {
    public int maxDepth(String s) {
        Deque<Character> st = new ArrayDeque<>();
        int n = s.length(), max = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(ch);
            }
            else if (ch == ')') {
                max = Math.max(max, st.size());
                st.pop();
            }
        }
        
        return max;
    }
}