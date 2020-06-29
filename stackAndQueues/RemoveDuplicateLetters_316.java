package stackAndQueues;

import java.util.HashMap;
import java.util.Stack;

public class RemoveDuplicateLetters_316 {
	//O(n)
	public static String removeDuplicateLetters(String s) {
		HashMap<Character, Integer> freqMap = new HashMap<>();
		HashMap<Character, Boolean> visitedMap = new HashMap<>();
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < s.length(); i++) {
			freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0)+1);
			visitedMap.put(s.charAt(i), false);
		}
		
		for(Character key : freqMap.keySet()) {
			System.out.println(key + ":" + freqMap.get(key));
		}
		
		for (int i = 0; i < s.length(); i++) {
			if (!visitedMap.get(s.charAt(i))) {
				while (!stack.isEmpty() && stack.peek() > s.charAt(i) && freqMap.get(stack.peek()) > 0) {
					char rem = stack.pop();
					visitedMap.put(rem, false);
				}
				stack.push(s.charAt(i));
				visitedMap.put(s.charAt(i), true);
			}
			freqMap.put(s.charAt(i), freqMap.get(s.charAt(i))-1);
		}
		String ans = new String();
		while (!stack.isEmpty()) {
			ans = stack.pop() + ans;
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = 	"bcabc";
		System.out.println(removeDuplicateLetters(s));
	}

}
