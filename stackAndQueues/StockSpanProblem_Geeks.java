package stackAndQueues;

import java.util.Stack;

public class StockSpanProblem_Geeks {
	//O(n)
	public static int[] stockSpan(int[] nums) {
		int[] ans = new int[nums.length];
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(nums.length-1);
		
		for (int i = nums.length-2; i >= 0; i--) {
			int num = nums[i];
			while (!stack.isEmpty() && nums[stack.peek()] < num) {
				int idx = stack.pop();
				ans[idx] = idx - i;
			}
			stack.push(i);
		}
		
		while (!stack.isEmpty()) {
			ans[stack.pop()] = 1;
		}
		
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {100,80,60,70,60,75,85};
		stockSpan(nums);
	}

}
