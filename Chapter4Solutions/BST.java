import java.util.ArrayList;
import java.util.LinkedList;

public class BST {
	
	TreeNode root;
	
	public BST(){
		this.root = null;
	}
	
	public static TreeNode arrayToBST(int[] ar, int beg, int end){
		if (beg > end) return null;
		int mid = (beg + end)/ 2;
		TreeNode tn = new TreeNode(ar[mid]);
		
		tn.left = arrayToBST(ar, beg, mid - 1);
		tn.right = arrayToBST(ar, mid + 1, end);
		return tn;
	}
	
 	public ArrayList<LinkedList<TreeNode>> lotToArrayOfLists(){
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		if (this.root != null){
			current.add(this.root);
		}
		while (current.size() > 0){
			result.add(current);
			LinkedList<TreeNode> parents = new LinkedList<TreeNode>();
			current = new LinkedList<TreeNode>();
			for (TreeNode node : parents){
				if (node.left != null) current.add(node.left);
				if (node.right != null) current.add(node.right);
			}
		}
		return result;	
	}
	
	/* A balanced tree is one that the height of the left and right subtree
	* differs by no more than 1 */
	public static int getHeight(TreeNode n){
		int leftHeight = getHeight(n.left);
		int rightHeight = getHeight(n.right);
		if (leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		if (rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;

		int diff = leftHeight - rightHeight;
		if (Math.abs(diff) > 1){
			return Integer.MIN_VALUE;
		} else {
			return Math.max(getHeight(n.left), getHeight(n.right)) + 1;
		}
	}

	public boolean isBalanced(TreeNode n){
		return (getHeight(n) != Integer.MIN_VALUE);
	}

	public boolean isComplete(TreeNode n){
		//level order traversal that has a flag/check to see if this is a node
		//with both children.
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		boolean signal = false;
		q.add(n);
		while(!q.isEmpty()){
			TreeNode cur = q.removeFirst();
			System.out.print(cur.data + " ");
			if (cur.left != null){
				q.add(cur.left);
				if (signal == true) return false;
			} else {
				signal = true;
			}
			if (cur.right != null){
				q.add(cur.right);
				if (signal == true) return false;
			}
			else {
				signal = true;
			}
		}
		return true;
	}

	public static boolean isFull(TreeNode n){
		if (n.left == null && n.right == null) return true;
		else if (n.left != null && n.right != null) {
			return (isFull(n.left) && isFull(n.right));
		}
		return false;
	}
	
	public int findSuccessor(TreeNode n){
		//Case 1, node has a right subtree
		if (n.right != null){
			TreeNode temp = n.right;
			TreeNode successor = TreeNode.leftmostInRightTree(n);
			return successor.data;
		} else {
			TreeNode successor = n.parent;
			TreeNode temp = n;
			// traverse up the tree until an ancestor is found on the
			// right side of a tree
			while (successor != null & successor.left != n){
				temp = successor;
				successor = successor.parent;
			}
			return successor.data;
		}
	}
	
	public TreeNode findMin(TreeNode n){
		if (n == null) return null;
		while (n != null){
			n = n.left;
		}
		return n;
	}
	
	public void insert(int n){
		TreeNode newLeaf = new TreeNode(n);
		if (this.root == null){
			this.root = newLeaf;
			return;
		}
		if (this.find(n)) return;
		
		TreeNode i = this.root;
		TreeNode parent = null;
		
		while (i != null){
			parent = i;
			if (i.data >= n){
				i = i.left;
				if (i == null){
					parent.left = newLeaf;
					return;
				}
			} else {
				i = i.right;
				if (i == null){
					parent.right = newLeaf;
					return;
				}
			}
		}			
	}

	public int findCommonAncestor(TreeNode a, TreeNode b){
		TreeNode deeper = (getDepth(a) > getDepth(b) ? a : b);
		TreeNode shallower = (getDepth(a) < getDepth(b) ? a : b);
		int depthDiff = Math.abs(getDepth(a) - getDepth(b));
		for (int i = 0; i < depthDiff; i++){
			deeper = deeper.parent;
		}

		while(deeper.parent != shallower.parent & deeper.parent != null){
			deeper = deeper.parent;
			shallower = shallower.parent;
		}

		return deeper.parent.data;
	}

	public int getDepth(TreeNode n){
		int count = 0;
		while (n != this.root){
			n = n.parent;
			count++;
		}
		return count;
	}
	
	public boolean find(int n){
		TreeNode i = this.root;
		while (i != null){
			if(i.data == n) return true;
			else if(i.data > n) i = i.left;
			else i = i.right;
		}
		return false;
	}
	
//	public void delete(int n){
//		//Three cases: no TreeNodes, 1 TreeNode, 2 TreeNode
//	}
	
	//Same as a breadth level search
	public void levelOrderTraversal(TreeNode n){
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		q.add(n);
		while(!q.isEmpty()){
			TreeNode cur = q.removeFirst();
			System.out.print(cur.data + " ");
			if (cur.left != null) q.add(cur.left);
			if (cur.right != null) q.add(cur.right);
		}
	}
	
	public void preOrderTraversal(TreeNode n){
		if (n!=null){
			System.out.print(n.data + " ");
			preOrderTraversal(n.left);
			preOrderTraversal(n.right);	
		}
	}
	
	public void postOrderTraversal(TreeNode n){
		if (n!=null){
			postOrderTraversal(n.left);
			postOrderTraversal(n.right);
			System.out.print(n.data + " ");
		}
	}
	
	public void inOrderTraversal(TreeNode n){
		if (n != null){
			inOrderTraversal(n.left);
			System.out.print(n.data + " ");
			inOrderTraversal(n.right);
		}
	}

	// public ArrayList<LinkedList<Integer>> allPossibleInputs(TreeNode n){
	// 	ArrayList<LinkedList> result = new ArrayList<LinkedList>();
	// 	LinkedList<Integer> prefix = new LinkedList<Integer>();
	// 	prefix.add(n);

	// 	leftSubtree = allPossibleInputs(n.left);
	// 	rightSubtree = allPossibleInputs(n.right);

	// 	for (LinkedList<Integer> left : leftSubtree){
	// 		for (LinkedList<Integer> right : rightSubtree){
	// 			ArrayList<LinkedList<Integer>> completeWeave = 
	// 				new ArrayList<LinkedList<Integer>>();
	// 			weave(left, right, completeWeave, prefix);
	// 			result.add(weave);
	// 		}
	// 	}
	// 	return result;
	// }

	// public void weave(TreeNode l, TreeNode r, ArrayList<LinkedList<Integer>> storage, TreeNode prefix){
		
	// }
}
