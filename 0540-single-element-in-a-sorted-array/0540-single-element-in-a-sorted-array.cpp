class Solution {
public:
    int singleNonDuplicate(vector<int>& nums) {
        //intuition : binary search based on the observation of elements and their indices. Normally, if all the elements have their pairs the array, every new pairs would start at an even index. Since we have one single element, it would break this sequence of all the pairs to the right of it. Therefore, we reduce the search space and will eventually land on the number.
        int low = 0, high = nums.size() - 1;
        while (low < high) {
            int mid = low + (high - low) / 2; 
            mid = (mid & 1) ? mid - 1 : mid; //we will account for only the starting of pairs, hence mid points to the starting index of a pair.
            if (nums[mid] == nums[mid + 1]) { //if pair exists, left space of this is certainly chilling with all the pairs starting with an even index, so we search the other space
            low = mid + 2;
            }
            else { //if there a breakage, it must be certainly on the left hand side of the mid.
            high = mid; //it can also be mid
            }
        }
        return nums[high];
    }
};