package linkedlist;

public class ReverseLinkedList_206 {
	private static Node head;
	private static class Node {
		int val;
		Node next;
		public Node(int data) {
			// TODO Auto-generated constructor stub
			val = data;
			next = null;
		}
	}
	
	private Node reverse(Node head) {
		Node prev = null;
		Node curr = head;
		Node temp = null;
		
		while (curr != null) {
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		head = prev;
		return head;
	}
	
	private void display(Node node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseLinkedList_206 list = new ReverseLinkedList_206();
		list.head = new Node(2);
		list.head.next = new Node(3);
		list.head.next.next = new Node(4);
		list.head.next.next.next = new Node(5);
		list.display(head);
		head = list.reverse(head);
		list.display(head);
	}

}
