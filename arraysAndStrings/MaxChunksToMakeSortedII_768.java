package arraysAndStrings;

public class MaxChunksToMakeSortedII_768 {
	public static int maxChunksToSorted(int[] arr) {
		int[] maxFromStart = new int[arr.length];
		int[] minFromEnd = new int[arr.length];
		
		maxFromStart[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (maxFromStart[i-1] < arr[i]) {
				maxFromStart[i] = arr[i];
			} else {
				maxFromStart[i] = maxFromStart[i-1];
			}
		}
		minFromEnd[minFromEnd.length - 1] = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0 ; i--) {
			if (arr[i] < minFromEnd[i+1]) {
				minFromEnd[i] = arr[i];
			} else {
				minFromEnd[i] = minFromEnd[i+1];
			}
		}
		
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(maxFromStart[i] + " ");
//		}
//		System.out.println();
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(minFromEnd[i] + " ");
//		}
		
		int chunk = 0;
		for (int i = 0; i < maxFromStart.length-1; i++) {
			if (maxFromStart[i] <= minFromEnd[i+1]) {
				chunk++;
			}
		}
		return ++chunk;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {18,12,16,22,20,24,30,28};
		System.out.println(maxChunksToSorted(arr));
	}

}
