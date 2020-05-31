package arraysAndStrings;

public class WiggleSort_Premium {
	public static void wiggleSort(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (i % 2 == 0) {
				if (nums[i] > nums[i+1]) {
					int temp = nums[i];
					nums[i] = nums[i+1];
					nums[i+1] = temp;
				} 
			} else {
				if (nums[i] < nums[i+1]) {
					int temp = nums[i+1];
					nums[i+1] = nums[i];
					nums[i] = temp;
				}
			}
		}
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,5,2,1,6,4};
		wiggleSort(arr);
	}

}
