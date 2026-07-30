class Solution {
public:
    int minimumPushes(string word) {
        int val = 0, n = word.size();
        for (int i = 1; i <= n; i++) {
            if (i <= 8) {
                val += 1;
            }
            else if (i <= 16) {
                val += 2;
            }
            else if (i <= 24) {
                val += 3;
            }
            else {
                val += 4;
            }
        }
        return val;
    }
};