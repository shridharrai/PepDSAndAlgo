package stackAndQueues;

import java.util.Stack;

public class MaxDiffBetweenLeftAndRightSmaller_Geeks {
	//O(n)
	public static int maxDiff(int[] nums) {
		int ans = Integer.MIN_VALUE;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		int nsr = 0;
		int nsl = 0;
		
		for (int i = 1; i < nums.length; i++) {
			int num = nums[i];
			while (!stack.isEmpty() && nums[stack.peek()] > num) {
				nsr = num;
				stack.pop();
				if (!stack.isEmpty()) {
					nsl = nums[stack.peek()];	
				} else {
					nsl = 0;
				}
				int diff = Math.abs(nsr - nsl);
				ans = Math.max(ans, diff);
			}
			stack.push(i);
		}
		
		while (!stack.isEmpty()) {
			nsr = 0;
			stack.pop();
			if (!stack.isEmpty()) {
				nsl = nums[stack.peek()];	
			} else {
				nsl = 0;
			}
			int diff = Math.abs(nsr - nsl);
			ans = Math.max(ans, diff);
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,1,9,2,5,1,7};
		System.out.println(maxDiff(arr));
	}

}
