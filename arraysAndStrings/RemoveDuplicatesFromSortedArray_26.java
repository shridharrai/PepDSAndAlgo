package arraysAndStrings;

public class RemoveDuplicatesFromSortedArray_26 {
	//O(n)
	public static int removeDuplicates(int[] nums) {
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[j-1]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i+1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0,0,1,1,1,2,2,3,3,4};
		System.out.println(removeDuplicates(arr));
	}

}
