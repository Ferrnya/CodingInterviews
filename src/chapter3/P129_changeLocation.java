package chapter3;

public class P129_changeLocation {
	public static int[] change(int[] num) {
		if (num.length==0) {
			return num;
		}
		
		return coreChange(num,0,num.length-1);
	}
	
	public static int[] coreChange(int[] num, int startIndex, int endIndex) {
		while (startIndex<endIndex) {
			if (num[startIndex]%2==0 && num[endIndex]%2==1) {
				int temp = num[startIndex];
				num[startIndex] = num[endIndex];
				num[endIndex] = temp;
				startIndex +=1;
				endIndex -=1;
			}else if (num[startIndex]%2!=0 && num[endIndex]%2==1) {
				startIndex +=1;
			}else if (num[startIndex]%2==0 && num[endIndex]%2!=1) {
				endIndex -=1;
			}else {
				startIndex +=1;
				endIndex -=1;
			}
		}
		return num;
		
	}
	
	public static void main(String args[]) {
		int[] num = {1,7,4,3,7,8,4,4,6,7};
		int[] changeNum = change(num);
		for (int i=0;i<changeNum.length;i++) {
			System.out.println(changeNum[i]);
		}
		
	}

}
