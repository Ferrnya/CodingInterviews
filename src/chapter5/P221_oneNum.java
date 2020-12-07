package chapter5;
import java.lang.Math;

public class P221_oneNum {
	public static int count(int num) {
		if(num<=0) {
			return 0;
		}
		if(num<10) {
			return 1;
		}
		
		String numString = Integer.toString(num);
		char firstChar = numString.charAt(0);
		String leastNum = numString.substring(1);
		int countFirst = 0;
		if(firstChar>'1') {
			countFirst = power10(numString.length()-1);
		}
		else {
			countFirst = Integer.parseInt(leastNum)+1;
		}
		int countOthers = (firstChar-'0')*power10(numString.length()-2)*(numString.length()-1);
		return countFirst+countOthers+count(Integer.parseInt(leastNum));
	}
	
	public static int power10(int num) {
		int result = 1;
		for(int i=0;i<num;i++) {
			result *= 10;
		}
		return result;
	}
	
	public static int count1(int num) {
		if(num<=0) {
			return 0;
		}
		int number = 0;
		for (int i=1;i<=num;i++) {
			number+=numberOfOne(i);
		}
		return number;
	}
	
	public static int numberOfOne(int num) {
		int number = 0;
		while(num!=0) {
			if(num%10==1) {
				number++;
			}
			num /= 10;
		}
		return number;
	}
	
	
	public static void main(String[] args) {
		System.out.println(count(121));
		System.out.println(count1(121));
	}

}
