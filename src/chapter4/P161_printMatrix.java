package chapter4;

public class P161_printMatrix {
	public static void printMatrix(int[][] numbers, int rows, int cols) {
		if (numbers==null || rows<=0 || cols<=0) {return;}
		int start = 0 ;
		while(rows>start*2 && cols>start*2) {
			corePrint(numbers,rows,cols,start);
			start++;
		}
	}
	
	public static void corePrint(int[][] numbers, int rows, int cols,int start) {
		int endX = cols-1-start;
		int endY = rows-1-start;
		
		//上方从左到右
		if (endX>start) {
			for (int i=start;i<=endX;i++) {
				System.out.print(numbers[start][i]+" ");
			}
		}
		
		//右方从上到下
		if (endY>start) {
			for (int i=start+1;i<=endY;i++) {
				System.out.print(numbers[i][endX]+" ");
			}
		}
		
		//下方从右到左
		if (start<endY && start<endX) {
			for (int i=endX-1;i>=start;i--) {
				System.out.print(numbers[endY][i]+" ");
			}
		}
		
		//左方从下到上
		if (start<endX && start+1<endY) {
			for (int i=endY-1;i>start;i--) {
				System.out.print(numbers[i][start]+" ");
			}
		}
	}
	
	public static void main(String args[]) {
		int[][] numbers = {{1,2,3,4,5},
				           {6,7,8,9,10},
				           {11,12,13,14,15}};
		int[][] data1={
                {1,2,3,4},
                {12,13,14,5},
                {11,16,15,6},
                {10,9,8,7},
        };
		printMatrix(numbers,3,5);
		System.out.println();
		printMatrix(data1,4,4);
	}

}
