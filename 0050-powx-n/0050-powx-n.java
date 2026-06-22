class Solution {
    public double myPow(double x, int n) {
        //Binary exponentiation
        double res = 1;
        long temp = n;
        if (temp < 0) {
            x = 1 / x;
            temp = -temp;
        }
        while (temp > 0) {
            if ((temp & 1) == 1) {
                res = res * x;
            }
            temp = temp >> 1;
            x = x * x;
        }
        return res;
    }
}