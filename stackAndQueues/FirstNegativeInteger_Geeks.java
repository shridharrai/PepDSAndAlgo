package stackAndQueues;

public class FirstNegativeInteger_Geeks {
	//O(n)
	public static void firstNegative(int[] arr, int k) {
		int[] ans = new int[arr.length-k+1];
		int neg = -1;
		int i = arr.length-1;
		while (i > arr.length-k) {
			if (arr[i] < 0) {
				neg = i;
			}
			--i;
		}
		
		while (i >= 0) {
			if (arr[i] < 0) {
				ans[i] = arr[i];
				neg = i;
			} else {
				if (neg >= i && neg <= i+k-1) {
					ans[i] = arr[neg];
				} else {
					ans[i] = 0;
				}
			}
			--i;
		}
		for (int j = 0; j < ans.length; j++) {
			System.out.print(ans[j] + " ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
		int k = 3;
		firstNegative(arr, k);
	}

}
