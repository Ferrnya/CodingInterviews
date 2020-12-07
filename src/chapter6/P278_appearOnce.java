package chapter6;

public class P278_appearOnce {
	public static int find(int[] nums) {
		if(nums==null || nums.length==0)
			return -1;
		int[] bitSum = new int[32];
		for(int i=0; i<nums.length;i++) {
			int bitMask = 1;
			for(int j=31;j>=0;j--) {
				int bit = nums[i]&bitMask;
				if(bit!=0) {
					bitSum[j] += 1;
				}
				bitMask = bitMask<< 1;
			}
		}
		//实现二进制转化为数字
		int result = 0;
		for(int i=0;i<32;i++) {
			result = result<<1;
			result+=bitSum[i]%3;
		}
		return result;
	}
	public static void main(String[] args) {
		int[] data1 = new int[]{10,4,5,3,5,4,3,3,4,5};
        int[] data2 = new int[]{0,-4,5,3,5,-4,3,3,-4,5};
        int[] data3 = new int[]{-10,-4,5,3,5,-4,3,3,-4,5};
        System.out.println(find(data1));
        System.out.println(find(data2));
        System.out.println(find(data3));
	}

}
