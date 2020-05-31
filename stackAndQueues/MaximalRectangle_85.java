package stackAndQueues;

public class MaximalRectangle_85 {
	public static int maximalRectangle(char[][] matrix) {
		int[] ans = new int[matrix[0].length];
		int omax = Integer.MIN_VALUE;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (Integer.parseInt(matrix[i][j]+"") != 0) {
					ans[j] = ans[j] + Integer.parseInt(matrix[i][j]+"");
				}
				else {
					ans[j] = Integer.parseInt(matrix[i][j]+"");
				}
			}
			System.out.println();
			for (int k = 0; k < ans.length; k++) {
				System.out.print(ans[k] + " ");
			}
			int max = LargestRectangleInHistogram_84.largestRectangleArea(ans);
			omax = Math.max(omax, max);
		}
		System.out.println();
		return omax;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
		System.out.println(maximalRectangle(matrix));
	}

}
