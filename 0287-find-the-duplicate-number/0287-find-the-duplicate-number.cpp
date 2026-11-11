class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        //absolute bruteforce is to use the set data structure
        unordered_set<int> set;
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.insert(num);
        }

        return -1;
    }
};