package chapter4;
import base.BinaryTreeNode;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class P182_treePath {
	public static void findPath(BinaryTreeNode<Integer> root, int nums) {
		if(root==null) {return;}
		List<BinaryTreeNode<Integer>> path = new ArrayList<BinaryTreeNode<Integer>>();
		int cur = 0;
		coreFind(root,path,cur,nums);
	}
	
	public static void coreFind(BinaryTreeNode<Integer> node,List<BinaryTreeNode<Integer>> path,int cur,int nums) {
		cur += node.val;
		path.add(node);
		boolean isLeaf = node.left==null && node.right==null;
		
		if (cur==nums && isLeaf) {
			for(int i=0;i<path.size();i++) {
				System.out.print(path.get(i).val+" ");
			}
			System.out.println(" ");
		}
		if(node.left!=null) {
			coreFind(node.left,path,cur,nums);			
		}
		if(node.right!=null) {
			coreFind(node.right,path,cur,nums);
		}
		path.remove(path.size()-1);		
	}
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(10);
		root.left = new BinaryTreeNode<Integer>(5);
		root.right = new BinaryTreeNode<Integer>(12);
		root.left.left = new BinaryTreeNode<Integer>(4);
		root.left.right = new BinaryTreeNode<Integer>(7);
		findPath(root,22);
	}
	

}
