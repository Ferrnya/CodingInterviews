package chapter5;

public class P246_num3 {
	public static boolean anagram(String str1,String str2) {
		if(str1==null || str2==null)
			return false;
		
		int[] times = new int[256];
		for(int i=0;i<str1.length();i++) {
			times[str1.charAt(i)]++;
		}
		for(int i=0;i<str2.length();i++) {
			times[str2.charAt(i)]--;
		}
		
		for(int i=0;i<times.length;i++) {
			if(times[i]!=0)
				return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(anagram("evil","live"));
		System.out.println(anagram("student","student."));
	}

}
