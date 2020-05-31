package stackAndQueues;

import java.util.Stack;

public class DailyTemperatures_739 {
	//O(n)
	public static int[] dailyTemperatures(int[] T) {
		int[] ans = new int[T.length];
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		
		for (int i = 1; i < ans.length; i++) {
			int num = T[i];
			while (!stack.isEmpty() && T[stack.peek()] < num) {
				int j = stack.pop();
				ans[j] = i-j;
			}
			stack.push(i);
		}
		
		while (!stack.isEmpty()) {
			ans[stack.pop()] = 0;
		}
		
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
		return ans;	
	}
	
	public static void main(String[] args) {
		int[] T = {73,74,75,71,69,72,76,73};
		dailyTemperatures(T);
	}
}
