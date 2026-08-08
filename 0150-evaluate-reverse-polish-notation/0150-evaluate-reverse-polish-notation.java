class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length, val = 0;
        if (n == 0 || n == 1) {
            return Integer.valueOf(tokens[n - 1]);
        }
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String str = tokens[i];
            int a = 0, b = 0;
            if (str.equals("+")) {
                a = st.pop();
                b = st.pop();
                st.push(a + b);
            }
            else if (str.equals("-")) {
                a = st.pop();
                b = st.pop();
                st.push(b - a);
            }
            else if (str.equals("*")) {
                a = st.pop();
                b = st.pop();
                st.push(a * b);
            }
            else if (str.equals("/")) {
                a = st.pop();
                b = st.pop();
                st.push(b / a);
            }
            else {
                st.push(Integer.valueOf(str));
            }
        }
        return st.peek();
    }

}