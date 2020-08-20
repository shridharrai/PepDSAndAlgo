package trees;

import java.util.ArrayList;
import java.util.List;


public class BoundaryTraversal_premium {
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
	List<Integer> list = new ArrayList<Integer>();
	
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		if (root == null) {
			return list;
		}
		
		list.add(root.val);
		boundaryLeft(root.left);
		leaves(root.left);
		leaves(root.right);
		boundaryRight(root.right);
		
		return list;
	}
	
	public void boundaryLeft(TreeNode node) {
		if (node == null) {
			return;
		}
		
		if (node.left != null) {
			/*First process the node and then call the left subtree,
			it is top down manner */
			list.add(node.val);
			boundaryLeft(node.left);
		}
		else if (node.right != null) {
			list.add(node.val);
			boundaryLeft(node.right);
		}
		
		//If it is leave node than do nothing
	}
	
	public void boundaryRight(TreeNode node) {
		if (node == null) {
			return;
		}
		
		if (node.right != null) {
			/*First call for right subtree and then process the node,
			it is bottom up manner */
			boundaryRight(node.right);
			list.add(node.val);
		}
		else if (node.left != null) {
			boundaryRight(node.left);
			list.add(node.val);
		}
		
		//If it is leave node than do nothing
	}
	
	public void leaves(TreeNode node) {
		if (node == null) {
			return;
		}
		
		leaves(node.left);
		if (node.left == null && node.right == null) {
			list.add(node.val);
		}
		leaves(node.right);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node = new TreeNode(20);
		node.left = new TreeNode(8);
		node.right = new TreeNode(22);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(12);
		node.left.right.left = new TreeNode(10);
		node.left.right.right = new TreeNode(14);
		node.right.right = new TreeNode(25);
		BoundaryTraversal_premium tree = new BoundaryTraversal_premium();
		System.out.println(tree.boundaryOfBinaryTree(node));
	}

}
