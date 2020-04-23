package DP;

public class BestTimeToBuyAndSellStock_121 {
	public static int maxProfit(int[] prices) {
		int n = prices.length;
		int profit = 0;
		int maxsofar = prices[n-1];
		for (int i = n-2; i >= 0; i--) {
			if (prices[i] > maxsofar) {
				maxsofar = prices[i];
			}
			if (maxsofar - prices[i] > profit) {
				profit = maxsofar - prices[i];
			}
		}
		return profit;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {7,6,4,3,1};
		System.out.println("Max profit "+maxProfit(prices));
	}

}
