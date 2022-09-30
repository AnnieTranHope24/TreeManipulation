package project7;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class interacts with the user. It gets input from the user and do what
 * they want.
 * 
 * @author PC
 *
 */
public class UserInterface {
	private Node root;
	private Scanner scan;
	private boolean isStopped;

	/**
	 * The constructor of the class.
	 */
	public UserInterface() {
		root = new Node("A");
		createTree();
		isStopped = false;
		scan = new Scanner(System.in);
	}

	/**
	 * Creates the tree at the beginning.
	 */
	private void createTree() {
		// TODO Auto-generated method stub
		root.addChild("B", "A");
		root.addChild("C", "A");
		root.addChild("D", "B");
		root.addChild("E", "B");
		root.addChild("F", "C");
		root.addChild("G", "C");
		root.addChild("H", "D");
		root.addChild("I", "D");
		root.addChild("J", "E");
		root.addChild("K", "E");
		root.addChild("L", "F");
		root.printTree();
		System.out.println("There are " + root.size() + " nodes in this tree.\n");
	}

	/**
	 * Runs the whole program. It loops as long as the user wants to, and perform
	 * the tasks desired by the user.
	 */
	public void manipulateTree() {
		// TODO Auto-generated method stub
		while (!isStopped) {
			printMenu();
			menuOptions();
		}
	}

	/**
	 * Prints out the menu that contains options for the user to choose.
	 */
	public void printMenu() {
		System.out.println("Please select one of the following options:");
		System.out.println("1. Add Node");
		System.out.println("2. Tree Size");
		System.out.println("3. Find Node");
		System.out.println("0. Exit");
	}

	/**
	 * Deals with each options in the menu.
	 */
	public void menuOptions() {
		System.out.print("->");

		try {
			int val = scan.nextInt();
			if (val == 1) {
				boolean isAdded = addNode();
				if (isAdded) {
					System.out.println("Node successfully added!");
					root.printTree();
				}
			} else if (val == 2) {
				findTreeSize();
			} else if (val == 3) {
				findNode();

			} else if (val == 0) {
				isStopped = true;
			} else {
				throw new InvalidInputException();
			}

		} catch (InputMismatchException e) {
			System.out.println("Please enter an integer");
			scan.next();
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Adds a node to the tree using input from the user.
	 * 
	 * @return true if the node can be added, false if cannot
	 */
	public boolean addNode() {
		System.out.println("Please input the node you want to add->");
		String newID = scan.next();
		System.out.println("Please input the parent node of " + newID + "->");
		String parentID = scan.next();
		return root.addChild(newID, parentID);

	}

	/**
	 * Find the size of the tree specified by the user.
	 */
	public void findTreeSize() {
		System.out.println("Please input the root node->");
		String val = scan.next();
		INode rootNode = root.find(val);
		if (rootNode == null) {
			System.out.println("The tree does not have that root node.");
		} else {
			int size = rootNode.size();
			System.out.println("There are " + size + " nodes in that tree.");
			rootNode.printTree();
		}

	}

	/**
	 * Finds a node specified by the user.
	 */
	public void findNode() {
		System.out.println("Please input the node you want to find->");
		String val = scan.next();
		INode rootNode = root.find(val);
		if (rootNode == null) {
			System.out.println("Node " + val + " does not exist.");
		} else {
			System.out.println("Node " + val + " found!");
		}
	}

}
