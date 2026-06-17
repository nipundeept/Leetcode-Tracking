class Solution {
public:
    int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            int check = n & 1; //checks the last bit returns 0 if last bit is 0, returns 1 if the last bit is 1
            count += (check == 1) ? 1 : 0;
            n >>= 1; //bitwise right shift, truncating the last bit
        }
        return count;
    }
};