package DP;

public class WildcardMatching_44 {
	public static boolean isMatch(String s, String p) {
		int row = p.length() + 1;
		int col = s.length() + 1;
		boolean[][] dp = new boolean[row][col];
		dp[0][0] = true;
		if (p.charAt(0) == '*') {
			dp[1][0] = true;
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (s.charAt(j-1) == p.charAt(i-1) || p.charAt(i-1) == '?') {
					if (dp[i-1][j-1]) {
						dp[i][j] = true;
					}
				}
				if (p.charAt(i-1) == '*') {
					if (dp[i-1][j]) {
						dp[i][j] = true;
					} else {
						if (dp[i][j-1]) {
							dp[i][j] = true;
						}
					}
				}
			}
		}
		return dp[row-1][col-1];
	}
	public static void main(String[] args) {
		// TODO Auto-enerated method stub
		String s1 = "cb";
		String s2 = "?b";           
		System.out.println(isMatch(s1, s2));
	}

}
