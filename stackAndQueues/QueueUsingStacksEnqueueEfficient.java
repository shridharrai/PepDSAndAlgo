package stackAndQueues;

import java.util.Stack;

public class QueueUsingStacksEnqueueEfficient {
	private Stack<Integer> s1;
	private Stack<Integer> s2;
	
	public QueueUsingStacksEnqueueEfficient() {
		// TODO Auto-generated constructor stub
		s1 = new Stack<Integer>();
		s2 = new Stack<Integer>();
	}
	//O(1)
	public void enqueue(int num) {
		s1.push(num);
	}
	//O(n)
	public int dequeue() {
		int size = s1.size();
		for (int i = 0; i < size-1; i++) {
			s2.push(s1.pop());
		}
		int ans = s1.pop();
		while (!s2.isEmpty()) {
			s1.push(s2.pop());
		}
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingStacksEnqueueEfficient queue = new QueueUsingStacksEnqueueEfficient();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}

}
