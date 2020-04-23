package DP;

public class BestTimeToBuyAndSellStockII_122 {
	
	public static int maxProfit(int[] prices) {
		int bp = -1;
//		int sp = 0;
		int profit = 0;
		for (int i = 0; i < prices.length-1; i++) {
			if ((prices[i+1] > prices[i]) && bp == -1) {
				bp = i;
			}
			if (prices[i+1] < prices[i] && bp != -1) {
				profit = profit +(prices[i] - prices[bp]);
				bp = -1;
			}
		}
		if (bp != -1) {
			profit = profit + (prices[prices.length-1] - prices[bp]);
		}
		return profit;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,1,6,7,4,9,5,13,12,9,5,8};
		System.out.println(maxProfit(arr));
	}

}
