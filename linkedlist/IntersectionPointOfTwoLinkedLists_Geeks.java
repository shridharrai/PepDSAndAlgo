package linkedlist;

public class IntersectionPointOfTwoLinkedLists_Geeks {
	private static Node head1;
	private static Node head2;
	private static class Node {
		int val;
		Node next;
		public Node(int data) {
			// TODO Auto-generated constructor stub
			val = data;
			next = null;
		}
	}
	
	public int getNode() {
		int c1 = getCount(head1);
		int c2 = getCount(head2);
		int d = Math.abs(c1-c2);
		if (c1 > c2) {
			return getIntersection(d, head1, head2);
		} else {
			return getIntersection(d, head2, head1);
		}
	}
	
	public int getCount(Node node) {
		int count = 0;
		while (node != null) {
			node = node.next;
			count++;
		}
		return count;
	}
	
	public int getIntersection(int d, Node node1, Node node2) {
		for (int i = 0; i < d; i++) {
			node1 = node1.next;
		}
		while (node1 != null && node2 != null) {
			if (node1.val == node2.val) {
				return node1.val;
			}
			node1 = node1.next;
			node2 = node2.next;
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntersectionPointOfTwoLinkedLists_Geeks list = new IntersectionPointOfTwoLinkedLists_Geeks();
		list.head1 = new Node(3);
		list.head1.next = new Node(6);
		list.head1.next.next = new Node(9);
		list.head1.next.next.next = new Node(15);
		list.head1.next.next.next.next = new Node(30);
		
		list.head2 = new Node(10);
		list.head2.next = new Node(15);
		list.head2.next.next = new Node(30);
		System.out.println(list.getNode());
		
	}

}
