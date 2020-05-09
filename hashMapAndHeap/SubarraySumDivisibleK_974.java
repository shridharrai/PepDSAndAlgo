package hashMapAndHeap;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumDivisibleK_974 {
	public static int subarraySum(int[] A, int k) {
		Map<Integer, Integer> myMap = new HashMap<>();
		int[] rem = new int[A.length + 1];
		int prefixSum = 0;
		int count = 0;
		rem[0] = 0;
		
		for (int i = 0; i < A.length; i++) {
			prefixSum = prefixSum + A[i];
			int temp = prefixSum % k;
			if (temp < 0) {
				rem[i+1] = temp+k;
			} else {
				rem[i+1] = temp;
			}
		}
		
		for (int i = 0; i < rem.length; i++) {
			if (myMap.containsKey(rem[i])) {
				count = count + myMap.get(rem[i]);
			}
			myMap.put(rem[i], myMap.getOrDefault(rem[i], 0) + 1);
		}
		
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,5,0,-2,-3,1};
		int k = 5;
		System.out.println(subarraySum(arr, k));
	}

}
