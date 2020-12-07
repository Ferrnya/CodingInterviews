package chapter6;

public class P275_numInt {
	public static int[] find(int[] nums) {
		if(nums==null || nums.length==0 ||nums.length<2) 
			return null;
		int results = 0;
		for(int i=0;i<nums.length;i++)
			results ^= nums[i];
		int indexOf1 = findIndex(results);
		int[] output = new int[] {0,0};
		if(indexOf1<0)
			return output;
		for(int i=0;i<nums.length;i++) {
			if((nums[i]&indexOf1)==0) {
				output[0] ^= nums[i];
			}
			else {
				output[1] ^= nums[i];
			}
		}
		return output;
	}
	
	public static int findIndex(int num) {
		if(num<0)
			return -1;
		int indexOf1 =1;
		while(num!=0) {
			if((num&1)==1)
				return indexOf1;
			else {
				num = num>>1;
		        indexOf1*=2;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,4,3,6,3,2,5,5};
		int[] output = find(nums);
		System.out.println(output[0]);
		System.out.println(output[1]);
	}
	
	

}
