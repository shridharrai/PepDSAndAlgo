package DP;

public class SuperUglyNumber_313 {
	public static int nthSuperUglyNumber(int n, int[] primes) {
		int[] dp = new int[n+1];
		dp[1] = 1;
		int[] pointers = new int[primes.length];
		
		//Initially all the pointers are pointing to first index of dp
		for (int i = 0; i < pointers.length; i++) {
			pointers[i] = 1;
		}
		
		for (int i = 2; i < dp.length; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < primes.length; j++) {
				min = Math.min(min, primes[j] * dp[pointers[j]]);
			}
			
			dp[i] = min;  //Store the super ugly no. in dp
			
			//Inc the required pointers
			for (int k = 0; k < pointers.length; k++) {
				if (primes[k] * dp[pointers[k]] == min) {
//					int temp = pointers[k];
//					temp++;
//					pointers[k] = temp;
					pointers[k]++;
				}
			}
		}
		return dp[n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 12;
		int[] arr = {2,7,13,19};
		System.out.println(nthSuperUglyNumber(n, arr));
	}

}
