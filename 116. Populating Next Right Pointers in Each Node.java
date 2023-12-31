/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) { 
        populatePointer(root);
        return root;
    }
    
    public void populatePointer(Node head){
        
        if(head != null){
            
            if(head.left != null){
                head.left.next = head.right;
            }
            if(head.right != null && head.next != null){
                head.right.next = head.next.left;
            }
            populatePointer(head.left);
            populatePointer(head.right);
            
        }
           
    }
    
    
}
