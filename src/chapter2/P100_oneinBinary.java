package chapter2;

public class P100_oneinBinary {
	//十进制转二进制
//	public static int decimalToBinary(int n) {
//		String str = "";
//		while (n!=0) {
//			int remainder = n%2;
//			n = n/2;
//			str = remainder+str;
//		}
//		int binary = Integer.parseInt(str);
//		return binary;
//	}
	
	public static int numberofOne(int binary) {
		int count = 0;
        while(binary!=0) {
        	count++;
        	binary = (binary-1)&binary;
        }
        return count;
	}
	
	public static void main (String[] args) {
		System.out.println(numberofOne(13));
	}

}
