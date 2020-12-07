package chapter2;

public class P89_matrixPath {
	public static boolean hasPath(char[][] matrix,int row,int cols,char[] str) {
		if (matrix==null || row==0 || cols==0 || str==null) {
			return false;
		}
		boolean[][] visitFlag = new boolean[row][cols];
		for (int i=0;i<row;i++) {
			for (int j=0;j<cols;j++) {
				visitFlag[i][j]=false;
			}
		}
		for (int i=0;i<row;i++) {
			for (int j=0;j<cols;j++) {
				if(hasPathCore(matrix, visitFlag,row, i,cols,j,str, 0)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static boolean hasPathCore(char[][] matrix, boolean[][] visitFlag, int row, int rowIndex,int cols,int colsIndex,char[] str, int strIndex ) {
		if(strIndex>=str.length) {return true;}
		if(rowIndex<0 || rowIndex>=row || colsIndex<0 || colsIndex>=cols ) {
			return false;
		}
		
		if(!visitFlag[rowIndex][colsIndex] && matrix[rowIndex][colsIndex]==str[strIndex]) {
			visitFlag[rowIndex][colsIndex]=true;
			
			boolean result = hasPathCore(matrix,visitFlag,row,rowIndex-1,cols,colsIndex,str,strIndex+1) ||
					         hasPathCore(matrix,visitFlag,row,rowIndex+1,cols,colsIndex,str,strIndex+1) ||
					         hasPathCore(matrix,visitFlag,row,rowIndex,cols,colsIndex-1,str,strIndex+1) ||
					         hasPathCore(matrix,visitFlag,row,rowIndex,cols,colsIndex+1,str,strIndex+1);
			if(result) {return true;}
			else {
				visitFlag[rowIndex][colsIndex]=false;
				return false;
			}
		}
		return false;
	}
	
	public static void main(String[] args){
        char[][] data = {
                {'a','b','t','g'},
                {'c','f','c','s'},
                {'j','d','e','h'}};
        char[] str1 ={'b','f','c','e'};
        char[] str2 ={'a','b','f','b'};
        char[][] data1 = {{'a','b'}};
        char[] str3 ={'b','a'};
        System.out.println(hasPath(data1,1,2,str3)); //true
        System.out.println(hasPath(data,3,4,str2)); //false,���ʹ���λ�ò����ٷ���
    }

}
