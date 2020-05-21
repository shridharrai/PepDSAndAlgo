package arraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum_Geeks {
	//O(nlogn)
	public static boolean hasArrayTwoCandidates(int[] nums, int target) {
		int i = 0;
		int j = nums.length-1;
		Arrays.sort(nums);
		while (i < j) {
			if ((nums[i] + nums[j]) > target) {
				--j;
			} else if ((nums[i] + nums[j]) < target) {
				i++;
			} else {
				return true;
			}
		}
		return false;
	}
	
	//O(n)
	public static boolean hasArrayTwoCandidates1(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if(map.containsKey(complement)) {
				return true;
			}
			map.put(nums[i], i);
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, -2, 1, 0, 5};
		int sum = 0;
		System.out.println(hasArrayTwoCandidates1(arr, sum));
	}

}
