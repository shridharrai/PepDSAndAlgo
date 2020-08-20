package trees;

import java.util.Scanner;

public class ImageMultiplication_Geeks {
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
	int product = 0;
	//O(n)
	public int product(TreeNode root) {
		product = product + root.val*root.val;
		helper(root.left, root.right);
		return product;
	}
	private void helper(TreeNode root1, TreeNode root2) {
		// TODO Auto-generated method stub
		if (root1 == null || root2 == null) {
			return;
		}
		product = product + root1.val*root2.val;
		helper(root1.left, root2.right);
		helper(root1.right, root2.left);
	}
	
	private void constructTree(TreeNode root, int a, int b, char ch) {
		if (root == null) {
			return;
		}
		if (root.val == a) {
			if (ch == 'L') {
				root.left = new TreeNode(b);
			} else {
				root.right = new TreeNode(b);
			}
		} else {
			constructTree(root.left, a, b, ch);
			constructTree(root.right, a, b, ch);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImageMultiplication_Geeks tree = new ImageMultiplication_Geeks();
//		tree.root = new TreeNode(1);
//		tree.root.left = new TreeNode(3);
//		tree.root.right = new TreeNode(2);
//		tree.root.left.left = new TreeNode(7);
//		tree.root.left.right = new TreeNode(6);
//		tree.root.right.left = new TreeNode(5);
//		tree.root.right.right = new TreeNode(4);
//		tree.root.left.left.left = new TreeNode(11);
//		tree.root.left.left.right = new TreeNode(10);
//		tree.root.left.right.right = new TreeNode(15);
//		tree.root.right.left.left = new TreeNode(9);
//		tree.root.right.left.right = new TreeNode(8);
//		tree.root.right.right.right = new TreeNode(12);
//		System.out.println(tree.product(tree.root));
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t-- > 0) {
			int n = scn.nextInt();
			TreeNode root = null;
			for (int i = 0; i < n; i++) {
				int a = scn.nextInt();
				int b= scn.nextInt();
				char ch = scn.next().charAt(0);
				if (root == null) {
					root = new TreeNode(a);
					if (ch == 'L') {
						root.left = new TreeNode(b);
					} else {
						root.right = new TreeNode(b);
					}
				} else {
					tree.constructTree(root, a, b, ch);
				}
			}
			System.out.println(tree.product(root));
		}
	}

}
