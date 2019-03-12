import java.util.LinkedList;
import java.util.Queue;





public class AVLTree<dataType> {
	
	private BinaryTreeNode<dataType> root;
	public int opCount;
	public int opCountInsert;

	
	 public AVLTree()
	 {
	 root = null;
	 opCount = 0;
	 opCountInsert = 0;
	 }

	 
	 public int height ( BinaryTreeNode<dataType> node )
	 {
	 if (node != null)
		 return node.height;
	 return -1;
	 }
	 
	 public int balanceFactor ( BinaryTreeNode<dataType> node )
	 {
	 return height (node.right) - height (node.left);
	 }
	 
	 public void fixHeight ( BinaryTreeNode<dataType> node )
	 {
	 node.height = Math.max (height (node.left),
	 height (node.right)) + 1;
	 }

	 
	 public void visit ( BinaryTreeNode<dataType> node )
	 {
	 System.out.println (node.toString().substring(0, 19));
	 }
	 
	 
	 
	 public void inOrder ()
	 {
	 inOrder (root);
	 }
	 
	 
	 public void inOrder ( BinaryTreeNode<dataType> node )
	 {
	 if (node != null)
	 {
	 inOrder (node.getLeft ());
	 visit (node);
	 inOrder (node.getRight ());
	 }
	 }
	 
	 
	 public BinaryTreeNode<dataType> rotateRight
	 ( BinaryTreeNode<dataType> p )
	  {
	  BinaryTreeNode<dataType> q = p.left;
	  p.left = q.right;
	  q.right = p;
	  fixHeight (p);
	  fixHeight (q);
	  return q;
	  }
	 
	 
	 public BinaryTreeNode<dataType> rotateLeft
	 ( BinaryTreeNode<dataType> q )
	  {
	  BinaryTreeNode<dataType> p = q.right;
	  q.right = p.left;
	  p.left = q;
	  fixHeight (q);
	  fixHeight (p);
	  return p;
	  }
	 
	
	 public BinaryTreeNode<dataType> balance ( BinaryTreeNode<dataType> p )
	 {
	 fixHeight (p);
	 opCountInsert++;
	 if (balanceFactor (p) == 2)
	 {
		 opCountInsert++;
	 if (balanceFactor (p.right) < 0)
	 p.right = rotateRight (p.right);
	 return rotateLeft (p);
	 }
	 opCountInsert++;
	 if (balanceFactor (p) == -2)
	 {
		 opCountInsert++;
	 if (balanceFactor (p.left) > 0)
	 p.left = rotateLeft (p.left);
	 return rotateRight (p);
	 }
	 return p;
	 }
	 
	 
	 
	 
	 
	 
	 
	 public void insert ( dataType d )
	 {
	 root = insert (d, root);
	 }
	 
	 
	 public BinaryTreeNode<dataType> insert ( dataType d, BinaryTreeNode<dataType> node )
	 {
		 opCountInsert = 0;
		 opCountInsert++;
	 if (node == null) {
		 return new BinaryTreeNode<dataType> (d, null, null);}
	 if (d.toString().compareTo (node.toString().substring(0, 19)) <= 0) {
		 opCountInsert++;
		 node.left = insert (d, node.left);
	 }
	 else {
		 opCountInsert++;
		 node.right = insert (d, node.right);}
	 
	 return balance (node);
	 
	 }
	 
	 
	 
	 
	 public String find ( String d )
	 {
	 if (root == null)
	 return null;
	 else
	 return find (d, root);
	 }
	 /**
	  * 
	  * 
	  * The find method here receives a string that in this practical will be a specific date/time that is being searched for. 
	  * It also uses a substring of the first 19 letters of the node (that is passed as an argument to the method) to compare to the search term. 
	  * The find method also updates the opCount instance variable every time a comparison operation is completed. 
	  * @param d search term being looked for 
	  * @param node node in the binary search tree
	  */
	 public String find ( String d, BinaryTreeNode<dataType> node )
	 {
		 opCount++;
	 if (d.toString().compareTo (node.toString().substring(0, 19)) == 0) {
		 return node.toString();}
	 else if (d.toString().compareTo (node.toString().substring(0, 19)) < 0) {
		 opCount++;
	 return (node.left == null) ? null : find (d, node.left);}
	 else {
		 opCount++;
	 return (node.right == null) ? null : find (d, node.right);}
	 }

	public int getOpCount() {
		return opCount;
	}
	
	public void clear() {
		root = null;
	}
	 
}