package trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;


public class AllNodesDistanceKInBinaryTree_863 {
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
	private HashMap<TreeNode, TreeNode> map = new HashMap<>();
	
	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		preOrder(root, null);
		for (TreeNode key : map.keySet()) {
			if (map.get(key) != null) {
				System.out.println(key.val + " "+ map.get(key).val);	
			} else {
				System.out.println(key.val + " "+ "null");
			}
		}
		LinkedList<TreeNode> queue = levelOrder(target, K);
		List<Integer> list = new ArrayList<Integer>();
		for(TreeNode node : queue) {
			list.add(node.val);
		}
		return list;
	}
	
	private void preOrder(TreeNode node, TreeNode parent) {
		if (node == null) {
			return;
		}
		map.put(node, parent);
		preOrder(node.left, node);
		preOrder(node.right, node);
	}
	
	public LinkedList<TreeNode> levelOrder(TreeNode root, int K) {
		LinkedList<TreeNode> queue = new LinkedList<>();
		HashSet<TreeNode> visited = new HashSet<>();
		queue.add(root);
		visited.add(root);
		int level = 0;
		while (level != K && queue.size() != 0) {
			int count = queue.size();
			//For every level
			while (count-- > 0) {
				TreeNode rem = queue.remove();
				if (rem.left != null) {
					if (!visited.contains(rem.left)) {
						queue.add(rem.left);
						visited.add(rem.left);
					}
				}
				if (rem.right != null) {
					if (!visited.contains(rem.right)) {
						queue.add(rem.right);
						visited.add(rem.right);
					}
				}
				if (map.get(rem) != null) {
					if (!visited.contains(map.get(rem))) {
						queue.add(map.get(rem));
						visited.add(map.get(rem));
					}
				}
			}
			level++;
		}
		return queue;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AllNodesDistanceKInBinaryTree_863 tree = new AllNodesDistanceKInBinaryTree_863();
		tree.root = new TreeNode(3);
		tree.root.left = new TreeNode(5);
		tree.root.right = new TreeNode(1);
		tree.root.left.left = new TreeNode(6);
		tree.root.left.right = new TreeNode(2);
		tree.root.right.left = new TreeNode(0);
		tree.root.right.right = new TreeNode(8);
//		tree.root.left.left.left = new TreeNode(8);
//		tree.root.left.left.left.left = new TreeNode(9);
		tree.root.left.right.left = new TreeNode(7);
//		tree.root.left.right.left.left = new TreeNode(10);
//		tree.root.left.right.left.right = new TreeNode(12);
		tree.root.left.right.right = new TreeNode(4);
//		tree.root.left.right.right.right = new TreeNode(13);
		System.out.println(tree.distanceK(tree.root, tree.root.left, 2));
	}

}
