package arraysAndStrings;

public class FirstMissingPositive_41 {
	//O(n)
	public static int firstMissingPositive(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= 0) {
				nums[i] = Integer.MAX_VALUE;
			}
		}
		
		for (int i = 0; i < nums.length; i++) {
			int pos = Math.abs(nums[i]) - 1;
			if (pos <= nums.length-1) {
				if (nums[pos] > 0) {
					nums[pos] = -nums[pos];
				}
			}
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				return i+1;
			}
		}
		
		return nums.length+1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {7,8,9,11,12};
		System.out.println(firstMissingPositive(arr));
	}

}
