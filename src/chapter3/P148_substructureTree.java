package chapter3;
import base.BinaryTreeNode;

public class P148_substructureTree {
	public static boolean hasSubtree(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> subroot) {
		if (subroot==null || root==null) {return false;}
		return doesTree1HasTree2(root,subroot) || hasSubtree(root.left,subroot) || hasSubtree(root.right,subroot);

	}
	
	public static boolean doesTree1HasTree2(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> subroot) {
		if(subroot==null) { return true;}
		if(root==null) { return false;}
		if (!(root.val.equals(subroot.val))) {return false;}
		return doesTree1HasTree2(root.left,subroot.left) && doesTree1HasTree2(root.right,subroot.right);
	}
	
	public static void main(String args[]) {
	//	     8
	//      / \	
	//     8   7
	//    / \
	//   9   2
	//      / \
	//     4   7
		BinaryTreeNode<Integer> root1 = new BinaryTreeNode<>(8);
        root1.left = new BinaryTreeNode<>(8);
        root1.right = new BinaryTreeNode<>(7);
        root1.left.left = new BinaryTreeNode<>(9);
        root1.left.right = new BinaryTreeNode<>(2);
        root1.left.right.left = new BinaryTreeNode<>(4);
        root1.left.right.right = new BinaryTreeNode<>(7);
        BinaryTreeNode<Integer> root2 = new BinaryTreeNode<>(8);
        root2.left = new BinaryTreeNode<>(9);
        root2.right = new BinaryTreeNode<>(2);
        System.out.println(hasSubtree(root1,root2));
	}

}
