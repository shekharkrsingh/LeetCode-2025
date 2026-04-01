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
        int n1=0;
        int n2=0;

        ListNode node1 =headA;
        ListNode node2= headB;

        while(node1!=null){
            n1++;
            node1=node1.next;
        }
        while(node2!=null){
            n2++;
            node2=node2.next;
        }

        node1=headA;
        node2=headB;

        if(n1>n2){
            while(n1!=n2){
                n1--;
                node1=node1.next;
            }
        }else{
            while(n2>n1){
                n2--;
                node2=node2.next;
            }
        }

        while(node1!=null  || node2!=null){
            if(node1==node2){
                return node1;
            }
            node1=node1.next;
            node2=node2.next;
        }

        return null;


    }
}