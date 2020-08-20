package trees;


public class LowestCommonAncestorOfBST_235 {
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
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while (root != null) {
			if (root.val < p.val && root.val < q.val) {
				root = root.right;
			} else if (root.val > p.val && root.val > q.val) {
				root = root.left;
			} else {
				break;
			}
		}
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node = new TreeNode(6);
		node.left = new TreeNode(2);
		node.right = new TreeNode(8);
		node.left.left = new TreeNode(0);
		node.left.right = new TreeNode(4);
		node.left.right.left = new TreeNode(3);
		node.left.right.right = new TreeNode(5);
		node.right.left = new TreeNode(7);
		node.right.right = new TreeNode(9);
		TreeNode p = node.left;
		TreeNode q = node.left.right;
		LowestCommonAncestorOfBST_235 tree = new LowestCommonAncestorOfBST_235();
		System.out.println(tree.lowestCommonAncestor(node, p, q).val);
	}

}
