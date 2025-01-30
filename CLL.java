class CLL {
    // Node class to represent each element in the circular linked list
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // Constructor to initialize the circular linked list
    public CLL() {
        head = null;
    }

    // Insertion method (Insert at the end)
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode; // If the list is empty, set the new node as the head
            newNode.next = head; // Point the node to itself (circular link)
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next; // Traverse until the last node
            }
            temp.next = newNode; // Link the last node to the new node
            newNode.next = head; // Point the new node to the head (circular link)
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
            if (head.next == head) {
                head = null; // Only one node, set head to null
            } else {
                // Find the last node to update its next reference
                while (temp.next != head) {
                    temp = temp.next;
                }
                temp.next = head.next; // Set the last node's next to the second node
                head = head.next; // Update head to the second node
            }
            System.out.println(data + " deleted.");
            return;
        }

        // If the element to delete is somewhere other than the head
        Node prev = null;
        while (temp.next != head && temp.data != data) {
            prev = temp;
            temp = temp.next; // Traverse the list
        }

        if (temp.data == data) {
            prev.next = temp.next; // Link the previous node to the next of the current node
            System.out.println(data + " deleted.");
        } else {
            System.out.println("Element not found.");
        }
    }

    // Searching method
    public void search(int data) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        do {
            if (temp.data == data) {
                System.out.println(data + " found.");
                return;
            }
            temp = temp.next;
        } while (temp != head);

        System.out.println(data + " not found.");
    }

    // Display the circular linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        System.out.print("Circular Linked List: ");
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head); // Loop until we reach the head again
        System.out.println();
    }

    public static void main(String[] args) {
        CLL circularList = new CLL();

        circularList.insert(10);
        circularList.insert(20);
        circularList.insert(30);
        circularList.insert(40);
        circularList.insert(50);

        circularList.display(); // Display list before deletion

        circularList.delete(30); // Deleting element 30
        circularList.display(); // Display list after deletion

        circularList.search(20); // Searching for element 20
        circularList.search(60); // Searching for element 60
    }
}
