package arraysAndStrings;

public class MaximumSubarray_53 {
	//O(n) by kadane's algo
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
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println("Max is "+maxSubArray(arr));
	}

}
