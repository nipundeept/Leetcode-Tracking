class Solution {
public:
    vector<int> findMissingElements(vector<int>& nums) {
        int minimum = 101, maximum = 0;
        unordered_set<int> s;
        for (int num : nums) {
            minimum = min(num, minimum);
            maximum = max(num, maximum);
            s.insert(num);
        }
        vector<int> res;
        for (int i = minimum + 1; i <= maximum - 1; i++) {
            if (s.find(i) == s.end()) {
                res.push_back(i);
            }
        }
        return res;
    }
};