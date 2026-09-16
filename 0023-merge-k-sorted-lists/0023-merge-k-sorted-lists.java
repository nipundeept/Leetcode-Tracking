/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        //adding head of every linked list in the heap
        for (int i = 0; i < n; i++) {
            ListNode head = lists[i];
            if (head != null) {
                minHeap.offer(head);
            }
        }
        ListNode result = new ListNode(0);
        ListNode pointer = result;
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            pointer.next = node;
            pointer = pointer.next;
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }
        return result.next;
    }
}