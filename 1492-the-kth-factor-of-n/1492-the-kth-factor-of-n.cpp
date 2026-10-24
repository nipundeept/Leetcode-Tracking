class Solution {
public:
    int kthFactor(int n, int k) {
        int temp = k;
        int result = -1, count = 0;
        for (int i = 1; i <= n && temp > 0; i++) {
            if (n % i == 0) {
                result = i;
                temp--;
                count++;
            }
        }

        if (count < k) {
            return -1;
        }

        return result;
    }
};