package trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class DIagonalTraversal_Geeks {
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
	
	private static class Pair {
		int level;
		TreeNode node;
		public Pair(int level, TreeNode node) {
			super();
			this.level = level;
			this.node = node;
		}
	}
	
	public List<List<Integer>> diagonalTraversal(TreeNode root) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		Pair pair = new Pair(0, root);
		queue.add(pair);
		while (queue.size() != 0) {
			int count = queue.size();
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
					Pair pair2 = new Pair(rem.level, rem.node.right);
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
		for (int i = max; i >= min; i--) {
			ArrayList<Integer> internallist = map.get(i);
			list.add(internallist);
		}
		return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node = new TreeNode(8);
		node.left = new TreeNode(3);
		node.right = new TreeNode(10);
		node.left.left = new TreeNode(1);
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(11);
		node.right.left.left = new TreeNode(4);
		node.right.left.right = new TreeNode(7);
		DIagonalTraversal_Geeks tree = new DIagonalTraversal_Geeks();
		System.out.println(tree.diagonalTraversal(node));
	}

}
