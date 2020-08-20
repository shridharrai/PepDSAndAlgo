package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;



public class VerticalOrderTraversal_987 {
	TreeNode root;
	private static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int val) {
		          this.val = val;
		          this.left = null;
		          this.right = null;
		      }
		  }
	
	private static class Pair implements Comparable<Pair> {
		int level;
		TreeNode node;
		public Pair(int level, TreeNode node) {
			super();
			this.level = level;
			this.node = node;
		}
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.node.val - o.node.val;
		}
	}
	
	public List<List<Integer>> verticalTraversal(TreeNode root) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		Pair pair = new Pair(0, root);
		queue.add(pair);
		while (queue.size() != 0) {
			int count = queue.size();
			Collections.sort(queue);
			//For every level
			while (count > 0) {
				Pair rem = queue.remove();
				if (map.containsKey(rem.level)) {
					ArrayList<Integer> list = map.get(rem.level);
					list.add(rem.node.val);
					map.put(rem.level, list);
				} else {
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(rem.node.val);
					map.put(rem.level, list);
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

		int max = Integer.MIN_VALUE;
		int min = 0;
		for (Integer key : map.keySet()) {
			max = Math.max(max, key);
			min = Math.min(min, key);
		}

		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (int i = min; i <= max; i++) {
			ArrayList<Integer> internallist = map.get(i);
			list.add(internallist);
		}
		return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(7);
		node.left.left.left = new TreeNode(12);
		node.left.left.right = new TreeNode(13);
		node.right.left = new TreeNode(5);
		node.right.right = new TreeNode(6);
		node.right.right.left = new TreeNode(10);
		node.right.right.right = new TreeNode(11);
		VerticalOrderTraversal_987 tree = new VerticalOrderTraversal_987();
		System.out.println(tree.verticalTraversal(node));
	}

}
