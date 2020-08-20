package trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Pair {
	int level;
	Node node;
	public Pair(int level, Node node) {
		super();
		this.level = level;
		this.node = node;
	}
}

public class BinaryTreeTopSideView_Geeks {
	void topView(Node root) {
		HashMap<Integer, Node> map = new HashMap<Integer, Node>();
		LinkedList<Pair> queue = new LinkedList<>();
		Pair pair = new Pair(0, root);
		queue.add(pair);
//		map.put(0, root);
		while (queue.size() != 0) {
			int count = queue.size();
			//For every level
			while (count > 0) {
				Pair rem = queue.remove();
				if (!map.containsKey(rem.level)) {
					map.put(rem.level, rem.node);
				}
				if (rem.node.left != null) {
					Pair pair2 = new Pair(rem.level-1, rem.node.left);
					queue.add(pair2);
				}
				if (rem.node.right != null) {
					Pair pair2 = new Pair(rem.level+1, rem.node.right);
					queue.add(pair2);
				}
				count--;
			}
		}
		for (Integer key : map.keySet()) {
			System.out.println(key+" "+"->"+" "+map.get(key).data);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node = new Node(1);
		node.left = new Node(2);
		node.right = new Node(3);
		node.left.left = new Node(4);
		node.left.right = new Node(5);
		node.left.left.left = new Node(12);
		node.left.left.right = new Node(13);
		node.right.left = new Node(7);
		node.right.right = new Node(6);
		node.right.right.left = new Node(10);
		node.right.right.right = new Node(11);
		BinaryTreeTopSideView_Geeks tree = new BinaryTreeTopSideView_Geeks();
		tree.topView(node);
	}

}
