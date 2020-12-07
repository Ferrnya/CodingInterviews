package chapter5;

public class P225_seriesNum {
	public static int seriesNum(int index) {
		if(index<0) {
			return -1;
		}
		if(index<10) {
			return index;
		}
		int curIndex = 10;
		int curLength = 2;
		int boundNum = 10;
		
		while(curIndex+lengthSum(curLength)<index) {
			curIndex += lengthSum(curLength);
			boundNum *= 10;
			curLength++;
		}
		
		int addNum = (index-curIndex)/curLength;
		int curNum = boundNum + addNum;
		int numIndex = (index-curIndex)%curLength;
		int num = Integer.toString(curNum).charAt(numIndex)-'0';
		return num;
		
		
	}
	
	public static int lengthSum(int length) {
		int count = 9;
		for(int i=1;i<length;i++) {
			count *= 10;
		}
		return count*length;
	}
	
	public static void main(String[] args) {
		System.out.println(seriesNum(1001));
	}

}
