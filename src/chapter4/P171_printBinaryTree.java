package chapter4;
import base.BinaryTreeNode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class P171_printBinaryTree {
	public static void p171printBinaryTree(BinaryTreeNode<Integer> root) {
		if(root==null) {return;}
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			BinaryTreeNode<Integer> cur = queue.poll();
			System.out.print(cur.val+" ");
			if (cur.left!=null) {queue.offer(cur.left);}
			if (cur.right!=null) {queue.offer(cur.right);}			
		}
	}
	
	public static void p174printBinaryTree(BinaryTreeNode<Integer> root) {
		if(root==null) {return;}
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		queue.offer(root);
		System.out.println(" ");
		while(!queue.isEmpty()) {
			for (int size=queue.size();size>0;size--) {
				BinaryTreeNode<Integer> cur = queue.poll();
				System.out.print(cur.val+" ");
				if (cur.left!=null) {queue.offer(cur.left);}
				if (cur.right!=null) {queue.offer(cur.right);}	
			}
			System.out.println(" ");
		}
	}
	
	public static void p176printBinaryTree(BinaryTreeNode<Integer> root) {
		if(root==null) {return;}
		Stack<BinaryTreeNode<Integer>> stack1 = new Stack<BinaryTreeNode<Integer>>();
		Stack<BinaryTreeNode<Integer>> stack2 = new Stack<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> temp;
		stack1.push(root);
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			if (!stack1.isEmpty()) {
				while(!stack1.isEmpty()) {
					temp = stack1.pop();
					System.out.print(temp.val+" ");
					if (temp.left!=null) {stack2.push(temp.left);}
					if (temp.right!=null) {stack2.push(temp.right);}	
				}			
			}else {
				while(!stack2.isEmpty()) {
					temp = stack2.pop();
					System.out.print(temp.val+" ");
					if (temp.left!=null) {stack1.push(temp.right);}
					if (temp.right!=null) {stack1.push(temp.left);}	
				}			
			}
			System.out.println(" ");
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
		p171printBinaryTree(root);
		System.out.println(" ");
		p174printBinaryTree(root);
		System.out.println(" ");
		p176printBinaryTree(root);
	}

}
