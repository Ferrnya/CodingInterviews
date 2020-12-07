package chapter6;

public class P286_leftReverse {
	public static String reverse(String str,int n) {
		if(str==null || str.length()==0 || n<=0|| n>str.length())
			return str;
		StringBuilder string = new StringBuilder(str);
		reverseSubString(string,0,n-1);
		reverseSubString(string,n,str.length()-1);
		reverseSubString(string,0,str.length()-1);
		return string.toString();
	}
	
	public static void reverseSubString(StringBuilder string, int start, int end) {
		while(start<end) {
			char temp = string.charAt(start);
			string.setCharAt(start,string.charAt(end));
			string.setCharAt(end,temp);
			start++;
			end--;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(reverse("abcdefg",2));
	}
	
}
