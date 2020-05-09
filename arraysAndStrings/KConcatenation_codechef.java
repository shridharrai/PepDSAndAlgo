package arraysAndStrings;

public class KConcatenation_codechef {
	//O(n)
	public static int KConcatenation(int[] A, int k) {
		int[] B = new int[2*A.length];
		System.out.println("B length is "+B.length);
		for (int i = 0; i < A.length; i++) {
			B[i] = A[i];
		}
		int pos = A.length;
		System.out.println("Pos is "+pos);
		for (int i = 0; i < A.length; i++) {
			B[pos++] = A[i];
		}
		for (int i = 0; i < B.length; i++) {
			System.out.println(B[i]);
		}
		
		int kadansValue = maxSubArray(B);
		int sum = 0;
		for (int i = 0; i < A.length; i++) {
			sum = sum + A[i];
		}
		if (sum >= 0) {
			int maxSum = kadansValue + (k - 2)*sum;
			return maxSum;
		} else {
			return kadansValue;
		}
	}
	
	//Kadan's algo
	public static int maxSubArray(int[] nums) {
		int cmax = nums[0];
		int omax = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (cmax < 0) {
				cmax = nums[i];
			} else {
				cmax = cmax + nums[i];
			}
			if (omax < cmax) {
				omax = cmax;
			}
		}
		return omax;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2};
		KConcatenation(nums, 2);
	}

}
