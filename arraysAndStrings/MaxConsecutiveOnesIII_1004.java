package arraysAndStrings;

import java.util.LinkedList;
import java.util.Queue;

public class MaxConsecutiveOnesIII_1004 {
	//O(n)
	public static int longestOnes(int[] A, int K) {
		int j = 0;
		int ans = Integer.MIN_VALUE;
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				queue.add(i);
				if (queue.size() > K) {
					int remove = queue.remove();
					j = remove + 1;
				}
			}
			ans = Math.max(ans, i-j+1);
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
		int k = 3;
		System.out.println(longestOnes(arr, k));
	}

}
