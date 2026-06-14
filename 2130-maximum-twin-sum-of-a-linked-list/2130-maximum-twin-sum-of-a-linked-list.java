class Solution {
    public int pairSum(ListNode head) {
        //brute
        int size = 0;
        ListNode curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        int[] arr = new int[size];
        curr = head;
        for (int i = 0; i < size; i++) {
            arr[i] = curr.val;
            curr = curr.next;
        }
        int maxSum = 0;
        for (int i = 0; i < size / 2; i++) {
            maxSum = Math.max(maxSum, arr[i] + arr[size - 1 - i]);
        }
        return maxSum;
    }
}