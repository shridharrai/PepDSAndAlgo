package stackAndQueues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackUsingQueuePushEfficient {
	private Queue<Integer> q1;
	private Queue<Integer> q2;
	
	public StackUsingQueuePushEfficient() {
		q1 = new LinkedList<Integer>();
		q2 = new LinkedList<Integer>();
	}
	//O(1)
	public void push(int num) {
		q1.add(num);
	}
	//O(n)
	public int pop() {
		int size = q1.size();
		for (int i = 0; i < size-1; i++) {
			q2.add(q1.remove());
		}
		int ans = q1.remove();
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackUsingQueuePushEfficient stack = new StackUsingQueuePushEfficient();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.push(60);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
