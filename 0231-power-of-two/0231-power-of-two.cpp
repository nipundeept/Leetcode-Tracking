class Solution {
public:
    bool isPowerOfTwo(int n) {
        //brute: counting the set bits of n. A power of 2 always has 1 set bit in its binary representation
        if (n == 0) return false;
        int count_setbits = 0;
        while (n != 0) {
            if (n & 1 == 1) {
                count_setbits++;
            }
            if (count_setbits > 1) {
                return false;
            }
            n = n >> 1;
        }
        return true;
    }
};