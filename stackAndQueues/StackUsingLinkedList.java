package stackAndQueues;

public class StackUsingLinkedList {
	//Inner class
	private class Node {
		int data;
		Node next;
	}
	private Node head;
	private Node tail;
	private int size;
	
	//O(1) -> addFirst
	public void push(int num) {
		//Create a new Node
		Node node = new Node();
		node.data = num;
		node.next = null;
		//Attach to Start in linkedlist if already nodes exist
		if (this.size >= 1) {
			node.next = head;
		}
		//Summary Object Update
		if (this.size == 0) {
			this.head = node;
			this.tail = node;
			this.size++;
		} else {
			this.head = node;
			this.size++;
		}
	}
	//O(1) -> removeFirst
	public int pop() {
		int rv = this.head.data;
		
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size--;
		} else {
			this.head = this.head.next;
		}
		return rv;
	}
	
	public void display() {
		System.out.println("-------------------------");
		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + ",");
			temp = temp.next;
		}
		System.out.println(".");
		System.out.println("--------------------------");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackUsingLinkedList stack = new StackUsingLinkedList();
		stack.push(10);
		stack.push(12);
		stack.push(14);
		stack.push(16);
		stack.display();
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
