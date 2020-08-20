package trees;


public class MergeTwoBalancedBST_Geeks {
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
	TreeNode mergedHead;
	
	//O(m+n)
	public TreeNode merging(TreeNode root1, TreeNode root2) {
		TreeNode tail1 = bTreeToCList(root1);
		TreeNode head1 = tail1.right;
		tail1.right = null;
		head1.left = null;
		TreeNode tail2 = bTreeToCList(root2);
		TreeNode head2 = tail2.right;
		head2.left = null;
		tail2.right = null;
		mergedHead = mergeLists(head1, head2);
		return sortedListToBST();
		
	}
	
	//Convert the BST to Circular Doubly Linked list
	private TreeNode bTreeToCList(TreeNode root) {
		if (root == null) {
			return null;
		}
		
		TreeNode lefttail = bTreeToCList(root.left);
		TreeNode righttail = bTreeToCList(root.right);
		root.right = root.left = root;
		if (lefttail == null && righttail == null) {
			return root;
		} else if (lefttail == null) {
			return concatenate(root, righttail);
		} else if (righttail == null) {
			return concatenate(lefttail, root);
		} else {
			TreeNode node = concatenate(lefttail, root);
			return concatenate(node, righttail);
		}
	}
		
	public TreeNode concatenate(TreeNode lefttail, TreeNode righttail) {
		TreeNode lefthead = lefttail.right;
		TreeNode righthead = righttail.right;
		lefttail.right = righthead;
		righthead.left = lefttail;
		lefthead.left = righttail;
		righttail.right = lefthead;
		return righttail;
	}
	
	//merge the two given lists
	private TreeNode mergeLists(TreeNode headA, TreeNode headB) {
		if (headA == null) {
			return headB;
		}
		if (headB == null) {
			return headA;
		}
		if (headA.val < headB.val) {
			headA.right = mergeLists(headA.right, headB);
			return headA;
		} else {
			headB.right = mergeLists(headA, headB.right);
			return headB;
		}
	}
	
	//Construct BST from sorted merged list
	public TreeNode sortedListToBST() {
		int n = countNodes(mergedHead);
		return BSTConstruct(n);
	}
	
	private TreeNode BSTConstruct(int n) {
		// TODO Auto-generated method stub
		if (n == 0) {
			return null;
		}
		TreeNode left = BSTConstruct(n/2);
		TreeNode root = mergedHead;
		root.left = left;
		mergedHead = mergedHead.right;
		root.right = BSTConstruct(n-n/2-1);
		return root;
	}

	private int countNodes(TreeNode head) {
		// TODO Auto-generated method stub
		int count = 0;
		TreeNode temp = head;
		while (temp != null) {
			temp = temp.right;
			count++;
		}
		return count;
	}
	
	void inorder() 
    { 
        inorderUtil(this.root); 
    } 
      
void inorderUtil(TreeNode node) 
{ 
    if(node==null) 
        return; 
          
    inorderUtil(node.left); 
    System.out.print(node.val + " "); 
    inorderUtil(node.right); 
} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeTwoBalancedBST_Geeks tree1 = new MergeTwoBalancedBST_Geeks();
		tree1.root = new TreeNode(100);
		tree1.root.left = new TreeNode(50);
		tree1.root.right = new TreeNode(300);
		tree1.root.left.left = new TreeNode(20);
		tree1.root.left.right = new TreeNode(70);
		MergeTwoBalancedBST_Geeks tree2 = new MergeTwoBalancedBST_Geeks();
		tree2.root = new TreeNode(80);
		tree2.root.left = new TreeNode(40);
		tree2.root.right = new TreeNode(120);
//		System.out.println(tree1.merging(tree1.root, tree2.root).val);
		tree1.root = tree1.merging(tree1.root, tree2.root);
		tree1.inorder();
	}

}
