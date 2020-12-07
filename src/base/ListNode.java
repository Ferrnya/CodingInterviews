package base;

public class ListNode<T> {
	public T val;
	public ListNode<T> next;
	public ListNode(T val) {
		this.val = val;
		this.next = null;
	}
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("[ ");
		for (ListNode<T> cur = this;;cur=cur.next) {
			if (cur==null) {
				str.deleteCharAt(str.lastIndexOf(" "));
				str.deleteCharAt(str.lastIndexOf(","));
				break;
			}
			str.append(cur.val);
			str.append(", ");
		}
		str.append("]");
		return str.toString();
	}

}
