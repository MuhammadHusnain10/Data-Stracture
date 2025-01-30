class LL {
    // Node class to represent each element in the linked list
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // Constructor to initialize the linked list
    public LL() {
        head = null;
    }

    // Insertion method
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode; // Insert at the beginning if the list is empty
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next; // Traverse to the last node
            }
            temp.next = newNode; // Insert at the end
        }
        System.out.println(data + " inserted.");
    }

    // Deletion method
    public void delete(int data) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // If the head node is the one to be deleted
        if (head.data == data) {
            head = head.next;
            System.out.println(data + " deleted.");
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != data) {
            temp = temp.next; // Traverse to find the node to delete
        }

        // If element not found
        if (temp.next == null) {
            System.out.println("Element not found.");
        } else {
            temp.next = temp.next.next; // Remove the node from the list
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

    // Display the linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        System.out.print("Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LL linkedList = new LL();

        linkedList.insert(10);
        linkedList.insert(20);
        linkedList.insert(30);
        linkedList.insert(40);
        linkedList.insert(50);

        linkedList.display(); // Display list before deletion

        linkedList.delete(30); // Deleting element 30
        linkedList.display(); // Display list after deletion

        linkedList.search(20); // Searching for element 20
        linkedList.search(60); // Searching for element 60
    }
}
