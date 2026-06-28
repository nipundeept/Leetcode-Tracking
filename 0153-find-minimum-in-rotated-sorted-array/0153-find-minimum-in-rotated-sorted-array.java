class Solution {
    public int findMin(int[] nums) {
        //We use Binary search to discard the search space. Since the array will be spilt into two sorted arrays, we need to find the steep down and dive deep into it, until we find our least element/
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {// we are sure that the element would lie in the other half of the mid, so we discard the lhs of the array
            left = mid + 1;
        }
        else {
            right = mid; //mid could also be a possibilty and now the search space would be lhs of the array, discarding the entire right
        }
    }
    //after the loop finishes, left and right would point towards the minimum element in the array
    return nums[left]; //or nums[right];
    }
}