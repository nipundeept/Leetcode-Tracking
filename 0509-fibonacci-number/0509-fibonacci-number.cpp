class Solution {
public:
    int fib(int n) {
        int a = 0, b = 1;
        while (n--) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return a;
    }
};