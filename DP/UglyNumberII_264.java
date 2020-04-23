package DP;

public class UglyNumberII_264 {
	public static int nthUglyNumber(int n) {
		int[] dp = new int[n];
		dp[0] = 1; //first ugly number is by default1
		int twoPointer = 0;
		int threePointer = 0;
		int fivePointer = 0;
		
		
		for (int i = 1; i < dp.length; i++) {
			int a = dp[twoPointer]*2;
			int b = dp[threePointer]*3;
			int c = dp[fivePointer]*5;
			int temp = Math.min(a, b);
			int min = Math.min(temp, c);
			dp[i] = min;
			if (dp[i] == a) {
				twoPointer++;
			}
			if (dp[i] == b) {
				threePointer++;
			}
			if (dp[i] == c) {
				fivePointer++;
			}
		}
		return dp[n-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		System.out.println("Nth ugly number is "+nthUglyNumber(n));
	}

}
