package chapter2;

public class P92_robotPath {
	public static int pathNum(int threshold,int row,int cols) {
		if (threshold<0 || row<=0 || cols<=0) {
			return 0;
		}
		boolean[][] visitFlag = new boolean[row][cols];
		for (int i=0;i<row;i++) {
			for (int j=0;j<cols;j++) {
				visitFlag[i][j]=false;
			}
		}
		
		int result = pathNumCore(threshold,row,0,cols,0,visitFlag);
		
		return result;
		
		
		
	}
	
	public static int pathNumCore(int threshold,int row, int rowIndex,int cols,int colsIndex,boolean[][] visitFlag) {
		int count = 0;
		
		if(check(threshold,row,rowIndex,cols,colsIndex,visitFlag)) {
			visitFlag[rowIndex][colsIndex]=true;
			count = 1 + pathNumCore(threshold,row,rowIndex+1,cols,colsIndex,visitFlag)
			          + pathNumCore(threshold,row,rowIndex-1,cols,colsIndex,visitFlag)
			          + pathNumCore(threshold,row,rowIndex,cols,colsIndex+1,visitFlag)
			          + pathNumCore(threshold,row,rowIndex,cols,colsIndex-1,visitFlag);
			
		}
		return count;
		
	}
	
	public static boolean check(int threshold,int row, int rowIndex,int cols,int colsIndex,boolean[][] visitFlag) {
		if (rowIndex>=0 && rowIndex<row && colsIndex>=0 && colsIndex<cols&&!visitFlag[rowIndex][colsIndex]&&(getSum(rowIndex)+getSum(colsIndex)<=threshold)) {
			return true;	
		}
		return false;
	}
	
	public static int getSum(int num) {
		int sum = 0;
		while(num>0) {
			sum += num%10;
			num /=10;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(pathNum(0,3,4));  //1
	    System.out.println(pathNum(1,3,4));  //3
		System.out.println(pathNum(9,2,20)); //36
		System.out.println(pathNum(15,20,20));
	}

}
