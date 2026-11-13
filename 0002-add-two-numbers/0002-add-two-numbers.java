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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1, t2 = l2;
        ListNode d = new ListNode(-1);
        ListNode ans = d;
        int carry = 0;
        while(t1 != null || t2 != null){
            int sum = ((t1!=null)?t1.val:0) + ((t2!=null)?t2.val:0) + carry;
            int digit = sum%10;
            carry = sum/10;

            ListNode temp = new ListNode(digit);
            d.next = temp;
            d=d.next;
            if(t1!=null)t1=t1.next;
            if(t2!=null)t2=t2.next;
        }
        if(carry != 0){
            ListNode temp = new ListNode(carry);
            d.next = temp;
            d=d.next;
        }
        return ans.next;
    }
}