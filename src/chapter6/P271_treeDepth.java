package chapter6;
import base.BinaryTreeNode;

public class P271_treeDepth {
	public static int depth(BinaryTreeNode<Integer> node) {
		if (node == null)
			return 0;
		int left = depth(node.left);
		int right = depth(node.right);
		
		return (left>right)?left+1:right+1;
	}
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(1);
		root.left = new BinaryTreeNode<Integer>(2);
		root.right = new BinaryTreeNode<Integer>(3);
		root.right.right = new BinaryTreeNode<Integer>(6);
		root.left.left = new BinaryTreeNode<Integer>(4);
		root.left.right = new BinaryTreeNode<Integer>(5);
		root.left.right.right = new BinaryTreeNode<Integer>(7);
		System.out.println(depth(root));
	}

}
