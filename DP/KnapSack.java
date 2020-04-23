package DP;

public class KnapSack {
	public static long start;
	public static long end;
	
	public static void startAlgo() {
		start = System.currentTimeMillis();
	}
	public static long endAlgo() {
		end = System.currentTimeMillis();
		return end - start;
	}
	// O(2^n)
	static int knapsackRec(int[] w, int[] p, int n, int W) {
		if (n == 0 || W == 0) {
			return 0;
		}
		if (w[n-1] > W) {
			return knapsackRec(w, p, n-1, W);
		}
		else {
			return Math.max(knapsackRec(w, p, n-1, W), 
					p[n-1] + knapsackRec(w, p, n-1, W-w[n-1]));
		}
	}
	
	//O(nW)
	static int knapsackDP(int[] w, int[] p, int n, int W) {
		int[][] memo = new int[n+1][W+1];
		
		for (int ele = 0; ele <= n; ele++) {
			for (int cap = 0; cap <= W; cap++) {
				if (ele == 0 || cap == 0) {
					memo[ele][cap] = 0;
				}
				else if (w[ele-1] > cap) {
					memo[ele][cap] = memo[ele-1][cap];
				}
				else {
					memo[ele][cap] = Math.max(memo[ele-1][cap], 
							p[ele-1] + memo[ele-1][cap-w[ele-1]]);
				}
			}
		}
		return memo[n][W];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] p = new int[] {7, 4, 5, 3};
		int[] w = new int[] {4, 2, 3, 1};
		int W = 6;
		int n = p.length;
		startAlgo();
		System.out.println(knapsackRec(w, p, n, W));
		System.out.println("Knapsack Recusrsive took time "+endAlgo()+" ms ");
		
		startAlgo();
		System.out.println(knapsackDP(w, p, n, W));
		System.out.println("Knapsack DP took time "+endAlgo()+" ms ");
	}

}
