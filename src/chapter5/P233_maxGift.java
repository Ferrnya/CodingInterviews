package chapter5;

public class P233_maxGift {
	public static int getMore(int[][] board) {
		if(board == null || board.length==0 || board[0].length==0) {
			return 0;
		}
		int rows = board.length;
		int cols = board[0].length;
	    int[][] dp = new int[rows][cols];
	    dp[0][0] = board[0][0];
	    
	    for(int i=1;i<cols;i++) {
	    	dp[0][i] = dp[0][i-1]+board[0][i];
	    }
	    for(int i=1;i<rows;i++) {
	    	dp[i][0] = dp[i-1][0]+board[i][0];
	    }
	    for(int i=1;i<rows;i++) {
	    	for(int j=1;j<cols;j++) {
	    		dp[i][j] = dp[i-1][j]>dp[i][j-1]?dp[i-1][j]:dp[i][j-1];
	    		dp[i][j] += board[i][j];
	    	}
	    }
	    
	    return dp[rows-1][cols-1];
	    
	}
	
	public static void main(String[] args) {
		int[][] board= {{1,10,3,8},
				  {12,2,9,6},
				  {5,7,4,11},
				  {3,7,16,5}};
		System.out.println(getMore(board));
	}

}
