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
        int size = size(head);
        if(n == size) return head.next;
       
       ListNode temp = head;
       for(int i = 1; i < (size - n); i++){
        temp = temp.next;
       }
       
       temp.next = temp.next.next;
       return head;
    }
    private static int size(ListNode head){ 
        int cnt = 0;
        while(head != null){
            cnt++;
            head = head.next;
        }
        return cnt;
    }
}