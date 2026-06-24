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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head, fast = head, temp = head;
        for (int i = 0; i < k; i++) {
            if (i == k - 1) {
                temp = fast;
            }
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //slow now points to the kth node from the end of the list
        int x = temp.val;
        temp.val = slow.val;
        slow.val = x;
        return head;
    }
}