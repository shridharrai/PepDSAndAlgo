package arraysAndStrings;

import java.util.ArrayList;

public class BestMettingPoint_296 {
	//O(n^2)
	public static int minTotalDistance(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		System.out.println("Rows "+rows + " Cols "+cols);
		ArrayList<Integer> row = new ArrayList<Integer>();
		ArrayList<Integer> col = new ArrayList<Integer>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 1) {
					row.add(i);
				}
			}
		}
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				if (grid[j][i] == 1) {
					col.add(i);
				}
			}
		}
		System.out.println(row);
		System.out.println(col);
		
		int x = row.get(row.size()/2);
		int y = col.get(col.size()/2);
		System.out.println(x+" "+y);
		
		int ans = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 1) {
					ans = ans + (Math.abs(x-i) + Math.abs(y-j));
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = {{1,1,0,0,1},{1,0,1,0,0},{0,0,1,0,1}};
		System.out.println("Ans is "+minTotalDistance(arr));
	}

}
