class Solution {
public:
    int gcdOfOddEvenSums(int n) {
        int sumOdd = 0, sumEven = 0;
        for (int i = 0, k = 1, l = 2 ; i < n; i++, k += 2, l += 2) {
            sumOdd += k; sumEven += l;
        }
        return gcdCalculation(sumOdd, sumEven);
    }
    int gcdCalculation(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcdCalculation(b, a % b);
    }
};