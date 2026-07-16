class Solution {
public:
    long long gcdSum(vector<int>& nums) {
        int n = nums.size();
        vector<int> prefixGcd(n);
        int maxElem = 0; //since constraint mentions nums[i] is greater than or equal to 1
        for (int i = 0; i < n; i++) {
            maxElem = max(maxElem, nums[i]);
            prefixGcd[i] = (__gcd(nums[i], maxElem));
        }
        sort(prefixGcd.begin(), prefixGcd.end());
        long long sum = 0; int left = 0, right = prefixGcd.size() - 1;
        while (left < right) {
            long long gcd = __gcd(prefixGcd[left], prefixGcd[right]);
            sum += gcd;
            left++; right--;
        }
        return sum;
    }
};