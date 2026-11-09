class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // Better solution using HashMap(frequency counting) Space: O(n), time com : O(n)
        // at max there can be 2 answers, max number of elements that can appear more than n / k times is k - 1
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int maxFreq = (nums.length / 3);

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            int freq = map.get(num);
            if (freq == maxFreq + 1) list.add(num);
            if (freq > maxFreq) {
                continue;
            }
        }

        return list;
    }
}