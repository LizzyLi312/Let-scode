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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = head, slow = dummy;
        int cnt = 1;
        while (fast != null) {
            if (cnt == k) {
                ListNode curHead = slow.next;
                ListNode nextHead = fast.next;
                fast.next = null; // remember to cut the link
                slow.next = reverse(curHead);
                fast = nextHead;
                slow = curHead;
                slow.next = fast;
                cnt = 1;
            } else {
                fast = fast.next;
                cnt++;
            }
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
