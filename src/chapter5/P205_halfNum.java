package chapter5;

public class P205_halfNum {
	//使用快排的方法
	public static int checkHalfNum1(int[] nums) {
		if(nums.length==0) {
			return 0;
		}
		
		int left = 0;
		int right = nums.length-1;
		int k = nums.length/2;
		int index = partition(nums,left,right);
		while (index!=k) {
			if(index>k) {
				index = partition(nums,left,index-1);
			}else {
				index = partition(nums,index+1,right);
			}
		}
		
		boolean half = CheckMoreThanHalf(nums,nums[k]);
        if (half){
            return nums[k];
        }
		return 0;
	}

	public static int partition(int[] nums, int left, int right) {
		int pivot = nums[left];
		while(left<right) {
			while (left<right && nums[right]>=pivot) {
				right--;
			}
			if(left<right) {
				nums[left] = nums[right];
			}
			while (left<right && nums[left]<pivot) {
				left++;
			}
			if (left<right) {
				nums[right] = nums[left];
			}
		}
		nums[left] = pivot;
		return left;
	}
	
	public static int checkHalfNum2(int[] nums) {
		if(nums.length==0) {
			return -1;
		}
		
		int result = nums[0];
		int times = 1;
		for(int i=0;i<nums.length;i++) {
			if(times == 0) {
				result = nums[i];
				times = 1;
			}else if(nums[i]==result) {
				times++;
			}else {
				times--;
			}
		}
		
		if(!CheckMoreThanHalf(nums,result)) {
			return -1;
		}
		
		return result;
	}
	
	public static boolean CheckMoreThanHalf(int[] nums, int result) {
		int times = 0;
		for (int i=0; i<nums.length;i++) {
			if(result==nums[i]) {
				times++;
			}
		}
		
		boolean isHalf = true;
		if(times*2<=nums.length) {
			isHalf = false;
		}
		
		return isHalf;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,2,2,2,5,4,2};
		System.out.println(checkHalfNum1(nums));
		System.out.println(checkHalfNum2(nums));
	}
	
	

}
