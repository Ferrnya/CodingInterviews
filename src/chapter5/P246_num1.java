package chapter5;

public class P246_num1 {
	public static String delete(String str1, String str2) {
		if(str1==null || str2==null)
			return null;
		
		int[] times = new int[256];
		for(int i=0;i<str2.length();i++) {
			times[str2.charAt(i)]++;
		}
		StringBuilder output = new StringBuilder();
		for(int i=0;i<str1.length();i++) {
			output.append(str1.charAt(i));
			if(times[str1.charAt(i)]!=0) {
				output.deleteCharAt(output.length() - 1);
			}
		}
		
		return output.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(delete("We are student.","aeiou"));
	}

}
