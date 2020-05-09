package hashMapAndHeap;

import java.util.HashMap;
import java.util.Map;

public class MaxConsecutiveOnes_485 {
	public static int findMaxConsecutiveOnes(int[] nums) {
//		Map<Integer, Integer> map = new HashMap<>();
//		int key = 0;
		int maxsofar = 0;
//		for (int i = 0; i < nums.length; i++) {
//			if (nums[i] == 1) {
//				map.put(key, map.getOrDefault(key, 0) + 1);
//				int count = map.get(key);
//				if (maxsofar < count) {
//					maxsofar = count;
//				}
//				if (i+1 <= nums.length-1) {
//					if (nums[i+1] == 0) {
//						key = key + 1;
//					}
//				}
//			}
//		}
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				count = 0;
			}
			if (nums[i] == 1) {
				count++;
				if (count > maxsofar) {
					maxsofar = count;
				}
			}
		}
		return maxsofar;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,1,0,1,1,1};
		System.out.println("Count "+findMaxConsecutiveOnes(arr));
	}

}
