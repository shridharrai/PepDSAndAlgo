package stackAndQueues;

import java.util.Stack;

public class AsteroidCollision_735 {
	//O(n)
	public static int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(asteroids[0]);
		for (int i = 1; i < asteroids.length; i++) {
			if (asteroids[i] > 0) {
				stack.push(asteroids[i]);
			} else {
				if (!stack.isEmpty() && stack.peek() < 0) {
					stack.push(asteroids[i]);
				} else {
					while (!stack.isEmpty() && stack.peek() > 0 && Math.abs(asteroids[i]) > stack.peek()) {
						stack.pop();
					}
					if (stack.isEmpty() || stack.peek() < 0) {
						stack.push(asteroids[i]);
					} else if (stack.peek() == Math.abs(asteroids[i])) {
						stack.pop();
					}
				}
			}
		}
		
		int[] ans = new int[stack.size()];
		int i = ans.length-1;
		while (!stack.isEmpty()) {
			ans[i] = stack.pop();
			i--;
		}	
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,-2,-2,-2};
		int[] ans = asteroidCollision(arr);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i]+" ");
		}
	}

}
