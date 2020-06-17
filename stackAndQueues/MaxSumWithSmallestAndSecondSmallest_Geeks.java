package stackAndQueues;

public class MaxSumWithSmallestAndSecondSmallest_Geeks {
	//O(n)
	public static int maxSum(int[] arr) {
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < arr.length-1; i++) {
			int sum = arr[i] + arr[i+1];
			max = Math.max(max, sum);
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,3,1,5,6};
		System.out.println(maxSum(arr));
	}

}
