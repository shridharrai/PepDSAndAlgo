package arraysAndStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementGeneral_Geeks {
	//O(n)
	public static List<Integer> majorityElement(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		
		List<Integer> list = new ArrayList<Integer>();
		for (Integer key : map.keySet()) {
			int count = map.get(key);
			if (count > nums.length/k) {
				list.add(key);
			}
		}
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,1,2,2,1,2,3,3};
		int k = 4;
		System.out.println(majorityElement(arr, k));
	}

}
