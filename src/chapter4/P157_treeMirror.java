package chapter4;
import base.BinaryTreeNode;
import java.util.LinkedList;
import java.util.Queue;


public class P157_treeMirror {
	//µÝ¹é
	public static void mirror(BinaryTreeNode<Integer> root){
		if (root==null || (root.left==null && root.right==null)) {return;}
		
		BinaryTreeNode<Integer> cur = root.left;
		root.left = root.right;
		root.right = cur;
		
		if (root.left!=null) {
			mirror(root.left);
		}
		if (root.right!=null) {
			mirror(root.right);
		}	
	}
	
	//µü´ú
	public static void mirror1(BinaryTreeNode<Integer> root) {
		if (root==null || (root.left==null && root.right==null)) {return;}
		Queue<BinaryTreeNode<Integer>> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			BinaryTreeNode<Integer> cur = q.poll();
			if(cur.left!=null || cur.right!=null) {
				BinaryTreeNode<Integer> temp = cur.left;
				cur.left = cur.right;
				cur.right = temp;
			}
			if (cur.left!=null) {q.offer(cur.left);}
			if (cur.right!=null) {q.offer(cur.right);}		
			
		}
	}
	
	public static void main(String args[]) {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(8);
		root.left = new BinaryTreeNode<Integer>(6);
		root.right = new BinaryTreeNode<Integer>(10);
		root.left.left = new BinaryTreeNode<Integer>(5);
		root.left.right = new BinaryTreeNode<Integer>(7);
		root.right.left = new BinaryTreeNode<Integer>(9);
		root.right.right = new BinaryTreeNode<Integer>(11);
		System.out.println(root);
		mirror1(root);
		System.out.println(root);
	}

}
