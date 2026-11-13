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
        if(head == null || head.next == null) return null;
        
        int size = 0;
        ListNode t = head;
        while(t!=null){
            t=t.next;
            size++;
        }
        if(n == size) return head.next;
        t = head;
        for(int i=0; i<size-n-1; i++){
            t=t.next;
        }
        
        t.next = t.next.next;
        return head;
    }
}