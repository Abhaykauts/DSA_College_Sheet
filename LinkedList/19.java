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
        if (head == null)
            return head;
        if (head.next == null)
            return head.next;

        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        ListNode curr = head;
        ListNode prev = null;
        int node_no = 0;

        while (curr != null && node_no < size - n) {
            prev = curr;
            curr = curr.next;
            node_no++;
        }
        if (node_no == size - n) {
            if (prev == null) {
                prev = curr.next;
                curr = null;
                return prev;
            }
            if (prev != null && curr.next != null) {
                prev.next = curr.next;
            } else {
                prev.next = null;
                return head;
            }
            curr.next = null;
        }
        return head;
    }
}