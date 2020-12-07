package chapter2;
import chapter2.TreeNode;
import java.util.*;


public class P60_treeNodeTraversal{
    public static List<Integer> preOrderTraversal(TreeNode<Integer> node){
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (node==null){
            return list;
        }
        list.add(node.val);
        list.addAll(preOrderTraversal(node.left));
        list.addAll(preOrderTraversal(node.right));
        return list;
    }
    
    public static List<Integer> inOrderTraversal(TreeNode<Integer> node){
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (node==null){
            return list;
        }
        list.addAll(inOrderTraversal(node.left));
        list.add(node.val);
        list.addAll(inOrderTraversal(node.right));
        return list;
    }
    
    public static List<Integer> postOrderTraversal(TreeNode<Integer> node){
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (node==null){
            return list;
        }
        list.addAll(postOrderTraversal(node.left));
        list.addAll(postOrderTraversal(node.right));
        list.add(node.val);    
        return list;
    }
    
    public static List<Integer> preOrderIteratively(TreeNode<Integer> node){
    	Stack<TreeNode<Integer>> s = new Stack<>();
    	TreeNode<Integer> cur = node;
    	List<Integer> list = new LinkedList<>();
        if (node==null){
            return list;
        }
        while(cur!=null || !s.isEmpty()){
            if(cur!=null){
                list.add(cur.val);
                s.push(cur);
                cur = cur.left;
            }
            else{
                cur = s.pop().right;
            }
        }
        return list;
    }
    
    public static List<Integer> inOrderIteratively(TreeNode<Integer> node){
    	Stack<TreeNode<Integer>> s = new Stack<>();
    	TreeNode<Integer> cur = node;
    	List<Integer> list = new LinkedList<>();
        if (node==null){
            return list;
        }
        while(cur!=null || !s.isEmpty()){
            if(cur!=null){
                s.push(cur);
                cur = cur.left;
            }
            else{
                cur = s.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }
    
    public static List<Integer> postOrderIteratively(TreeNode<Integer> node){
    	Stack<TreeNode<Integer>> s = new Stack<>();
    	TreeNode<Integer> cur = node;
    	TreeNode<Integer> pre = null;
    	List<Integer> list = new LinkedList<>();
        if (node==null){
            return list;
        }
        while(cur!=null || !s.isEmpty()){
            if(cur!=null){
                s.push(cur);
                cur = cur.left;
            }
            else{
                cur = s.peek().right;
                if(cur!=null && cur!=pre){
                    s.push(cur);
                    cur = cur.left;
                }else {
                	pre = s.pop();
                	list.add(pre.val);
                	cur = null;
                }
            }
        }
        return list;
    }
    
    public static List<Integer> levelOrderTraversal(TreeNode<Integer> node){
    	Queue<TreeNode<Integer>> q = new LinkedList<>();
    	List<Integer> list = new LinkedList<>();
    	TreeNode<Integer> temp = node;
    	if (node.val==null) {
    		return list;
    	}
    	q.add(node);
    	while (!q.isEmpty()) {
    		temp = q.poll();
    		list.add(temp.val);
    		if(temp.left!=null) {
    			q.offer(temp.left);
    		}
    		if(temp.right!=null) {
    			q.offer(temp.right);
    		}
    	}
    	return list; 	
    }
    
    public static void main (String[] args){
//                   1
//                  / \
//                 2   3
//                /  \
//               4    5
        TreeNode<Integer> treeNode = new TreeNode<Integer>(1);
        treeNode.left = new TreeNode<Integer>(2);
        treeNode.right = new TreeNode<Integer>(3);
        treeNode.left.left = new TreeNode<Integer>(4);
        treeNode.left.right = new TreeNode<Integer>(5);
        
        List<Integer> preOrderTraversal = preOrderTraversal(treeNode);
        System.out.println("Pre-Order Traversal Result: "+preOrderTraversal.toString());
        
        List<Integer> inOrderTraversal = inOrderTraversal(treeNode);
        System.out.println("In-Order Traversal Result: "+inOrderTraversal.toString());
        
        List<Integer> postOrderTraversal = postOrderTraversal(treeNode);
        System.out.println("Post-Order Traversal Result: "+postOrderTraversal.toString());
        
        List<Integer> preOrderIteratively = preOrderIteratively(treeNode);
        System.out.println("Pre-Order Iteratively Result: "+preOrderIteratively.toString());
        
        List<Integer> inOrderIteratively = inOrderIteratively(treeNode);
        System.out.println("In-Order Iteratively Result: "+inOrderIteratively.toString());
        
        List<Integer> postOrderIteratively = postOrderIteratively(treeNode);
        System.out.println("Post-Order Iteratively Result: "+postOrderIteratively.toString());
        
        List<Integer> levelOrderTraversal = levelOrderTraversal(treeNode);
        System.out.println("Level-OrderTraversal Result: "+levelOrderTraversal.toString());
    }
}