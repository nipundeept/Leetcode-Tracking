class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length, val = 0;
        if (n == 0 || n == 1) {
            return Integer.parseInt(tokens[n - 1]);
        }
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String str = tokens[i];
            int a = 0, b = 0;
            if (str.equals("+")) {
                if (!st.isEmpty()) {
                a = st.peek();
                st.pop();
            }
            if (!st.isEmpty()) {
                b = st.peek();
                st.pop();
            }
                val = (a + b);
                st.push(val);
            }
            else if (str.equals("-")) {
                if (!st.isEmpty()) {
                    a = st.peek();
                    st.pop();
                }
                if (!st.isEmpty()) {
                    b = st.peek();
                    st.pop();
                }
                val = (b - a);
                st.push(val);
            }
            else if (str.equals("*")) {
                if (!st.isEmpty()) {
                    a = st.peek();
                    st.pop();
                }
                if (!st.isEmpty()) {
                    b = st.peek();
                    st.pop();
                }
                val = (b * a);
                st.push(val);
            }
            else if (str.equals("/")) {
                if (!st.isEmpty()) {
                    a = st.peek();
                    st.pop();
                }
                if (!st.isEmpty()) {
                    b = st.peek();
                    st.pop();
                }
                val = (b / a);
                st.push(val);
            }
            else {
                st.push(Integer.parseInt(str));
            }
        }
        return val;
    }

}