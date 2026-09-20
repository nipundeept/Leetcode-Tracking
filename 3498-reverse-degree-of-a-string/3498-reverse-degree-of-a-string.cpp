class Solution {
public:
    int reverseDegree(string s) {
        int n = s.size();
        int result = 0;
        for (int i = 0; i < n; i++) {
            char ch = s[i];
            result += (i + 1) * (27 - (ch - 96));
        }
        return result;
    }
};