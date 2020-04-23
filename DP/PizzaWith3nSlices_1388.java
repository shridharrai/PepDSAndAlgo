package DP;

public class PizzaWith3nSlices_1388 {
	public static int maxSizeSlices(int[] slices) {
		int n = slices.length;
		int arr1[] = new int[n-3];
		System.out.println("length "+arr1.length);
		int arr2[] = new int[n-1];
		
		for (int i = 1; i < n; i++) {
			//When first ele was not included
			arr2[i-1] = slices[i];
//			When first ele was included
			if (i >= 2 && i < n-1) {
				arr1[i-2] = slices[i];
			}
		}
		int ans1 = maxSum(arr2, n/3);
		System.out.println("Ans1 "+ans1);
		int ans2 = slices[0] + maxSum(arr1, (n/3) - 1);
		return Math.max(ans1, ans2);
	}
	
	public static int maxSum(int[] arr, int k) {
		int n = arr.length;
		if (n == 0) {
			return 0;
		}
		int[][] inc = new int[k+1][n];
		int[][] exc = new int[k+1][n];
		
		for (int i = 1; i <= k; i++) {
			inc[i][0] = arr[0];
		}
		
		for (int j = 1; j < n; j++) {
			inc[1][j] = arr[j];
		}
		
		for (int i = 1; i <= k; i++) {
			for (int j = 1; j < n; j++) {
				inc[i][j] = arr[j] + exc[i-1][j-1];
				exc[i][j] = Math.max(exc[i][j-1], inc[i][j-1]);
			}
		}
		return Math.max(inc[k][n-1], exc[k][n-1]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {4, 3, 1, 2, 5, 4, 6};
//		System.out.println("Sum is "+maxSum(arr, 3));
		int[] arr = {1,2,3,4,5,6};
		System.out.println("Max is "+maxSizeSlices(arr));
	}

}
