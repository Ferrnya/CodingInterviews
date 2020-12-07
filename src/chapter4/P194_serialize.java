package chapter4;
import base.BinaryTreeNode;

public class P194_serialize {
	public static String serialize(BinaryTreeNode<Integer> root) {
		if (root==null) {
			return "$,";
		}
		StringBuilder str = new StringBuilder();
		str.append(root.val);
		str.append(",");
		str.append(serialize(root.left));
		str.append(serialize(root.right));
		return str.toString();
	}
	
	public static BinaryTreeNode<Integer> deserialize(String str){
		StringBuilder string = new StringBuilder(str);
		return coreDeserialize(string);
	}
	
	public static BinaryTreeNode<Integer> coreDeserialize(StringBuilder string){
		if(string.length()==0) {
			return null;
		}
		String num = string.substring(0,string.indexOf(","));
		string.delete(0, string.indexOf(","));
		string.deleteCharAt(0);
		if(num.equals("$")) {
			return null;
		}
		BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(Integer.parseInt(num));
		node.left = coreDeserialize(string);
		node.right = coreDeserialize(string);
		return node;
	}
	
	public static void main(String[] args) {
       //      10
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
		String str = serialize(root);
		System.out.println(str);
		System.out.println(deserialize(str).toString());

	}
	
	

}
