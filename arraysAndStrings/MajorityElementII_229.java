package arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII_229 {
	//O(n)
	public static List<Integer> majorityElement(int[] nums) {
		int val1 = nums[0];
		int count1 = 1;
		int val2 = 0;
		int count2 = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == val1) {
				count1++;
			} else if (nums[i] == val2) {
				count2++;
			} else if (count1 == 0) {
				val1 = nums[i];
				count1 = 1;
			} else if (count2 == 0) {
				val2 = nums[i];
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}
		
		int temp1 = 0;
		int temp2 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == val1) {
				temp1++;
			}
			if (nums[i] == val2) {
				temp2++;
			}
		}
		
		List<Integer> list = new ArrayList<Integer>();
		if (temp1 > nums.length/3) {
			list.add(val1);
		}
		if (temp2 > nums.length/3) {
			list.add(val2);
		}
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,1,1,3,3,2,2,2};
		System.out.println(majorityElement(arr));
	}

}
