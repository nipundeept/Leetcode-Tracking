class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        //Brute-force approach s.c : O(n), t.c : O(n)
        int[] res = new int[nums.length]; int k = 0;
        for (int x : nums) 
            if (x < pivot)
                res[k++] = x;
        for (int x : nums) 
            if (x == pivot)
                res[k++] = x;
        for (int x : nums) 
            if (x > pivot)
                res[k++] = x;
        for (int i = 0; i < res.length; i++) {
            nums[i] = res[i];
        }
        return nums;
    }
}