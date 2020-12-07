package chapter6;

public class P304_maxProfit {
	public static int max(int[] nums) {
		if(nums==null || nums.length<2)
			return 0;
		int min = nums[0];
		int maxProfit = nums[1]-min;
        if(nums[1]<min)
            min=nums[1];
		for (int i=2;i<nums.length;i++) {
			if(nums[i]-min>maxProfit)
				maxProfit = nums[i]-min;
            if(nums[i]<min)
				min = nums[i];
		}
		return maxProfit<0?0:maxProfit;
	}

	public static void main(String[] args){
        int[] data1 = new int[]{9,11,8,5,7,12,16,14};
        int[] data2 = new int[]{9,8,7,6,5,4,3,1};
        System.out.println(max(data1)); //11
        System.out.println(max(data2)); //-1
    }
}
