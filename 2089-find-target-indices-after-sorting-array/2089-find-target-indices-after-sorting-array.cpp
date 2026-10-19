/*
after sorting, we could perform binary search to find the indices for which the element is equal to the target
1. Instead of checking every index, we could find :
 ! First occurence of target
 ! Last occurence of target
 then calculate (count = last occurence - first occurence + 1)
*/
class Solution {
public:
    vector<int> targetIndices(vector<int>& nums, int target) {
        vector<int> result;
        sort(nums.begin(), nums.end());
        
        int firstOccurence = findFirst(nums, target);
        int lastOccurence = findLast(nums, target);

        if (firstOccurence == -1) {
            return result;
        }

        for (int i = firstOccurence; i <= lastOccurence; i++) {
            result.push_back(i);
        }

        return result;
    }

    int findFirst(vector<int>& nums, int target) {
        int low = 0, high = nums.size() - 1;
        int ans = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                ans = mid;
                high = mid - 1;
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return ans;
    }

    int findLast(vector<int>& nums, int target) {
        int low = 0, high = nums.size() - 1;
        int ans = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                ans = mid;
                low = mid + 1;
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return ans;
    }
};