package chapter6;
import base.BinaryTreeNode;
import java.math.*;

public class P273_balance {
	private static boolean isBalanced = true;
	public static boolean isBalance(BinaryTreeNode<Integer> root) {
		height(root);
		return isBalanced;	
		
	}
	
	public static int height(BinaryTreeNode<Integer> node) {
		if(node==null || !isBalanced)
			return 0;
		int left = height(node.left);
		int right = height(node.right);
		if(Math.abs(left-right)>1)
			isBalanced = false;
		return 1+Math.max(left, right);
	}
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1);
        root.left = new BinaryTreeNode<Integer>(2);
        root.left.left = new BinaryTreeNode<Integer>(4);
        root.left.right = new BinaryTreeNode<Integer>(5);
        root.left.right.left = new BinaryTreeNode<Integer>(7);
        root.right = new BinaryTreeNode<Integer>(3);
        root.right.right = new BinaryTreeNode<Integer>(6);
        System.out.println(isBalance(root));
	}

}
