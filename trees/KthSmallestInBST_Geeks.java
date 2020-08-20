package trees;


public class KthSmallestInBST_Geeks {
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
	
	public int KthSmallestUsingMorris(TreeNode root, int k) {
		int count = 0;
		int ksmall = Integer.MIN_VALUE;
        TreeNode curr = root;
		
		while (curr != null) {
			//If left child is null then process it
			if (curr.left == null) {
				count++;
				if (count == k) {
					ksmall = curr.val;
					break;
				}
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
					count++;
					if (count == k) {
						ksmall = curr.val;
						break;
					}
					curr = curr.right;
				}
			}
		}
		return ksmall;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KthSmallestInBST_Geeks tree = new KthSmallestInBST_Geeks();
		tree.root = new TreeNode(20);
		tree.root.left = new TreeNode(8);
		tree.root.right = new TreeNode(22);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(12);
		tree.root.left.right.left = new TreeNode(10);
		tree.root.left.right.right = new TreeNode(14);
		System.out.println(tree.KthSmallestUsingMorris(tree.root, 3));
	}

}
