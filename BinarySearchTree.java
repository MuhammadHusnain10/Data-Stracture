class BinarySearchTree {
    // Node class for BST
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private Node root;

    // Constructor to initialize the BST
    public BinarySearchTree() {
        root = null;
    }

    // Insert method
    public void insert(int data) {
        root = insertRec(root, data);
    }

    // Recursive insert method
    private Node insertRec(Node root, int data) {
        // If the tree is empty, create a new node
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // Otherwise, recur down the tree
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    // In-order traversal (Left, Root, Right)
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left); // Traverse left subtree
            System.out.print(root.data + " "); // Visit node
            inorderRec(root.right); // Traverse right subtree
        }
    }

    // Search method
    public boolean search(int data) {
        return searchRec(root, data);
    }

    private boolean searchRec(Node root, int data) {
        // Base cases: root is null or the data is present at the root
        if (root == null) {
            return false;
        }
        if (root.data == data) {
            return true;
        }

        // Data is smaller than root's data, search in left subtree
        if (data < root.data) {
            return searchRec(root.left, data);
        }

        // Data is greater than root's data, search in right subtree
        return searchRec(root.right, data);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("In-order traversal:");
        tree.inorder(); // Should print the nodes in ascending order
        System.out.println();

        // Search for elements
        System.out.println("Is 40 in the tree? " + tree.search(40)); // true
        System.out.println("Is 90 in the tree? " + tree.search(90)); // false
    }
}
