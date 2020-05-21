package arraysAndStrings;

public class MaxChunksToMakeSorted_769 {
	//O(n)
	public static int maxChunksToSorted(int[] arr) {
		int max = Integer.MIN_VALUE;
		int chunks = 0;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
			if (max == i) {
				chunks++;
			}
		}
		return chunks;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,0,2,3,4};
		System.out.println(maxChunksToSorted(arr));
	}

}
