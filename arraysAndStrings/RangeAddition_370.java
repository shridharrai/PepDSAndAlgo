package arraysAndStrings;

public class RangeAddition_370 {
	//O(n) and the brute force approach is in O(n^2)
	public static int[] getModifiedArray(int length, int[][] updates) {
		int[] originalarr = new int[length];
		int[] prefixSum = new int[length];
		for (int i = 0; i < updates.length; i++) {
			int startidx = updates[i][0];
			int endidx = updates[i][1];
			int inc = updates[i][2];
			originalarr[startidx] = originalarr[startidx] + inc;
			if ((endidx + 1) < length) {
				originalarr[endidx + 1] = originalarr[endidx + 1] - inc;
			}
		}
		
		prefixSum[0] = originalarr[0];
		for (int i = 1; i < originalarr.length; i++) {
			prefixSum[i] = prefixSum[i-1] + originalarr[i];
		}
		
		return prefixSum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] updates = {{1,3,2},{2,4,3},{0,2,-2}};
		int length = 5;
		int[] prefixSum = getModifiedArray(length, updates);
		for (int i = 0; i < prefixSum.length; i++) {
			System.out.println(prefixSum[i]);
		}
	}

}
