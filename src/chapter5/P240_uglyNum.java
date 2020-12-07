package chapter5;

public class P240_uglyNum {
	//解法一：耗费时间
	public static int uglyNumber1(int index) {
		if(index<=0) {
			return 0;
		}
		
		int number=0;
		int uglyFound=0;
		while(uglyFound<index) {
			number++;
			if(isUgly(number)) {
				uglyFound++;
			}
		}
		return number;
	}
	
	public static boolean isUgly(int num) {
		while(num%2==0) {
			num=num/2;
		}
		while(num%3==0) {
			num=num/3;
		}
		while(num%5==0) {
			num=num/5;
		}
		return (num==1)?true:false;
	}
	
	//解法二：以空间换时间
	public static int uglyNumber2(int index) {
		if(index<=0) {
			return 0;
		}
		int[] uglyNum = new int[index];
		uglyNum[0] = 1;
		int uglyIndex=0;
		int ugly2=0;
		int ugly3=0;
		int ugly5=0;
		while(uglyIndex+1<index) {
			uglyNum[++uglyIndex] = min(uglyNum[ugly2]*2,uglyNum[ugly3]*3,uglyNum[ugly5]*5);
			if(uglyNum[uglyIndex]==uglyNum[ugly2]*2) 
				ugly2++;
			if(uglyNum[uglyIndex]==uglyNum[ugly3]*3) 
				ugly3++;
			if(uglyNum[uglyIndex]==uglyNum[ugly5]*5) 
				ugly5++;			
		}
		return uglyNum[index-1];
	}
	
	public static int min(int x,int y,int z) {
		int temp=x<y?x:y;
		return z<temp?z:temp;
	}
	
	public static void main(String[] args) {
		System.out.println(uglyNumber1(10));
		System.out.println(uglyNumber2(10));
	}

}
