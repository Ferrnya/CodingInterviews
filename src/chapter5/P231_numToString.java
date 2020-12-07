package chapter5;

public class P231_numToString {
	public static int numToString(int num) {
		if(num<0) {
			return 0;
		}
		if(num<10) {
			return 1;
		}
		
		String numString = Integer.toString(num);
		int f1=0;
		int f2=1;
		int g=0;
		for(int i=numString.length()-2;i>=0;i--) {
			if(Integer.parseInt(numString.charAt(i)+""+numString.charAt(i))<26) {
				g=1;
			}else {
				g=0;
			}
			int temp=f2;
			f2=f2+g*f1;
			f1 = temp;
		}
	    
		return f2;
	}
	
	public static void main(String[] args) {
		int num = 12258;
		System.out.println(numToString(num));
		
		int[][] dp = new int[5][6];
	}
	

}
