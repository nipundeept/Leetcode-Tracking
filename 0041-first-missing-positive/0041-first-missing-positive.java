class Solution {
    public int firstMissingPositive(int[] nums) {
        //absolute bruteforce
        Set<Integer> set = new HashSet<>();
        long max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            set.add(num);
        }
        for (int i = 1; i <= Math.max(max + 1, 1); i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return -1; //redundant
    }
}