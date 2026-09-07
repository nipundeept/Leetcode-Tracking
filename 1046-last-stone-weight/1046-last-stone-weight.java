class Solution {
    public int lastStoneWeight(int[] stones) {
        //using maxHeap, we store all the elements of the array in the heap first, and pop out the first two, if the difference of those elements is non-zero, we offer it to the heap else we do not offer it and return the last standing element in the heap.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        while (!(maxHeap.size() == 0) && maxHeap.size() != 1) { //could be written as while (maxHeap.size() > 1)
            int a = maxHeap.poll();
            int b = maxHeap.poll();
            if ((a - b) != 0) {
                maxHeap.offer(a - b);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}