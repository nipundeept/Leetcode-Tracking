class Solution {
public:
    int pivotInteger(int n) {
        for (int i = 1; i <= n; i++) {
            if ((i * i) == ((n * n) + n) >> 1) {
                return i;
            }
        }
        return -1;
    }
};