class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode slow = head, fast = head;
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }
        ListNode first = fast;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode second = slow;
        int firstVal = first.val;
        first.val = second.val;
        second.val = firstVal;
        return head;
    }
}
