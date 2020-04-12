package DP;

public class CountAllPalindromicSeq {
	public static int countPSRec(String str, int si, int ei) {
		if (si > ei) {
			return 0;
		}
		if (si == ei) {
			return 1;
		}
		
		if (str.charAt(si) == str.charAt(ei)) {
			return 1 + countPSRec(str, si + 1, ei) + countPSRec(str, si, ei-1) ;
		}
		
		else{
			return countPSRec(str, si + 1, ei) + countPSRec(str, si, ei-1) - 
					countPSRec(str, si + 1, ei - 1);
		}
	}
	
	//My Soln
	public static int countPSDp(String str) {
		int n = str.length();
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
					dp[i][i] = 1;
			}
		
		int k = 1;
		for (int i = 1; k < n ; k++) {
			i = k;
			for (int j = 0; i < n; j++,i++) {
				if (str.charAt(i) == str.charAt(j)) {
					dp[j][i] = dp[j][i-1] + dp[j+1][i] +1;
				}
				if (str.charAt(i) != str.charAt(j)) {
					dp[j][i] = dp[j][i-1] + dp[j+1][i] - dp[j+1][i-1];
				}
			}
		}
		
		System.out.println("Print Elements");
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				System.out.println(dp[i][j]);
			}
			
		}
		return dp[0][n-1];
	}
	
	public static int countPSDp1(String str) {
		int n = str.length();
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
					dp[i][i] = 1;
			}
		
		for (int l = 2; l <= n; l++) {
			for (int i = 0; i < n; i++) {
				int k = l+i-1;
				if (k < n) {
					if (str.charAt(i) == str.charAt(k)) {
						dp[i][k] = dp[i][k-1] + dp[i+1][k] +1;
					}
					else {
						dp[i][k] = dp[i][k-1] + dp[i+1][k] - dp[i+1][k-1];
					}
				}
			}
		}
		return dp[0][n-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcdca"; 
//		System.out.println("Number of subsequences are "+countPSRec(str, 0, str.length()-1));
		System.out.println("Number of subsequences are "+countPSDp1(str));
	}

}
