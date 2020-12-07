package chapter5;

public class P236_longestStr {
	public static int longest(String str) {
		if(str==null) {
			return 0;
		}
		
		int[] dp = new int[str.length()];
		dp[0] = 1;
		int maxNum = 1;
		for (int dpIndex=1;dpIndex<str.length();dpIndex++) {
			int i=dpIndex-1;
			for(;i>=dpIndex-dp[dpIndex-1];i--) {
				if(str.charAt(dpIndex)==str.charAt(i)) {
					break;
				}
			}
			dp[dpIndex] = dpIndex-i;
			if(dp[dpIndex]>maxNum) {
				maxNum = dpIndex;
			}
		}
		
		return maxNum;
	}
	
	public static void main(String[] args) {
		String str = "arabcacfr";
		System.out.println(longest(str));
		String str1 = "abcdefaaa";
		System.out.println(longest(str1));
	}

}
