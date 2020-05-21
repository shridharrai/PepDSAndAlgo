package arraysAndStrings;

public class Segregate0And1 {
	//O(n)
	public static int[] segregate(int[] arr) {
		int i = 0, j = 0;
		while (j < arr.length) {
			if (arr[j] == 1) {
				j++;
			}
			else {              //If arr[j] == 0
				int k = arr[i];
				arr[i] = arr[j];
				arr[j] = k;
				i++;
				j++;
			}
		}
		return arr;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
		int[] ans = segregate(arr);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}

}
