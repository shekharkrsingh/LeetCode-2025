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
        ListNode even = new ListNode(0);
        ListNode odd= new ListNode(0);
        ListNode oStart=odd;
        ListNode eStart=even;
        ListNode node= head;

        boolean flag=true;

        while(node!=null){
            if(flag){
                even.next=node;
                node=node.next;
                even=even.next;
                even.next=null;
            }else{
                odd.next=node;
                node=node.next;
                odd=odd.next;
                odd.next=null;
            }

            flag=!flag;
        }

        even.next=oStart.next;
        

        return eStart.next;



    }
}