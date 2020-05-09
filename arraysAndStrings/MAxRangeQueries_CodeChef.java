package arraysAndStrings;

public class MAxRangeQueries_CodeChef {
	//O(n)
	public static int getModifiedArray(int length, int[][] updates, int k) {
		int[] originalarr = new int[length+1];
		int[] prefixSum = new int[length];
		for (int i = 0; i < updates.length; i++) {
			int startidx = updates[i][0];
			int endidx = updates[i][1];
			originalarr[startidx] = originalarr[startidx] + 1;
			originalarr[endidx + 1] = originalarr[endidx + 1] - 1;
		}
		
		prefixSum[0] = originalarr[0];
		for (int i = 1; i < prefixSum.length; i++) {
			prefixSum[i] = prefixSum[i-1] + originalarr[i];
		}
		
		int[] prefixCountOfK = new int[length];
		int[] prefixCountOfKPlus1 = new int[length];
		if (prefixSum[0] == k) {
			prefixCountOfK[0] = 1;
		}
		if (prefixSum[0] == k+1) {
			prefixCountOfKPlus1[0] = 1;
		}
		
		for (int i = 1; i < prefixSum.length; i++) {
			if (prefixSum[i] == k) {
				prefixCountOfK[i] = prefixCountOfK[i-1] + 1;
				prefixCountOfKPlus1[i] = prefixCountOfKPlus1[i-1];
			}
			else if (prefixSum[i] == k+1) {
				prefixCountOfKPlus1[i] = prefixCountOfKPlus1[i-1] + 1;
				prefixCountOfK[i] = prefixCountOfK[i-1];
			}
			else {
				prefixCountOfK[i] = prefixCountOfK[i-1];
				prefixCountOfKPlus1[i] = prefixCountOfKPlus1[i-1];
			}
		}
		
//		for (int i = 0; i < prefixCountOfK.length; i++) {
//			System.out.println(prefixCountOfK[i]);
//		}
//		System.out.println("-------------------------");
//		for (int i = 0; i < prefixCountOfKPlus1.length; i++) {
//			System.out.println(prefixCountOfKPlus1[i]);
//		}
		
		int ans = Integer.MIN_VALUE;
		int count = 0;
		for (int i = 0; i < updates.length; i++) {
			int startidx = updates[i][0] - 1;
			int endidx = updates[i][1];
			count = prefixCountOfK[length-1];
			int loss = 0;
			int gain = 0;
			if (startidx != 0) {
				loss = prefixCountOfK[endidx] - prefixCountOfK[startidx];
				gain = prefixCountOfKPlus1[endidx] - prefixCountOfKPlus1[startidx];
			} else {
				 loss = prefixCountOfK[endidx];
				 gain = prefixCountOfKPlus1[endidx];
			}
			count = (count-loss) + gain;
			if (count > ans) {
				ans = count;
			}
		}
//		System.out.println("Count is "+count);
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] updates = {{2,6},{4,9},{1,4}};
		int length = 10;
		int K = 2;
		System.out.println("Count is "+getModifiedArray(length, updates, K));
	}

}
