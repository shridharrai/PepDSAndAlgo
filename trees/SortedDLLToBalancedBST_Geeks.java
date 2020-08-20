package trees;


public class SortedDLLToBalancedBST_Geeks {
	TreeNode root;
	private static class TreeNode {
		      int val;
		      TreeNode prev;
		      TreeNode next;
		      TreeNode(int val) {
		          this.val = val;
		          this.prev = null;
		          this.next = null;
		      }
		  }
	TreeNode head;
	//O(n)
	public TreeNode sortedListToBST() {
		int n = countNodes(head);
		return BSTConstruct(n);
	}
	
	private TreeNode BSTConstruct(int n) {
		// TODO Auto-generated method stub
		if (n == 0) {
			return null;
		}
		TreeNode left = BSTConstruct(n/2);
		TreeNode root = head;
		root.prev = left;
		head = head.next;
		root.next = BSTConstruct(n-n/2-1);
		return root;
	}

	private int countNodes(TreeNode head) {
		// TODO Auto-generated method stub
		int count = 0;
		TreeNode temp = head;
		while (temp != null) {
			temp = temp.next;
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
