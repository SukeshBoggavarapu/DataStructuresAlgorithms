package leetCode2;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public List<Integer> spiralMatrix(int[][] matrix) {

		List<Integer> res = new ArrayList<Integer>();
		int rowStart = 0;
		int rowEnd = matrix.length - 1;
		int colStart = 0;
		int colEnd = matrix[0].length - 1;

		while (rowStart <= rowEnd && colStart <= colEnd) {

			// Go Right

			for (int i = colStart; i <= colEnd; i++) {

				res.add(matrix[rowStart][i]);
			}
			rowStart++;

			// Go down

			for (int i = rowStart; i <= rowEnd; i++) {

				res.add(matrix[i][colEnd]);

			}

			colEnd--;
			
			// Go Left
			if (rowStart <= rowEnd) {
				for (int i = colEnd; i >= colStart; i--) {

					res.add(matrix[rowEnd][i]);

				}
				rowEnd--;
			}
			
			// Go Up
			if (colStart <= colEnd) {
				for (int i = rowEnd; i >= rowStart; i--) {
					res.add(matrix[i][colStart]);
				}

				colStart++;

			}
		}

		return res;

	}

	public static void main(String[] args) {
		int[][] mat = new int[3][3];
		int k = 1;
		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 3; j++) {
				mat[i][j] = k;
				k++;
			}
		}
		SpiralMatrix sm = new SpiralMatrix();
		sm.spiralMatrix(mat);
	}

}
