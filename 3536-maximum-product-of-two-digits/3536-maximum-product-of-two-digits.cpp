class Solution {
public:
    int maxProduct(int n) {
        //product of largest and second largest digit in the number will be the maximum product
        int l = -1, sl = -1, res = 0;
        while (n != 0) {
            int d = n % 10;
            if (d >= l) {
                sl = l;
                l = d;
            }
            else if (d < l && d > sl) {
                sl = d;
            }
            n /= 10;
        }
        return l * sl;
    }
};