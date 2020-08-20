package trees;

import java.util.Stack;

public class BSTFromPostOrder_GFG {
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
	
	private static class Helper {
		TreeNode node;
		int min;
		int max;
		boolean isleft;
		public Helper(TreeNode node, int min, int max, boolean isleft) {
			super();
			this.node = node;
			this.min = min;
			this.max = max;
			this.isleft = isleft;
		}
	}
	private static Stack<Helper> stack = new Stack<>();
	
	//O(n)
	public static TreeNode constructTree(int post[],int n) {
		TreeNode root = new TreeNode(post[n-1]);
		Helper left = new Helper(root, Integer.MIN_VALUE, root.val-1, true);
		stack.add(left);
		Helper right = new Helper(root, root.val+1, Integer.MAX_VALUE, false);
		stack.add(right);
		int i = n-2;
		
		while (i >= 0) {
			Helper helper = stack.pop();
			if (post[i]<helper.min || post[i]>helper.max) {
				continue;
			} else {
				TreeNode node = new TreeNode(post[i]);
				if (helper.isleft) {
					helper.node.left = node;
				} else {
					helper.node.right = node;
				}
				Helper leftchild = new Helper(node, helper.min, node.val-1, true);
				stack.add(leftchild);
				Helper rightchild = new Helper(node, node.val+1, helper.max, false);
				stack.add(rightchild);
			}
			i--;
		}
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTFromPostOrder_GFG tree = new BSTFromPostOrder_GFG();
		int[] postorder = {1,7,5,30,50,40,10};
		int n = postorder.length;
		TreeNode root = BSTFromPostOrder_GFG.constructTree(postorder, n);
		System.out.println(root.val);
		System.out.println(root.left.val);
		System.out.println(root.right.val);
		System.out.println(root.left.left.val);
		System.out.println(root.left.right.val);
		System.out.println(root.right.left.val);
		System.out.println(root.right.right.val);
	}

}
