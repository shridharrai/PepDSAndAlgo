package arraysAndStrings;

public class Segregate0_1And2 {
	//O(n)
	public static int[] segregate(int[] arr) {
		int i = 0, j = 0, k = arr.length - 1;
		while (j <= k) {
			if (arr[j] == 1) {
				j++;
			}
			else if (arr[j] == 0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j++;
			}
			else{            //If arr[j] == 2
				int temp = arr[k];
				arr[k] = arr[j];
				arr[j] = temp;
				k--;
			}
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		int[] ans = segregate(arr);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}
}
