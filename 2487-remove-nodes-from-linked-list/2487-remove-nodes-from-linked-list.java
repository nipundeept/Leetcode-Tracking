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
    public ListNode removeNodes(ListNode head) {
        //using Monotonic stack
        Stack<ListNode> st = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            while (!st.isEmpty() && curr.val > st.peek().val) {
                st.pop(); //if at any moment the current value becomes greater than peak value of stack, monotonicity is disturbed and we remove those elements from the stack
            }
            st.push(curr);
            curr = curr.next;
        }//creating a new Linked List from the list of Stack
        ListNode temp = null;
        while(!st.isEmpty()) {
            st.peek().next = temp;
            temp = st.peek();
            st.pop();
        }
        return temp;
    }
}