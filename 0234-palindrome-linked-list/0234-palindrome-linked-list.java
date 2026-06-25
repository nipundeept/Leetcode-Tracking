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
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //slow is pointing to the mid of the linked list
        ListNode rev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = rev;
            rev = curr;
            curr = temp;
        }
        ListNode check = rev;
        curr = head;
        while (check != null) {
            if (check.val != curr.val) {
                return false;
            }
            curr = curr.next;
            check = check.next;
        }
        return true;
    }
}