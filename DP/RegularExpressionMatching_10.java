package DP;

public class RegularExpressionMatching_10 {
	public static boolean isMatch(String s, String p) {
		boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
		dp[0][0] = true;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				if (j == 0) {
					if (p.charAt(i-1) == '*') {
						dp[i][j] = dp[i-2][j];
					}
				} else {
						if (p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '.') {
							dp[i][j] = dp[i-1][j-1];
						} else if (p.charAt(i-1) == '*') {
							dp[i][j] = dp[i-2][j];
							if (p.charAt(i-2) == s.charAt(j-1) || p.charAt(i-2) == '.') {
								dp[i][j] = dp[i][j-1] || dp[i-2][j];
							}
						}
					}
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abcbbbdbh";
		String s2 = "a.cb*.*";
		System.out.println(isMatch(s1, s2));
	}

}
