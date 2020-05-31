package arraysAndStrings;

public class RotateImage_48 {
	//O(n^2)
	public static void rotate(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (j > i) {
					int temp = matrix[i][j];
					matrix[i][j] = matrix[j][i];
					matrix[j][i] = temp;
				}
			}
		}
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0, k = matrix.length - 1; j < k; j++,--k) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][k];
				matrix[i][k] = temp;
			}
		}
		
		for (int i = 0; i < matrix.length; i++) {
			System.out.println();
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		rotate(matrix);
	}

}
