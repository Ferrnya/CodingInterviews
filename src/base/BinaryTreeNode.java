package base;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import chapter2.TreeNode;

public class BinaryTreeNode<T> {
	public T val;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;
    public BinaryTreeNode(T val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
    
    //≤„–Ú±È¿˙
    public String toString() {
    	StringBuilder stringBuilder = new StringBuilder("[");
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.offer(this);
        BinaryTreeNode<T> temp;
        while(!queue.isEmpty()){
            temp = queue.poll();
            stringBuilder.append(temp.val);
            stringBuilder.append(",");
            if(temp.left!=null)
                queue.offer(temp.left);
            if(temp.right!=null)
                queue.offer(temp.right);
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        stringBuilder.append("]");
        return stringBuilder.toString();	
    }
    
    public String leftToRight() {
    	StringBuilder stringBuilder = new StringBuilder("[");
    	BinaryTreeNode<T> temp = this;
    	while (temp!=null) {
    		stringBuilder.append(temp.val);
    		stringBuilder.append(",");
    		temp = temp.right;
    	}
    	stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        stringBuilder.append("]");
    	return stringBuilder.toString();
    }

}
