package trees;


public class DeleteNodeInBST_450 {
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
	
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (root.val == key) {
			root = removeNode(root);
		} else if (root.val > key) {
			root.left = deleteNode(root.left, key);
		} else {
			root.right = deleteNode(root.right, key);
		}
		return root;
	}
	
	public TreeNode removeNode(TreeNode root) {
		if (root.left == null && root.right == null) {
			return null;
		} else if (root.left == null && root.right != null) {
			return root.right;
		} else if (root.left != null && root.right == null) {
			return root.left;
		} else {
			TreeNode rootp1 = root.right;
			while (rootp1.left != null) {
				rootp1 = rootp1.left;
			}
			rootp1.left = root.left;
			return root.right;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
