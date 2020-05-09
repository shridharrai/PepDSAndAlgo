package hashMapAndHeap;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK_560 {
	//O(n^2)
	public static int subarraySum(int[] nums, int k) {
		int[] prefixSum = new int[nums.length];
		prefixSum[0] = nums[0];
		int sum = 0;
		int count = 0;
		
		for (int i = 1; i < nums.length; i++) {
			prefixSum[i] = prefixSum[i-1] + nums[i];
		}
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				if (i == 0) {
					sum = prefixSum[j];
				}
				else {
					sum = prefixSum[j] - prefixSum[i-1];
				}
				if (sum == k) {
					count++;
				}
			}
		}
		return count;
	}
	
	//O(n)
	public static int subarraySum1(int[] nums, int k) {
		int currSum = 0;
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			currSum = currSum + nums[i];
			if (currSum == k) {
				count++;
			}
			if (map.containsKey(currSum - k)) {
				count = count + map.get(currSum - k);
			}
			map.put(currSum, map.getOrDefault(currSum, 0) + 1);
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1};
		int k = 2;
		System.out.println(subarraySum(nums, k));
		System.out.println("Count is "+subarraySum1(nums, k));
	}

}
