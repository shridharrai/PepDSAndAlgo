package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal_102 {
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
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (queue.size() != 0) {
			int count = queue.size();
			List<Integer> internalList = new ArrayList<Integer>();
			//For every level
			while (count-- > 0) {
				TreeNode rem = queue.remove();
				internalList.add(rem.val);
				if (rem.left != null) {
					queue.add(rem.left);
				}
				if (rem.right != null) {
					queue.add(rem.right);
				}
			}
			list.add(internalList);
		}
		
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeLevelOrderTraversal_102 tree = new BinaryTreeLevelOrderTraversal_102();
		tree.root = new TreeNode(3);
		tree.root.left = new TreeNode(9);
		tree.root.right = new TreeNode(20);
		tree.root.right.left = new TreeNode(15);
		tree.root.right.right = new TreeNode(7);
		System.out.println(tree.levelOrder(tree.root));
	}

}
