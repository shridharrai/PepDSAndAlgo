package stackAndQueues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKEleOfQueue_Geeks {
	//O(n)
	public static void reverseKEle(Queue<Integer> queue, int k) {
		Stack<Integer> stack = new Stack<Integer>();
		while (stack.size() != 5) {
			stack.push(queue.poll());
		}
		while (!stack.isEmpty()) {
			queue.add(stack.pop());
		}
		for (int i = 0; i < queue.size()-k; i++) {
			queue.add(queue.poll());
		}
		
		while (!queue.isEmpty()) {
			System.out.print(queue.poll() + " ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		queue.add(50);
		queue.add(60);
		queue.add(70);
		queue.add(80);
		queue.add(90);
		queue.add(100);
		int k = 5;
		reverseKEle(queue, k);
	}

}
