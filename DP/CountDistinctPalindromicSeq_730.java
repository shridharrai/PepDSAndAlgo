package DP;

import java.util.HashMap;

public class CountDistinctPalindromicSeq_730 {
//	O(n^3)
	public static int countPSRec(String str, int si, int ei) {
		if (si > ei) {
			return 0;
		}
		if (si == ei) {
			return 1;
		}
		
		
		if (str.charAt(si) == str.charAt(ei)) {
			int li = 0;
			int hi = 0;
			for (int i = si+1; i < ei; i++) {
				if (str.charAt(i) == str.charAt(si)) {
					li = i;
					break;
				}
			}
			for (int i = ei-1; i > si; i--) {
				if (str.charAt(i) == str.charAt(ei)) {
					hi = i;
					break;
				}
			}
			
			if (li < hi) {
				return 2*countPSRec(str, si+1, ei-1) - countPSRec(str, li+1, hi-1);
			}
			else if (li == hi && (li>0 && hi>0)) {
				
				return (1 + (2*countPSRec(str, si+1, ei-1)));
			}
			else {
				return (2 + (2*countPSRec(str, si+1, ei-1)));
			}
		}
		
		else {
			return countPSRec(str, si + 1, ei) + countPSRec(str, si, ei-1) - 
					countPSRec(str, si + 1, ei - 1);
		}
	}
	
//	O(n^2)
	public static int countPSDp(String str) {
		int n = str.length();
		int[] lpos = new int[n];
		int[] rpos = new int[n];
		HashMap<Character, Integer> maplpos = new HashMap<>();
		HashMap<Character, Integer> maprpos = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			char ch = str.charAt(i);
			if (maplpos.containsKey(ch)) {
				lpos[i] = maplpos.get(ch);
				maplpos.put(ch, i);
			}
			else {
				lpos[i] = -1;
				maplpos.put(ch, i);
			}
		}
		
		for (int i = n-1; i >= 0; i--) {
			char ch = str.charAt(i);
			if (maprpos.containsKey(ch)) {
				rpos[i] = maprpos.get(ch);
				maprpos.put(ch, i);
			}
			else {
				rpos[i] = -1;
				maprpos.put(ch, i);
			}
		}
		
		for (int i = 0; i < n; i++) {
			System.out.println(lpos[i]);
		}
		System.out.println("Right");
		for (int i = 0; i < n; i++) {
			System.out.println(rpos[i]);
		}
		
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			dp[i][i] = 1;
		}
		for (int l = 2; l <= n; l++) {
			for (int i = 0; i < n; i++) {
				int k = l+i-1;
				if (k < n) {
					if (str.charAt(i) == str.charAt(k)) {
						int lo = rpos[i];
						int hi = lpos[k];
						System.out.println("Low " + lo + "High "+hi);
						if (lo == hi) {
							dp[i][k] = 2*dp[i+1][k-1] + 1;
						}
						else if (lo > hi) {
							dp[i][k] = 2*dp[i+1][k-1] + 2;
						}
						else {
							dp[i][k] = 2*dp[i+1][k-1] - dp[lo+1][hi-1];
						}
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
		String str = "bccb";
		System.out.println(countPSRec(str, 0, str.length()-1));
//		String str = "ababcbaba";
//		System.out.println("Number of distinct subseq are "+countPSDp(str));
	}

}
