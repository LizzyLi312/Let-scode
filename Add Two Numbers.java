class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return new ListNode(0);
        if(l1 == null) return reverse(l2);
        if(l2 == null) return reverse(l1);
        ListNode idx1 = l1, idx2 = l2;
        boolean extra = false;
        ListNode head = null;
        ListNode temp = head;
        while(idx1 != null || idx2 != null || extra){
            int val1 = idx1 == null ? 0 : idx1.val;
            int val2 = idx2 == null ? 0 : idx2.val;
            int newVal = val1 + val2;
            if(extra){ //carry check
                newVal += 1;
                extra = false;
            }
            if(newVal > 9){ //check new value
                extra = true;
                newVal -= 10;
            }
            if(head == null){ //without dummy node
                head = new ListNode(newVal);
                temp = head;
            }
            else{
                temp.next = new ListNode(newVal);
                temp = temp.next;
            }
            if(idx1 != null) idx1 = idx1.next;
            if(idx2 != null) idx2 = idx2.next;
        }
        return head;
    }
}
