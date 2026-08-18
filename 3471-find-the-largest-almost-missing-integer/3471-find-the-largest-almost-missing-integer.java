class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[51];
        for (int i = 0; i <= (n - k); i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < (i + k); j++) {
                set.add(nums[j]);
            }
            for (int num : set) {
                freq[num]++;
            }
        }
        int largest = -1;
        for (int i = 0; i <=50; i++) {
            if (freq[i] == 1) {
                largest = i;
            }
        }
        return largest;
    }
}