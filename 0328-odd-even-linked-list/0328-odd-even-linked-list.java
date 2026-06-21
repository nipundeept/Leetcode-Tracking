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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode even = head.next, odd = head;
        ListNode evenHead = even; //storing the head of the even LinkedList
        while (even != null && even.next != null) {
            odd.next = even.next; //odd node points to the next odd 
            odd = odd.next; // current odd node jumps to the next odd node
            even.next = odd.next; //even node points to the next even 
            even = even.next; //current even node jumps to the one
        }
        odd.next = evenHead; // odd's end Node points to the starting of the even node linkedlist
        return head;

    }
}