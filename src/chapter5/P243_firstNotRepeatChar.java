package chapter5;

public class P243_firstNotRepeatChar {
	public static char notRepeat(String str) {
		if(str==null) {
			return 0;
		}
		
		int[] times = new int[256];
		for(int i=0;i<str.length();i++) {
			times[str.charAt(i)]++;
		}
		for(int i=0;i<str.length();i++) {
			if(times[str.charAt(i)]==1) {
				return str.charAt(i);
			}
		}
		return 0;		
	}
	
	public static void main(String[] args) {
		System.out.println(notRepeat("abaccdeff"));
	}

}
