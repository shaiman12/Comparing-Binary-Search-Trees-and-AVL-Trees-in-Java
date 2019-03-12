/*
 * 
 * 
 * This class serves as the typical binary search tree class. 
 * It has a private instance variable of type BinaryTreeNode<dataType> that stores the root node of the binary search tree data structure.
 * It also has an integer instance variable called opCount, which stores the amount of comparison operations that occurs when a search is invoked from the PowerBSTApp
 * @author ShaiAarons
 * @author Patrick Marais lecture slides
 * @author Problem Solving and Data Structures Using Java textbook
 */
public class BinarySearchTree<dataType> {
	private BinaryTreeNode<dataType> root;
	public int opCount;
	public int opCountInsert;

	/**
	 * It has a constructor, which simply sets the root node to null, and the opCount to zero
	 */
	 public BinarySearchTree ()
	 {
	 root = null;
	 opCount = 0;
	 opCountInsert = 0;
	 }

	 /**
	  * Returns the hight of the binary search tree
	  */
	 public int getHeight ( BinaryTreeNode<dataType> node )
	 {
	 if (node == null)
	 return -1;
	 else {
	 return 1 + Math.max (getHeight (node.getLeft ()),getHeight (node.getRight ()));
	 }
	 } 
	 
	 /**
	  * non-recursive method that returns the size of the binary search tree by calling the recursive method getSize
	  */
	 public int getSize ()
	 {
	 return getSize (root);
	 } 
	 
	 /**
	  * returns the size of the binary search true by using a recursive algorithm
	  */
	 public int getSize ( BinaryTreeNode<dataType> node )
	 {
	 if (node == null)
	 return 0;
	 else
	 return 1 + getSize (node.getLeft ()) +
	 getSize (node.getRight ());
	 }
	 
	 /**
	  * This method receives a node in the binary search tree and returns a substring of the first 19 letters of the toString of the node. 
	  * The reason that substring is used is so that in traversals of the tree, only the date/time is displayed – as is required by the printAllDateTimes method in the PowerBSTApp and for comparison operations used in searching (so that it is in the form: dd/mm/yyyy/hh/mm/ss). 
	  */
	 public void visit ( BinaryTreeNode<dataType> node )
	 {
	 System.out.println (node.toString().substring(0, 19));
	 }
	 
	 
	 /**
	  * non-recursive method that calls the recursive inOrder method to traverse through the binary search tree
	  */
	 public void inOrder ()
	 {
	 inOrder (root);
	 }
	 
	 /**
	  * Recursively traverses through the binary search tree in such a way that the output is displayed in order of the defined key
	  */
	 public void inOrder ( BinaryTreeNode<dataType> node )
	 {
	 if (node != null)
	 {
	 inOrder (node.getLeft ());
	 visit (node);
	 inOrder (node.getRight ());
	 }
	 }
	 
	 /**
	  * Non-recursive insert method ensures that the data object attempting to be added to the tree is not null
	  * and if it is not null it calls the recursive insert method
	  */
	 public void insert ( dataType d )
	 {
	 if (root == null)
	 root = new BinaryTreeNode<dataType> (d, null, null);
	 else
	 insert (d, root);
	 }
	 
	 
	 /**
	  * Inserts a new node into the binary search tree by means of recursion
	  */
	 public void insert ( dataType d, BinaryTreeNode<dataType> node ){
		 opCountInsert = 0;
		 opCountInsert++;
	if (d.toString().compareTo (node.toString()) <= 0){
		 if (node.left == null) {
			opCountInsert++;
			 node.left = new BinaryTreeNode<dataType> (d, null, null);}
		else {
			opCountInsert++;
			insert (d, node.left);}
	 	}
	 else {
	 if (node.right == null) {
		 opCountInsert++;
		 node.right = new BinaryTreeNode<dataType> (d, null, null);}
	 else {
		 opCountInsert++;
		 insert (d, node.right);}
	 }
	 }
	 /**
	  * 
	  *  
	  * non-recursive find method calls the recursive find method to find the specified string
	  * ensures that it is not null.
	  * @param d recieves a search term in the form of a string
	  */
	 
	 
	 
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
	 if (d.toString().compareTo (node.toString().substring(0, 19)) == 0) {
		 opCount++;
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
	 
}//end of class
