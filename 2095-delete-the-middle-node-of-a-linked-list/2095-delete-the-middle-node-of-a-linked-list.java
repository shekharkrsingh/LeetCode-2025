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
    public ListNode deleteMiddle(ListNode head) {
        int cnt = 0;
        if (head.next == null) {
            return null;
        }
        ListNode node = head;
        while (node != null) {
            cnt++;
            node = node.next;
        }
        System.out.println(cnt);
        cnt /= 2;
        node = head;
        while (cnt != 1) {
            node = node.next;
            cnt--;
        }

        node.next = node.next.next;

        return head;
    }
}