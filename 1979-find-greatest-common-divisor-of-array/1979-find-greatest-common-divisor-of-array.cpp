class Solution {
public:
    int findGCD(vector<int>& nums) {
        int smallest = nums[0], largest = nums[0];
        for (int num : nums) {
            smallest = min(num, smallest);
            largest = max(num, largest);
        }
        return gcd(largest, smallest);
    }
    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
};