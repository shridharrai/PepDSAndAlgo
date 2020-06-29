package linkedlist;

import java.util.HashMap;


public class LRUCache_146 {
	private static Node head;
	private static Node tail;
	private int capacity;
	private HashMap<Integer, Node> map;
	private static class Node {
		int key;
		int val;
		Node next;
		Node prev;
		public Node(int key, int val) {
			// TODO Auto-generated constructor stub
			this.key = key;
			this.val = val;
			this.next = null;
			this.prev = null;
		}
	}
	
    public LRUCache_146(int capacity) {
    	map = new HashMap<Integer, Node>();
    	this.capacity = capacity;
    	head = new Node(-1, -1);
    	tail = new Node(-1, -1);
    	head.next = tail;
    	tail.prev = head;
    }
    
    public void removeNode(Node temp) {
    	Node temp1 = temp.prev;
    	Node temp2 = temp.next;
    	temp1.next = temp2;
    	temp2.prev = temp1;
    	temp.next = null;
    	temp.prev = null;
    }
    
    public void put(int key, int value) {
    	if (map.size() < capacity) {
    		if (map.containsKey(key)) {
				Node n1 = map.get(key);
				removeNode(n1);
			} 
    		Node n1 = new Node(key, value);
        	map.put(key, n1);
        	addNode(n1);
		} else {
			if (map.containsKey(key)) {
				Node n1 = map.get(key);
				removeNode(n1);
			} 
			else {
				Node n = head.next;
				removeNode(n);
				map.remove(n.key);
			}
			Node n = new Node(key, value);
        	map.put(key, n);
        	addNode(n);
		}
    }
    
    public int get(int key) {
    	if (map.containsKey(key)) {
    		Node n = map.get(key);
    		int ans = n.val;
            removeNode(n);
            addNode(n);
            return ans;
		} else {
			return -1;
		}
    }
    public void addNode(Node temp) {
    	Node tail1 = tail.prev;
    	tail1.next = temp;
    	tail.prev = temp;
    	temp.prev = tail1;
    	temp.next = tail;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache_146 cache = new LRUCache_146(2);
//		System.out.println(cache.get(2));
		cache.put(1, 1);
//		System.out.println(cache.get(1));
		cache.put(2, 2);
//		cache.put(2, 3);
//		cache.put(4, 1);
		System.out.println(cache.get(1));
		cache.put(3, 3);
		System.out.println(cache.get(2));
		cache.put(4, 4);
		System.out.println(cache.get(1));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));
	}

}
