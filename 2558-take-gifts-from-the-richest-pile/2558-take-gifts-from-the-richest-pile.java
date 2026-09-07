class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int gift : gifts) {
            maxHeap.offer(gift);
        }
        while (k > 0) {
            int peak = maxHeap.poll(); //chopping off the peek element from the heap
            int sqrt = (int) Math.sqrt(peak);
            maxHeap.offer(sqrt);
            k--;
        }
        long sum = 0;
        while (maxHeap.isEmpty() == false) {
            sum += maxHeap.poll();
        }
        return sum;
    }
}