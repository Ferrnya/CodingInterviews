package chapter2;
import chapter2.TreeLinkedNode;

public class P65_nextTreeNode {
	public static TreeLinkedNode<Integer> nextNode(TreeLinkedNode<Integer> node){
		if (node.val==null) {
			return null;
		}
		else if(node.right!=null) {
			node = node.right;
			while (node.left!=null) {
				node = node.left;
			}
			return node;
		}
		while (node.father!=null) {
			if(node.father.left == node) {
				return node.father;
			}
			node = node.father;
		}
		return null;
	}
	
	public static void main(String[] args) {
//      1
//     / \
//    2   3
//   /  \
//  4    5
// in-order:42513
        TreeLinkedNode<Integer> treeNode = new TreeLinkedNode<Integer>(1);
        treeNode.left = new TreeLinkedNode<Integer>(2);
        treeNode.left.father = treeNode;
        treeNode.right = new TreeLinkedNode<Integer>(3);
        treeNode.right.father = treeNode;
        treeNode.left.left = new TreeLinkedNode<Integer>(4);
        treeNode.left.left.father = treeNode.left;
        treeNode.left.right = new TreeLinkedNode<Integer>(5);
        treeNode.left.right.father = treeNode.left;
        
        System.out.println(nextNode(treeNode.left.left).val);
        System.out.println(nextNode(treeNode.left).val);
        System.out.println(nextNode(treeNode.left.right).val);
        System.out.println(nextNode(treeNode).val);
        System.out.println(nextNode(treeNode.right));
	}
 }
