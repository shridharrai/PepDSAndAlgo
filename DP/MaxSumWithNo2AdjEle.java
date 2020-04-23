package DP;

public class MaxSumWithNo2AdjEle {
	public static int maxSum(int[] arr) {
		int inc = arr[0];
		int exc = 0;
		for (int i = 1; i < arr.length; i++) {
			int temp = inc;
			inc = exc + arr[i];
			exc = Math.max(temp, exc);
		}
		return Math.max(inc, exc);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 3};
		System.out.println("Sum is "+maxSum(arr));
	}

}
