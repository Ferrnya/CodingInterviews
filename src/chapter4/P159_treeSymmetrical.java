package chapter4;
import base.BinaryTreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class P159_treeSymmetrical {
	//µÝ¹é
	public static boolean isSymmetrical(BinaryTreeNode<Integer> root) {
		if (root==null || (root.left==null && root.right==null)) {return true;}
		
		return coreSymmetrical(root,root);
	}
	
	public static boolean coreSymmetrical(BinaryTreeNode<Integer> root1,BinaryTreeNode<Integer> root2) {
		if (root1==null && root2==null) {return true;}
		if (root1==null || root2==null) {return false;}
		if (root1.val != root2.val) {return false;}
		return coreSymmetrical(root1.left,root2.right) && coreSymmetrical(root1.right,root2.left);
	}
	
	//µü´ú
	public static boolean isSymmetrical1(BinaryTreeNode<Integer> root) {
		if (root==null || (root.left==null && root.right==null)) {return true;}
		if (root.left==null || root.right==null) {return false;}
		Queue<BinaryTreeNode<Integer>> queueLeft = new LinkedList<>(); 
		Queue<BinaryTreeNode<Integer>> queueRight = new LinkedList<>();
		queueLeft.offer(root.left);
		queueRight.offer(root.right);
		BinaryTreeNode<Integer> tempLeft,tempRight;
		
		while(!queueLeft.isEmpty() && !queueRight.isEmpty()) {
			tempLeft = queueLeft.poll();
			tempRight = queueRight.poll();
			if (tempLeft.val==tempRight.val) {
				if (tempLeft.left!=null) {queueLeft.offer(tempLeft.left);}
				if (tempLeft.right!=null) {queueLeft.offer(tempLeft.right);}
				if (tempRight.right!=null) {queueRight.offer(tempRight.right);}
				if (tempRight.left!=null) {queueRight.offer(tempRight.left);}
			}else {return false;}
		}
		
		if (queueLeft.isEmpty() && queueRight.isEmpty()) {
			return true;
		}else {return false;}
		
	}
	
	public static void main(String args[]) {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(8);
		root.left = new BinaryTreeNode<Integer>(6);
		root.right = new BinaryTreeNode<Integer>(6);
		root.left.left = new BinaryTreeNode<Integer>(5);
		root.left.right = new BinaryTreeNode<Integer>(7);
		root.right.left = new BinaryTreeNode<Integer>(7);
		root.right.right = new BinaryTreeNode<Integer>(5);
		
		BinaryTreeNode<Integer> root1 = new BinaryTreeNode<Integer>(7);
		root1.left = new BinaryTreeNode<Integer>(7);
		root1.right = new BinaryTreeNode<Integer>(7);
		root1.left.left = new BinaryTreeNode<Integer>(7);
		root1.left.right = new BinaryTreeNode<Integer>(7);
		root1.right.left = new BinaryTreeNode<Integer>(7);
		
		System.out.println(isSymmetrical1(root)); //true
		System.out.println(isSymmetrical1(root1)); //false
	}

}
