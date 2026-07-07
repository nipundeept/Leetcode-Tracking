class Solution {
public:
    long long sumAndMultiply(int n) {
        string s = to_string(n);
        int sum = 0; long long num = 0;
        for (auto ch : s) {
            if (ch != '0') {
                sum = sum + (ch - '0');
                num = num * 10 + (ch - '0');
            }
        }
        return num * sum;
    }
};