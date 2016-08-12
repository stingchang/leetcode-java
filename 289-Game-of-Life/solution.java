public class Solution {
public void gameOfLife(int[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0)
			return;
		
		int row = board.length;
		int col = board[0].length;
		int[] cc = {-1,0,1,-1,1,-1,0,1};
		int[] rr = {-1,-1,-1,0,0,1,1,1};
		/*
		 x x x
		 x a x
		 x x x 
		 */
		int[][] sumArr = new int[row][col];
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				int sum = 0;
				for (int i = 0; i < 8; i++) {
					int adjR = rr[i] + r;
					int adjC = cc[i] + c;
					if ((adjR >= 0 && adjR <= row - 1) && (adjC >= 0 && adjC <= col - 1)) {
						sum += board[adjR][adjC] % 2;
					}
				}
				sumArr[r][c] = sum;
				// next status
				// 00->10
				if (board[r][c] % 2 == 0 ) {
					if(sum == 3)
						board[r][c] |= 2;
				} else {
					// 01->01
					if(sum<2 || sum>3)
						board[r][c] &=1;
					// 01->11
					else 
						board[r][c] |= 2;
				}
			}
		}
//		System.out.println("sum");
//print(sumArr);
//System.out.println("....");
//print(board);
//System.out.println("end sum");
		 flip(board);
	}

	void flip(int[][] board) {
		int row = board.length;
		int col = board[0].length;
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				board[r][c] = board[r][c] >> 1;
			}
		}
	}
}