package chapter2;
import chapter2.TreeNode;

import java.util.List;

import chapter2.P60_treeNodeTraversal;

public class P62_rebuildTreeNode {
	public static TreeNode<Integer> rebuild(int[] pre, int[] in){
		if(pre==null || in==null ||pre.length!=in.length ||  pre.length==0) {
			return null;
		}
		return rebuildCore(pre,0,in,0,pre.length);
	}
	
	public static TreeNode<Integer> rebuildCore(int[] pre, int pre_start, int[] in, int in_start, int length){
		if (length==0) {
			return null;
		}
		int in_index = -1;
		for(int i=in_start; i<in_start+length; i++) {
			if(in[i]==pre[pre_start]) {
				in_index = i;
				break;
			}
		}
		int left_length = in_index - in_start;
		TreeNode<Integer> treeNode = new TreeNode<Integer>(in[in_index]);
		treeNode.left = rebuildCore(pre,pre_start+1,in,in_start,left_length);
		treeNode.right = rebuildCore(pre,pre_start+left_length+1,in,in_start+left_length+1,length-left_length-1);
		return treeNode;
	}
	
	public static void main(String[] args) {
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in = {4,7,2,1,5,3,8,6};
		List<Integer> postOrderTraversal = P60_treeNodeTraversal.postOrderTraversal(rebuild(pre,in));
        System.out.println("Post-Order Traversal Result: "+postOrderTraversal.toString());
		
	}
}
