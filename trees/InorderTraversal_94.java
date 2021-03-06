package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal_94 {
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
	
	public List<Integer> inorderTraversal(TreeNode root) {
		//With Stack
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		TreeNode curr = root;
//		Stack<TreeNode> stack = new Stack<TreeNode>();
//		while (curr != null || stack.size() > 0) {
//			while (curr != null) {
//				stack.push(curr);
//				curr = curr.left;
//			}
//			curr = stack.pop();
//			list.add(curr.val);
//			curr = curr.right;
//		}
//		return list;
		
		//Without Stack(O(4n))
		ArrayList<Integer> list = new ArrayList<Integer>();
		TreeNode curr = root;
		
		while (curr != null) {
			//If left child is null then process it
			if (curr.left == null) {
				list.add(curr.val);
				curr = curr.right;
			} else {
				TreeNode currp1 = curr.left;
				//Find the rightmost node of currp1
				while (currp1.right != null && currp1.right != curr) {
					currp1 = currp1.right;
				}
				/*If rightmost node is not linked then it means left
				side is not processed so make a chain for backtracking
				and process the left side*/
				if (currp1.right == null) {
					currp1.right = curr;
					curr = curr.left;
				} else {
					/*If rightmost node is already linked then it means
					 * left side is already processed so process this node
					 * and then traverse to the right side*/ 
					currp1.right = null;
					list.add(curr.val);
					curr = curr.right;
				}
			}
		}
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InorderTraversal_94 tree = new InorderTraversal_94();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		System.out.println(tree.inorderTraversal(tree.root));
	}

}
