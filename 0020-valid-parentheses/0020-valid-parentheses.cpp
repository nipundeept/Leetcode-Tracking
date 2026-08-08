class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        int n = s.size();
        for (int i = 0; i < n; i++) {
            char ch = s[i];
            if (ch == ')') {
                if (st.empty() || st.top() != '(') {
                    return false;
                }
                st.pop();
            }
            else if (ch == ']') {
                if (st.empty() || st.top() != '[') {
                    return false;
                }
                st.pop();
            }
            else if (ch == '}') {
                if (st.empty() || st.top() != '{') {
                    return false;
                }
                st.pop();
            }
            else {
                st.push(ch);
            }
        }
        return st.empty();
    }
};