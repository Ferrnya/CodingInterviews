package chapter5;

public class P227_minNum {
	public static String minNum(int[] nums) {
		if(nums==null) {
			return null;
		}
		for(int i=0;i<nums.length;i++) {
			for(int j=0;j<nums.length-1-i;j++) {
				if(bigger(nums[j],nums[j+1])) {
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
		}
		String output = "";
		for (int i=0;i<nums.length;i++) {
			output += ""+nums[i];
		}
		return output;
	}
	
	//a>=b
	public static boolean bigger(int a,int b) {
		String temp = a+""+b;
		String temp1 = b+""+a;
		if(temp.compareTo(temp1)>=0) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] nums = {3,32,321};
		System.out.println(minNum(nums));
	}

}
