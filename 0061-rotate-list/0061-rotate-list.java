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
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null)
            return null;
        int cnt = 0;
        ListNode node = head;
        while (node != null) {
            cnt++;
            node = node.next;
        }

        k %= cnt;
        if (k == 0)
            return head;

        int go = cnt - k;
        node = head;

        while (go != 1) {
            node = node.next;
            go--;
        }

        ListNode temp = node.next;
        ListNode temp2 = temp;
        node.next = null;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = head;

        return temp2;
    }

}