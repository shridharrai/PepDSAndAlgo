package trees;


public class InorderSuccessorOfBST_Premium {
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
	//O(h)
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		TreeNode succ = null;
		if (p.right != null) {
			return minValue(p.right);
		} else {
			while (root != null) {
				if (p.val > root.val) {
					root = root.right;
				} else if (p.val < root.val) {
					succ = root;
					root = root.left;
				}
				else {
					//If equal
					break;
				}
			}
		}
		return succ;
	}
	
	private TreeNode minValue(TreeNode node) {
		// TODO Auto-generated method stub
		while (node.left != null) {
			node = node.left;
		}
		return node;
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
		InorderSuccessorOfBST_Premium tree = new InorderSuccessorOfBST_Premium();
		System.out.println(tree.inorderSuccessor(node, node.left.right.right).val);
	}

}
