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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, sum = 0;
        ListNode curr1 = l1, curr2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode ansp = dummy;
        while (curr1 != null && curr2 != null) {
            sum = curr1.val + curr2.val + carry;
            ListNode node = new ListNode(sum % 10);
            ansp.next = node;
            ansp = ansp.next;
            carry = sum / 10;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        while (curr1 != null) {
            int data = curr1.val;
            sum = data + carry;
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            ansp.next = node;
            ansp = ansp.next;
            curr1 = curr1.next;
        }
        while (curr2 != null) {
            int data = curr2.val;
            sum = data + carry;
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            ansp.next = node;
            ansp = ansp.next;
            curr2 = curr2.next;
        }
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            ansp.next = node;
        }
        return dummy.next;
    }
}