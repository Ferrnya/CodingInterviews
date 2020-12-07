package chapter2;

public class TreeLinkedNode<T> {
	public T val;
    public TreeLinkedNode<T> left;
    public TreeLinkedNode<T> right;
    public TreeLinkedNode<T> father;
    public TreeLinkedNode(T val){
        this.val=val;
        this.left=null;
        this.right=null;
        this.father=null;
    }
}
