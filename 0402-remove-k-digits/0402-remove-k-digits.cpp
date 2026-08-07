class Solution {
public:
    string removeKdigits(string num, int k) {
        int n = num.size();
        stack<char> st;
        string res = "";
        for (int i = 0; i < n; i++) {
            char ch = num[i];
                while(!st.empty() && st.top() > ch && k > 0) {
                    st.pop();
                    k--;
                }
                st.push(ch);
            }
        //missed the edge case
        while (k > 0) {
            st.pop();
            k--;
        }
        while (!st.empty()) {
            res += st.top();
            st.pop();
        }
        reverse(res.begin(), res.end());
        //truncating the leading zeroes from the string
        n = res.size();
        int i = 0;
        while (i < n && res[i] == '0') {
            i++;
        }
        res = (i == n) ? "0" : res.substr(i);
        return res;
    }
};