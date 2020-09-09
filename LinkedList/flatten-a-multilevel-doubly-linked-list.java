/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node low = head,high = head;
        
        while(low!=null){
            if(low.child!=null){
                //fetch tail and add the child
                high = low.child;
                while(high.next!=null){
                    high = high.next;
                }
                high.next = low.next;
                if(low.next!=null)
                low.next.prev = high;
                low.next = low.child;
                low.next.prev = low;
                low.child = null;
            }
            low = low.next;
        }
        // Node temp = head;
        // while(temp!=null){
        //     System.out.println(temp.prev + " " + temp.val + " "+ temp.next);
        //     temp = temp.next;
        // }
        return head;
    }
}
