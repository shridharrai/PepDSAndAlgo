package stackAndQueues;

public class QueueUsingLinkedList {
	private class Node {
		int data;
		Node next;
	}
	private Node head;
	private Node tail;
	private int size;
	
	//O(1) -> addLast
	private void enqueue(int num) {
		//Create a new node
		Node node = new Node();
		node.data = num;
		node.next = null;
		//Attach node to end of linked list
		if (this.size >= 1) {
			this.tail.next = node;
		}
		//Summary object updation
		if (this.size == 0) {
			this.head = node;
			this.tail = node;
			this.size++;
		} else {
			this.tail = node;
			this.size++;
		}
	}
	//O(1) -> removeFirst
	private int dequeue() {
		int rv = this.head.data;
		
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size--;
		} else {
			this.head = this.head.next;
			this.size--;
		}
		return rv;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueUsingLinkedList queue = new QueueUsingLinkedList();
		queue.enqueue(10);
		queue.enqueue(12);
		queue.enqueue(13);
		queue.enqueue(14);
		queue.enqueue(16);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}

}
