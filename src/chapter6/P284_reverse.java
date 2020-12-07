package chapter6;

public class P284_reverse {
	public static String reverse(String str) {
		if(str==null || str.length()==0)
			return str;
		StringBuilder string = new StringBuilder(str);
		reverseSubString(string,0,string.length()-1);
		int start=0;
		int end=string.indexOf(" ");
		while(start<string.length() && end!=-1) {
			reverseSubString(string,start,end-1);
			start=end+1;
			end=string.indexOf(" ",start);
		}
		if(start<string.length())
			reverseSubString(string,start,string.length()-1);
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
		System.out.println(reverse("I am a student."));
	}
	

}
