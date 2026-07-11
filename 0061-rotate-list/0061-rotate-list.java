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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode pointer = head, temp = head;
        int count = 0;
        for (ListNode counter = head; counter != null; counter = counter.next)
            count++;
        k = k % count;
        if (k == 0) {
            return head;
        }
        //had to count the size due to k being larger than the list size, down is the code where counting size is not required, and k is strictly lesser than the list size
        for (int i = 0; i <= k; i++) {
            pointer = pointer.next;
        }
        ListNode curr = head;
        while (pointer != null) {
            curr = curr.next;
            pointer = pointer.next;
        }
        ListNode present = curr.next;
        curr.next = null;
        ListNode last = present;
        while (last.next != null) {
            last = last.next;
        }
        last.next = temp;
        return present;
    }
}