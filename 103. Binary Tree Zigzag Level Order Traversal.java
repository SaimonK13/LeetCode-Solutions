/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        
        // Solution 1: with 2 stacks
        
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.add(root);
        
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            
            if(!stack1.isEmpty()){
                
                List <Integer> tmp = new ArrayList<>();
                int n = stack1.size();
                
                for(int i = 0; i < n; i++){
                    
                    TreeNode node = stack1.pop();
                    tmp.add(node.val);
                    
                    if(node.left != null){
                        stack2.add(node.left);
                    }
                    
                    if(node.right != null){
                        stack2.add(node.right);
                    }
                    
                }
                
                list.add(tmp);
                
            }
            
            if(!stack2.isEmpty()){
                
                List<Integer> tmp = new ArrayList<>();
                int n = stack2.size();
                
                for(int i = 0; i < n; i++){
                    
                    TreeNode node = stack2.pop();
                    tmp.add(node.val);
                    
                    if(node.right != null){
                        stack1.add(node.right);
                    }
                    
                    if(node.left != null){
                        stack1.add(node.left);
                    }    
                    
                }
                
                list.add(tmp);
            }

        }
  
/********************************************/    
        // Solution 2: with reversing queue
        int s = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while( !q.isEmpty()){
            
            int n = q.size();
            List<Integer> tmp = new ArrayList<>();
            
            for(int i = 0; i < n; i++){
                
                TreeNode node = q.poll();
                
                tmp.add(node.val);
                
                if(node.left != null){
                    q.add(node.left);
                }
                
                if(node.right != null){
                    q.add(node.right);
                }
                
                
            }
            
            if(s == 1){
                
                Collections.reverse(tmp);
                s = 0;
                list.add(tmp);
            }
            
            else{
                list.add(tmp);
                s++;
            }
            
            
        }
        
        return list; 
        
    }
}
