/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
import java.util.*;

class Solution {
    void insertCopyInBtw(Node head){
        Node temp = head;
        while(temp != null){
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = temp.next.next;
        }
    }
    void connectRandomPointers(Node head){
        Node temp = head;
        while(temp != null){
            if(temp.random != null) temp.next.random = temp.random.next;
            else temp.next.random = null;
            temp = temp.next.next;
        }
    }
    Node getDeepCopyList(Node head){
        Node dummy = new Node(-1);
        Node res = dummy, temp = head;
        while(temp != null){
            res.next = temp.next;
            res = res.next;
            temp.next = res.next;
            temp = temp.next;
        }
        return dummy.next;
    }
    public Node copyRandomList(Node head) {
        insertCopyInBtw(head);
        connectRandomPointers(head);
        return getDeepCopyList(head);
    }
}