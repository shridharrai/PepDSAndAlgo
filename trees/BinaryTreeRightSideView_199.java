package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class BinaryTreeRightSideView_199 {
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
	
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (queue.size() != 0) {
			int count = queue.size();
			//For every level
			while (count > 0) {
				TreeNode rem = queue.remove();
				if (rem.left != null) {
					queue.add(rem.left);
				}
				if (rem.right != null) {
					queue.add(rem.right);
				}
				if (count == 1) {
					list.add(rem.val);
				}
				count--;
			}
		}
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeRightSideView_199 tree = new BinaryTreeRightSideView_199();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.right.right = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		System.out.println(tree.rightSideView(tree.root));
	}

}
