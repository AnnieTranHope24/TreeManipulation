package project7;

/**
 * This is the Node class. Each Node has an ID and might have a parent and
 * children.
 * 
 * @author PC
 *
 */
public class Node implements INode {
	private String nodeID;
	private INode[] children;
	private INode parent;
	private int numChild;

	/**
	 * The constructor of Node
	 * 
	 * @param ID the id of the node
	 */
	public Node(String ID) {
		// Used to create the root node (which has no parent)
		parent = null;
		nodeID = ID;
		children = new Node[2];
		numChild = 0;
	}

	/**
	 * The constructor of Node
	 * 
	 * @param newNodeID the id of the node
	 * @param parent    the parent fo the node
	 */
	// Used to create all other nodes.
	public Node(String newNodeID, Node parent) {
		this.parent = parent;
		nodeID = newNodeID;
		children = new Node[2];
		numChild = 0;

	}

	/**
	 * Prints the whole tree.
	 */
	@Override
	public void printTree() {
		// TODO Auto-generated method stub

		System.out.println(toString());
		for (int i = 0; i < children.length; i++) {
			if (children[i] != null) {
				children[i].printTree();
			}
		}

	}

	/**
	 * Adds a new child to the tree.
	 * 
	 * @param ID       the id of the node added
	 * @param parentID the id of the parent that the user wants to add the node to
	 * @return true if node can be added, false if cannot
	 */
	@Override
	public boolean addChild(String ID, String parentID) {
		// TODO Auto-generated method stub
		Node myParent = (Node) this.find(parentID);
		Node myChild = (Node) this.find(ID);
		if (myParent == null) {
			System.out.println("Node " + parentID + " does not exist.");
			return false;
		}
		else {
			if (this.nodeID.equals(parentID)) {
				if (myParent.getNumChild() == 2) {
					System.out.println("Node " + parentID + " is full!");
					return false;
				} else if (myParent.getNumChild() == 1) {
					children[1] = new Node(ID, this);

					return true;
				} else if (myParent.getNumChild() == 0) {
					children[0] = new Node(ID, this);
					return true;
				}
			} else {
				return myParent.addChild(ID, parentID);
			}

		}
		return false;

	}

	/**
	 * Finds a node using its value
	 * 
	 * @return the node the user wants to find, null if the node does not exist
	 */
	@Override
	public INode find(String value) {
		// TODO Auto-generated method stub
		if (this.nodeID.equals(value)) {
			return this;
		} else {
			if (this.getNumChild() == 1) {
				return children[0].find(value);
			} else if (this.getNumChild() == 2) {
				if (children[0].find(value) == null) {
					return children[1].find(value);
				} else {
					return children[0].find(value);
				}
			} else if (this.getNumChild() == 0) {
				return null;
			}
		}
		return null;
	}

	/**
	 * Accessor of parent
	 * 
	 * @return the parent of a node
	 */
	@Override
	public INode getParent() {
		// TODO Auto-generated method stub
		return parent;
	}

	/**
	 * Returns the size of a tree.
	 * 
	 * @return the size of the tree
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		int size;
		if (getNumChild() == 0) {
			size = 1;
		} else {
			size = 1;
			for (INode child : children) {
				if (child != null) {
					size = size + child.size();
				}
			}
		}
		return size;
	}

	/**
	 * Accessor of the nodeID
	 * 
	 * @return the node id
	 */
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return nodeID;
	}

	/**
	 * Returns the number of children a node
	 * 
	 * @return the number of children a node
	 */
	public int getNumChild() {
		if (children[0] != null && children[1] != null) {
			numChild = 2;
		} else if (children[0] == null && children[1] == null) {
			numChild = 0;
		} else {
			numChild = 1;
		}
		return numChild;
	}

	/**
	 * Mutator of numChild
	 * 
	 * @param numChild the number of children a node has
	 */
	public void setNumChild(int numChild) {
		this.numChild = numChild;
	}

	/**
	 * * Returns a string with the IDs of this node and its immediate children (if
	 * any) all on one line.
	 *
	 * @return a string with the IDs of this node and its immediate children (if
	 *         any).
	 */
	@Override
	public String toString() {
		String s = nodeID;
		for (INode child : children) {
			if (child != null) {
				s += " " + child.getId();
			}
		}
		return s;
	}

}
