/**
*/
public class Solution{
     public static void main(String []args){
        System.out.println("Hello World");
        TreeNode root = new TreeNode();
        root.left = new TreeNode();
        root.right = new TreeNode();
        root.left.left = new TreeNode();
        root.left.right = new TreeNode();
        root.right.left = new TreeNode();
        root.left.left.left = new TreeNode();
        root.left.left.right = new TreeNode();
        root.left.right.left = new TreeNode();
        System.out.println( inTree(root, 1 , 12));
     }
     public static boolean inTree( TreeNode root, int id , int target){
        if( root!=null && id == target)
            return true;
        else if(root==null)
            return false;
        if( isSubtree(target,id*2))  // id*2 is index of left child
           return  inTree( root.left,id*2,target);
        else 
           return  inTree( root.right,id*2+1,target);
    
     }
     /* return true, if target is child node of current
     */
     public static boolean isSubtree(int target, int current){
         
        int layer = 0; int ub = current;
         while(ub<target){
             ub = 2*ub+1;
             layer++;
         }
         // i is upper bound
         int lb = current*(int)Math.pow( 2*1.0 , layer*1.0);
         return target<=ub&& target>=lb;
     }
     
}

class TreeNode{
    TreeNode left;
    TreeNode right;
}