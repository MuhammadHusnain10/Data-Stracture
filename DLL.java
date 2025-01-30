class DLL {
    // Node class to represent each element in the doubly linked list
    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;

    // Constructor to initialize the doubly linked list
    public DLL() {
        head = null;
    }

    // Insertion method (Insert at the end)
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode; // If the list is empty, set the new node as the head
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next; // Traverse to the last node
            }
            temp.next = newNode; // Link the last node to the new node
            newNode.prev = temp; // Link the new node's prev to the last node
        }
        System.out.println(data + " inserted.");
    }

    // Deletion method (Delete a specific element)
    public void delete(int data) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        // If the head node is the one to be deleted
        if (head.data == data) {
            if (head.next == null) {
                head = null; // Only one node, set head to null
            } else {
                head = head.next; // Move head to the next node
                head.prev = null; // Set the new head's prev to null
            }
            System.out.println(data + " deleted.");
            return;
        }

        // If the element to delete is somewhere other than the head
        while (temp != null && temp.data != data) {
            temp = temp.next; // Traverse the list
        }

        if (temp == null) {
            System.out.println("Element not found.");
        } else {
            // If node to delete is in the middle or end
            if (temp.next != null) {
                temp.next.prev = temp.prev; // Set the next node's prev to the current node's prev
            }
            if (temp.prev != null) {
                temp.prev.next = temp.next; // Set the previous node's next to the current node's next
            }
            System.out.println(data + " deleted.");
        }
    }

    // Searching method
    public void search(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                System.out.println(data + " found.");
                return;
            }
            temp = temp.next;
        }
        System.out.println(data + " not found.");
    }

    // Display the doubly linked list (forward traversal)
    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        System.out.print("Doubly Linked List (Forward): ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Display the doubly linked list (backward traversal)
    public void displayBackward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // Traverse to the last node
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        System.out.print("Doubly Linked List (Backward): ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DLL doublyLinkedList = new DLL();

        doublyLinkedList.insert(10);
        doublyLinkedList.insert(20);
        doublyLinkedList.insert(30);
        doublyLinkedList.insert(40);
        doublyLinkedList.insert(50);

        doublyLinkedList.displayForward(); // Display list forward
        doublyLinkedList.displayBackward(); // Display list backward

        doublyLinkedList.delete(30); // Deleting element 30
        doublyLinkedList.displayForward(); // Display list forward after deletion

        doublyLinkedList.search(20); // Searching for element 20
        doublyLinkedList.search(60); // Searching for element 60
    }
}
