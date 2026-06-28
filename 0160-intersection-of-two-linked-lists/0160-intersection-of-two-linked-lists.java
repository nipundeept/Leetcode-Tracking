/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //uses extra space, storing the references of one list in a set and comparing them with another list
        Set<ListNode> st = new HashSet<>();
        ListNode curr = headA;
        while (curr != null) {
            st.add(curr);
            curr = curr.next;
        }
        curr = headB;
        while (curr != null) {
            if (st.contains(curr)) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }
}