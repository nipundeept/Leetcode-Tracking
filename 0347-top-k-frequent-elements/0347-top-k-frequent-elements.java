class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // store the frequency of each element
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );

        for (int num : map.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int i = 0;
        int[] result = new int[k];
        while (!minHeap.isEmpty()) {
            result[i++] = minHeap.poll();
        }

        return result;

    }
}