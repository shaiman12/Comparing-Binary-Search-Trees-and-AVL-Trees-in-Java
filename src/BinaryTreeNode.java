/**
 * 
 * 
 *
 *This class stores a private generic data type that will hold the object that is being stored in the binary search tree. 
 *It also stores the reference variables to the left and right sub-nodes (which are given package access privacy modifier status). 
 *It has a parameterized constructor that stores the necessary information in the instance variables. 
 *It has accessor and mutator methods for references to the left and right sub-trees
 *
 * @author ShaiAarons
 * @author Patrick Marais lecture slides
 * @author Problem Solving and Data Structures Using Java textbook
 * 
 */

public class BinaryTreeNode<dataType> {
	dataType data;
	 BinaryTreeNode<dataType> left;
	 BinaryTreeNode<dataType> right;
	 int height;

	
	
	/**
	 * Constructor for the BinaryTreeNode
	 * @param d the object being stored in the Binary Search Tree
	 * @param l the reference to the object in the left sub tree
	 * @param r the reference to the object in the right sub tree
	 */
	public BinaryTreeNode ( dataType d, BinaryTreeNode<dataType> l,
			BinaryTreeNode<dataType> r )
			 {
			 data = d;
			 left = l;
			 right = r;
			 height = 0;
			 }
/**
 * returns the left sub tree's reference 
 */
	BinaryTreeNode<dataType> getLeft () { 
		return left; 
		}
	
	/**
	 * returns the right sub tree's reference 
	 */
	 BinaryTreeNode<dataType> getRight () { 
		 return right; 
		 }

/**
 * The toString method returns the data item that it is storing’s toString (i.e. it returns data.toString())
 */
	 public String toString() {
			return data.toString();
		}













}//end of class
