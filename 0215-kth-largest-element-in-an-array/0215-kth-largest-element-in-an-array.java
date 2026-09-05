class Solution {
    public int findKthLargest(int[] nums, int k) {
    //optimal solution using priority queue. TC : O(n log k) if k is small, TC is nearly O(n)
    //for top k largest elements, we need a MIN-Heap of size k
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int num : nums) {
        minHeap.offer(num); //adding the element to the heap
        //if size exceeds k, we remove the peek(), smallest
        if (minHeap.size() > k) {
            minHeap.poll();
        }
    }
    return minHeap.peek(); //root is the largest kth element
    }
}