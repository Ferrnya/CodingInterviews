//旋转数组 使用二分法实现
package chapter2;

public class P82_rotateArray {
	public static int rotate (int[] array) {
		if (array.length == 0 ) {
			System.out.println("This array doesn't have number!");
			return -1;
		}
		
		int lo = 0;
		int hi = array.length-1;
		int mid = lo;
		while (array[lo]>=array[hi]) {
			if (hi-lo==1) {
				mid=hi;
				break;
			}
			
			mid = lo+(hi-lo)/2;
			
			if(array[lo]==array[hi]&&array[lo]==array[mid]) {
				return midOrder(array,lo,hi);
			}
			
			if (array[mid]>=array[lo]) {
				lo=mid;
			}else if (array[mid]<=array[hi]) {
				hi=mid;
			}
		}
		return array[mid];
		
	}
	
	public static int midOrder(int[] array, int lo, int hi) {
		int result = array[lo];
		for (int i=lo+1;i<=hi;i++) {
			if(result>array[i]) {result=array[i];}
		}
		return result;
	}
	
	public static void main (String[] args) {
		int[] array = {9,1,2,3,4,5,6};
		System.out.println(rotate(array));
	}

}
