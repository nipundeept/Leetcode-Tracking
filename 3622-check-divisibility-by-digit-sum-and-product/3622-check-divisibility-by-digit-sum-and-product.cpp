class Solution {
public:
    bool checkDivisibility(int n) {
        int sum = 0, product = 1;
        for (int temp = n; temp > 0; temp = temp / 10) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
        }
        return (n % (sum + product) == 0);
    }
};