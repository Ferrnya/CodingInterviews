package chapter7;

public class P318_strToInt {
	public static int strToInt(String str){
		if (str == null || str.length() == 0)
	        return 0;
	    boolean isNegative = str.charAt(0) == '-';
	    int ret = 0;
	    for (int i = 0; i < str.length(); i++) {
	        char c = str.charAt(i);
	        if (i == 0 && (c == '+' || c == '-'))  /* 符号判定 */
	            continue;
	        if (c < '0' || c > '9')                /* 非法输入 */
	            return 0;
	        ret = ret * 10 + (c - '0');
	    }
	    return isNegative ? -ret : ret;
	}
	
	public static void main(String[] args) {
		System.out.println(strToInt("12a3"));
		
	}

}
