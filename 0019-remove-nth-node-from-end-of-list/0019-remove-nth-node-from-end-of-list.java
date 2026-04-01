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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int cnt=0;
        ListNode node=head;
        while(node!=null){
            cnt++;
            node=node.next;
        }

        int rAfter=cnt-n;

        if(rAfter==0){
            return head.next;
        }
        node=head;
        while(rAfter!=1){
            node=node.next;
            rAfter--;
        }
        node.next=node.next.next;

        return head;
        
    }
}