/**
 * 
 */
package project7;

/**
 * @author PC
 *
 */
public interface INode {
	/**
	 * This method checks to see if a node with the parentID exists in the tree. If
	 * not, it returns false after printing an appropriate message. If the node
	 * exists, the method checks to see if it already has two children. If it does,
	 * the method returns false. Otherwise, it either adds the new node as the
	 * parent node’s left child (if the parent has no children) or as the right
	 * child (if the parent already has one child). A recursive approach is used.
	 *
	 * @param ID       The ID of the new node to be added to the tree.
	 * @param parentID The ID of the parent of the new node.
	 * @return true if new node was added successfully, false otherwise.
	 */
	public boolean addChild(String ID, String parentID);

	/**
	 * This method looks within the tree to find if “value” (the ID of the node to
	 * be found) is contained in that subtree. As the search progresses down the
	 * tree different nodes will be calling find().
	 *
	 * @param value a string (ID of a node) to be found in the tree
	 * @return the node, if found; null othrewise.
	 */

	public INode find(String value);

	/**
	 * Returns the parent of this node.
	 *
	 * @return the parent of this node.
	 */
	public INode getParent();

	/**
	 * Returns the size of the tree or subtree whose root calls this method.
	 *
	 * @return the size of the tree (or subtree) starting from this node all the way
	 *         down to the leaf nodes.
	 */
	public int size(); //

	/**
	 * Returns a string with the IDs of this node and its immediate children (if
	 * any) all on one line.
	 *
	 * @return a string with the IDs of this node and its immediate children (if
	 *         any).
	 */
	public String toString();

	/**
	 * Returns the ID of this node.
	 *
	 * @return the String ID of this node.
	 */
	public String getId();

	/**
	 * Uses recursion (and the toString() method) to print (on a line) each node's
	 * ID and those of any children it has.
	 */
	public void printTree(); //
}
