package arraysAndStrings;

public class MajorityElement_169 {
	//O(n)
	public static int majorityElement(int[] nums) {
		int val = nums[0];
		int count = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == val) {
				count++;
			} else {
				if (count > 0) {
					count--;
				} else {
					val = nums[i];
					count = 1;
				}
			}
		}
		return val;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,2,1,1,1,2,2};
		System.out.println(majorityElement(arr));
	}

}
