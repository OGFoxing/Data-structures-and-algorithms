package kz.ogfox.bst;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


class Node {
	int key;
	String name; 
	
	Node  leftChild;
	Node rightChild;
	
	Node (int key, String name) {
		this.key = key;
		this.name = name;
	}
	public String toString() {
		return  name+ "'s" + " key = " + key; 
		
	}
}

public class Main {
	Node root;
	
	public void addNode(int key, String name) {
		/* create new node*/
		Node newNode = new Node (key, name);
		
		/*if node not root it becomes root*/
		if (root == null) {
			root = newNode;
		}
		/*find leaf node*/
		else {
			Node focusNode	= root;
			Node parent;
			while (true) {
				parent = focusNode;
				/* left child */
				if(key < focusNode.key) {
					focusNode = focusNode.leftChild;
					if (focusNode == null) {
						parent.leftChild = newNode;
						return;
					}
				}
				else {
					/* right child */
					focusNode = focusNode.rightChild;
					if (focusNode == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
		
	}
	
	public void visitTheTree(Node focusNode) {
		if (focusNode != null) {
			/* visited left node */
			visitTheTree(focusNode.leftChild);
			/* visited right node */
			visitTheTree(focusNode.rightChild);
			/*visited currently focused node*/
			System.out.println(focusNode);
		}
	}
	
	public Node findElement(int key) {
		/* start from 1st element of the tree (root) */
		Node focusNode = root;
		while(focusNode.key != key) {
			if(key < focusNode.key) {
				focusNode = focusNode.leftChild;
			}
			else {
				focusNode = focusNode.rightChild;
			}
			if (focusNode == null)
				return null;
		}
	return focusNode;
	}
	
	public Node max() {
		Node focusNode = root;
		if(focusNode == null) {
			return null;
		}
		else {
			while(focusNode.rightChild != null) {
				focusNode = focusNode.rightChild;
			}
		}
		return focusNode;
	}
	
	public Node min() {
		Node focusNode = root;
		if(focusNode == null) {
			return null;
		}
		else {
			while(focusNode.leftChild != null) {
				focusNode = focusNode.leftChild;
			}
		}
		return focusNode;
	}
	public Node insertNode(int key, String name) {
		Node focusNode = root;
		
		return focusNode;
	}
	public boolean romoveNode(int key) {
		Node focusNode = root;
		Node parent = root;
		
		boolean itLeftChild = true;
		
		while(focusNode.key != key) {
			parent = focusNode;
			if(key < focusNode.key) {
				itLeftChild = true;
				focusNode = focusNode.leftChild;
			}
			else {
				itLeftChild = false;
				focusNode = focusNode.rightChild;
			}
			if (focusNode == null) {
				return false;
			}
		}
		/*if node doesnt have childs*/
		if((focusNode.leftChild) == null && (focusNode.rightChild == null)) {
			if(focusNode == root) 
				root = null;
			
			else if(itLeftChild)
				parent.leftChild = null;
			
			else 
				parent.rightChild = null;
		}
		/*rightChild null*/
		else if (focusNode.rightChild == null) {
			
			if(focusNode == root)
				root = focusNode.leftChild;
			
			else if (itLeftChild)
				parent.leftChild = focusNode.leftChild;
			
			else 
				parent.rightChild = focusNode.leftChild;
		}
		/*leftChild null*/
		else if (focusNode.leftChild == null) {
			
			if(focusNode == root) 
				root = focusNode.rightChild;
			
			else if (itLeftChild) 
				parent.leftChild = 	focusNode.rightChild;
			
			else 
				parent.rightChild = focusNode.leftChild;
		}
		else {
			Node replacement = getReplacementNode(focusNode);
			if (focusNode == root)
				root = replacement;
			
			else if (itLeftChild) 
				parent.leftChild = replacement;
			else 
				parent.rightChild = replacement;
			replacement.leftChild = focusNode.leftChild;
			
		}
		return true;
	}

	public Node getReplacementNode(Node replacedNode) {
		Node replacementParent = replacedNode;
		Node replacement = replacedNode;
		Node focusNode = replacement.rightChild;
		while(focusNode != null) {
			replacementParent = replacedNode;
			replacedNode = focusNode;
			focusNode = focusNode.leftChild;
		}
		if (replacement != replacedNode.rightChild) {
			replacementParent.leftChild = replacement.rightChild;
			replacement.rightChild = replacedNode.rightChild;
		}
		return replacement;
		
	}
public static void main(String[] args) {
	
		int find;
		int count = 0;
		String line;
		Main theTree = new Main();
		/*where key=length of string, and name=line*/
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/war_and_peace.txt"));
			while((line = br.readLine()) != null) {
				theTree.addNode(line.length(), line);
				count++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*theTree.addNode(10, "Derek");
		theTree.addNode(40, "Bll");
		theTree.addNode(5, "Abrakham");
		theTree.addNode(8, "Glen");
		theTree.addNode(15, "Karl!");
		theTree.romoveNode(15);
		theTree.visitTheTree(theTree.root);
		*/
		System.out.println("=====================");
		System.out.println("Count of Nodes: " + count);
		Scanner scan = new Scanner(System.in);
		find = scan.nextInt();
		System.out.println(theTree.findElement(find));
		System.out.println("Max: " + theTree.max());
		System.out.println("Min: "+ theTree.min());
		
	}
}
