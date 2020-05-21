package arraysAndStrings;

public class SortArrayByParity_905 {
	//O(n)
	public static int[] sortArrayByParity(int[] A) {
		int i = 0, j = 0;
		while (j < A.length) {
			if (A[j]%2 != 0) {
				j++;
			} else {
				int temp = A[j];
				A[j] = A[i];
				A[i] = temp;
				i++;
				j++;
			}
		}
		return A;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,1,2,4};
		int[] ans = sortArrayByParity(arr);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}

}
