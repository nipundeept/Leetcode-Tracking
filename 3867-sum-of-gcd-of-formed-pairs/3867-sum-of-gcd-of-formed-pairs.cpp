class Solution {
public:
    long long gcdSum(vector<int>& nums) {
        vector<long long> prefixGcd;
        int maxElem = INT_MIN;
        for (int i = 0; i < nums.size(); i++) {
            maxElem = max(maxElem, nums[i]);
            prefixGcd.push_back(gcdCalculation(nums[i], maxElem));
        }
        sort(prefixGcd.begin(), prefixGcd.end());
        long long sum = 0; int left = 0, right = prefixGcd.size() - 1;
        while (left < right) {
            long long gcd = gcdCalculation(prefixGcd[left], prefixGcd[right]);
            sum += gcd;
            left++; right--;
        }
        return sum;
    }
    long long gcdCalculation(long long a, long long b) {
        if (b == 0) {
            return a;
        }
        return gcdCalculation(b, a % b);
    }
};