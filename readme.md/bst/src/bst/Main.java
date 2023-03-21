package bst;
public class Main {
	 public static void main(String[] args) {
		  BinarySearchTree b = new BinarySearchTree();
		  b.insert(5);
		  b.insert(53);
		  b.insert(1);
		  b.insert(56);
		  b.insert(25);
		  b.insert(45);
		  b.insert(16);
		  System.out.println("Preorder root:");
		  b.preOrder(b.root);
		  System.out.println();
		  System.out.println("Inorder root:");
		  b.inOrder(b.root);
		  System.out.println();
		  System.out.println("Postorder root:");
		  b.postOrder(b.root);
		  System.out.println();
		  System.out.println("Level Order:");
		  b.levelOrder();
		  System.out.println();
		  b.search(b.root,26);
		  BinaryNode b1= BinarySearchTree.minimumNode(b.root);
		  System.out.println("The minimum value is "+b1.value);
		  b.deleteNode(b.root, 5);
		  b.deleteNode(b.root, 45);
		  b.deleteNode(b.root, 1);
		  System.out.println("Inorder root:");
		  b.inOrder(b.root);
		  System.out.println();
		  b.deleteBST();
	  }
}
