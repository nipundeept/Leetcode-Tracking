class Solution {
    public int missingMultiple(int[] nums, int k) {
        int res = -1;
        int[] set = new int[101];
        for (int num : nums) {
            set[num]++;
        }
        int multiple = k;
        while (true) {
            if (multiple >= 101 || set[multiple] == 0) {
                res = multiple;
                break;
            }
            multiple += k;
        }
        return res;
    }
}