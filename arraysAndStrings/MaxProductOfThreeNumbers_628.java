package arraysAndStrings;

import java.util.Arrays;

public class MaxProductOfThreeNumbers_628 {
	//O(nlogn)
	public static int maximumProduct(int[] nums) {
		Arrays.sort(nums);
		int max1 = nums[nums.length - 1];
		int max2 = nums[nums.length - 2];
		int max3 = nums[nums.length - 3];
		int min1 = nums[0];
		int min2 = nums[1];
		int prod1 = max1*max2*max3;
		int prod2 = min1*min2*max1;
		return Math.max(prod1, prod2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4};
		System.out.println(maximumProduct(arr));
	}

}
