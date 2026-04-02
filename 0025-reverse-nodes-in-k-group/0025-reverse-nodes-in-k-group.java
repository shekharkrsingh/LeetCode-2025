class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode prev = newHead;

        while (true) {
            ListNode temp = prev;
            for (int i = 0; i < k && temp != null; i++) {
                temp = temp.next;
            }
            if (temp == null) break;

            ListNode node = prev.next;
            ListNode revHead = reverse(node, k);

            prev.next = revHead;
            prev = node; 
        }

        return newHead.next;
    }

    private ListNode reverse(ListNode node, int k) {
        int cnt = 0;
        ListNode curr = node;
        ListNode prev = null;
        ListNode next;

        while (cnt < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            cnt++;
        }

        node.next = curr;
        return prev;
    }
}