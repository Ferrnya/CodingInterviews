package chapter6;
import java.util.*;
import chapter2.TreeNode;

public class P269_kNode {
	public static TreeNode<Integer> find(TreeNode<Integer> root, int k){
		if(root.val==null || k<=0)
			return null;
		ArrayList<TreeNode<Integer>> output = inOrderTraversal(root);
		if(k>=output.size())
			return null;
		return output.get(k-1);
		
	}
	
	public static ArrayList<TreeNode<Integer>> inOrderTraversal(TreeNode<Integer> node){
        ArrayList<TreeNode<Integer>> list = new ArrayList<TreeNode<Integer>>();
        if (node==null){
            return list;
        }
        list.addAll(inOrderTraversal(node.left));
        list.add(node);
        list.addAll(inOrderTraversal(node.right));
        return list;
    }
	
	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<>(5);
        root.left = new TreeNode<>(3);
        root.left.left = new TreeNode<>(2);
        root.left.right = new TreeNode<>(4);
        root.right = new TreeNode<>(7);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(8);
        System.out.println(find(root,3).val);//4
        System.out.println(find(root,6).val);//7
        System.out.println(find(root,8));//null
	}

}
