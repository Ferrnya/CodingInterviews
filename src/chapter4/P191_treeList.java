package chapter4;
import base.BinaryTreeNode;

public class P191_treeList {
	static BinaryTreeNode<Integer> head = null;
	static BinaryTreeNode<Integer> pre = null;
	public static BinaryTreeNode<Integer> convert(BinaryTreeNode<Integer> root){
		coreConvert(root);
		return head;
	}
	
	public static void coreConvert(BinaryTreeNode<Integer> node) {
		if (node==null) {return;}
		coreConvert(node.left);
		node.left = pre;
		if(pre!=null) {
			pre.right = node;
		}
		pre = node;
		if(head==null) {
			head = node;
		}
		coreConvert(node.right);
	}
	
	public static void main(String[] args){
        //            10
        //          /   \
        //         6     14
        //       /  \   / \
        //      4    8 12  16
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(10);
        root.left = new BinaryTreeNode<Integer>(6);
        root.right = new BinaryTreeNode<Integer>(14);
        root.left.left = new BinaryTreeNode<Integer>(4);
        root.left.right = new BinaryTreeNode<Integer>(8);
        root.right.left = new BinaryTreeNode<Integer>(12);
        root.right.right = new BinaryTreeNode<Integer>(16);
        BinaryTreeNode<Integer> list = convert(root);
        System.out.print(list.leftToRight());

    }
}
