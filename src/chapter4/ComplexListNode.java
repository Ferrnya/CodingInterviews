package chapter4;

public class ComplexListNode<T> {
	public T val;
	public ComplexListNode<T> next;
	public ComplexListNode<T> sibling;
	public ComplexListNode(T val){
		this.val = val;
		this.next = null;
		this.sibling = null;
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("[");
		ComplexListNode<T> cur = this;
		while (cur!=null) {
			str.append(cur.val);
			if(cur.sibling!=null) {
				str.append("("+cur.sibling.val+")");
			}else {
				str.append("_");
			}
			str.append('\t');
			cur = cur.next;
		}
		return str.toString();
	}
}
