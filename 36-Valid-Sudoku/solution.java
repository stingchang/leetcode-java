public class Solution {
  public boolean isValidSudoku(char[][] board) {
		return checkMatrix(board) && checkRows(board) && checkCols(board);
	}

	boolean checkMatrix(char[][] board) {

		// 00 03 06
		// 30 33 36
		// 60 63 66

		// c =0, 3, 6
		for (int cc = 0; cc <= 6; cc += 3) {
			for (int rr = 0; rr <= 6; rr += 3) {

				// each 3x3 sub matrix
				Set<Character> set = new HashSet<>();
				for (int r = 0; r < 3; r++) {
					for (int c = 0; c < 3; c++) {

						char cur = board[r + rr][c + cc];

						if (set.contains(cur)) {
//							System.out.println("here");
							return false;
						}
						if (notValidNum(cur)){
//							System.out.println("here "+cur);
							return false;
						}
							
						if (cur != '.')
							set.add(cur);
					}
				}
			}
		}
		return true;
	}

	boolean checkRows(char[][] board) {

		for (int r = 0; r < board.length; r++) {
			Set<Character> set = new HashSet<>();
			for (int c = 0; c < board[0].length; c++) {
				char cur = board[r][c];

				if (set.contains(cur)) {

					return false;
				}

				if (notValidNum(cur)) {

					return false;
				}

				if (cur != '.')
					set.add(cur);
			}
		}

		return true;

	}

	boolean checkCols(char[][] board) {

		for (int c = 0; c < board[0].length; c++) {
			Set<Character> set = new HashSet<>();
			for (int r = 0; r < board.length; r++) {
				char cur = board[r][c];

				if (set.contains(cur)) {
					// System.out.println("here");
					return false;
				}

				if (notValidNum(cur)) {

					return false;
				}

				if (cur != '.')
					set.add(cur);
			}
		}

		return true;
	}

	boolean notValidNum(char c) {
		if (c - '1' >= 0 || '9' - c <= 0 || c=='.')
			return false;
		return true;
	}

// 	public static void main(String[] args) {
// 		String[] strins = { ".87654321", "2........", "3........", "4........", "5........", "6........", "7........",
// 				"8........", "9........" };
// 		char[][] board = new char[9][9];
// 		for (int i = 0; i < 9; i++) {
// 			board[i] = strins[i].toCharArray();
// 			System.out.println(Arrays.toString(board[i]));
// 		}

// 		Q036_ValidSudoku2 q = new Q036_ValidSudoku2();
// 		boolean b = q.isValidSudoku(board);
// 		System.out.println(b);

// 	}
}