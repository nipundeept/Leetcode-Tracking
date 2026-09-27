class Solution {
    public int subarraySum(int[] nums, int k) {
        //use prefix-sum + map to track the target's existence
        int currentSum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); //prefixSum starting with 0, and its occurence is once
        for (int num : nums) {
            currentSum += num;
            int complement = currentSum - k; //prefixSum - k = target (Have we seen this complement prefix (checkpoint) before?)
            if (map.containsKey(complement)) {  
                count += map.get(complement); //if yes, the current subarray sum equals k, and count increases by the number of times we have visited that
            }
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}