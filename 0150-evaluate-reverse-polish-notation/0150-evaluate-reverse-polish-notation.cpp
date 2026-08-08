class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        int n = tokens.size();
        if (n == 1) {
            return stoi(tokens[n - 1]);
        }
        stack<int> st;
        for (string token : tokens) {
            int a = 0, b = 0;
            if (token == "+") {
                a = st.top();
                st.pop();
                b = st.top();
                st.pop();
                st.push(a + b);
            }
            else if (token == "-") {
                a = st.top();
                st.pop();
                b = st.top();
                st.pop();
                st.push(b - a);
            }
            else if (token == "*") {
                a = st.top();
                st.pop();
                b = st.top();
                st.pop();
                st.push(a * b);
            }
            else if (token == "/") {
                a = st.top();
                st.pop();
                b = st.top();
                st.pop();
                st.push(b / a);
            }
            else {
                st.push(stoi(token));
            }
        }
        return st.top();
    }
};