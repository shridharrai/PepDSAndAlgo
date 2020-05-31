package arraysAndStrings;

public class NumberOfSubarraysWithBoundedMax_795 {
	//O(n)
	public static int numSubarrayBoundedMax(int[] A, int L, int R) {
		int smaller = 0;
		int ans = 0;
		int j = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] >= L && A[i] <= R) {
				smaller = i-j+1;
				ans = ans + smaller;
			} else if (A[i] < L) {
				ans = ans + smaller;
			} else {
				j = i+1;
				smaller = 0;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0,3,1,2,0,5,1,2,10,6};
		int L = 3;
		int R = 6;
		System.out.println(numSubarrayBoundedMax(arr, L, R));
	}

}
