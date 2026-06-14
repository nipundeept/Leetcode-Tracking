class MyLinkedList {
    int size;
    ListNode dummy; 
    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
    public MyLinkedList() {
        this.size = 0;
        this.dummy = new ListNode(0);
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode curr = dummy.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }
    
    public void addAtHead(int val) {
        ListNode node = new ListNode (val);
        node.next = dummy.next;
        dummy.next = node;
        size++;
    }
    
    public void addAtTail(int val) {
        ListNode node = new ListNode(val); //creating a new node
        ListNode curr = dummy;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = node; //linking last node with new node
        node.next = null; //new node at the end now points to null
        size++; //List size is increased
    }
    
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        ListNode node = new ListNode(val);
        ListNode curr = dummy;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        node.next = curr.next;
        curr.next = node;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode curr = dummy;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */