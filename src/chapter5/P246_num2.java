package chapter5;

public class P246_num2 {
	public static String delete(String str) {
		if(str==null)
			return null;
		
		boolean[] times = new boolean[256];
		for(int i=0;i<times.length;i++) {
			times[i]=false;
		}
		StringBuilder output = new StringBuilder();
		for(int i=0;i<str.length();i++) {
			output.append(str.charAt(i));
			if(times[str.charAt(i)]==true) {
				output.deleteCharAt(output.length() - 1);
			}
			times[str.charAt(i)]=true;
		}
		
		
		
		return output.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(delete("google"));
	}


}
