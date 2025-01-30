class Stack {
    // Node class to represent each element in the stack
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;

    // Constructor to initialize the stack
    public Stack() {
        top = null;
    }

    // Push operation (Insert at the top)
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top; // Link the new node to the current top
        top = newNode; // Update top to the new node
        System.out.println(data + " pushed to stack.");
    }

    // Pop operation (Remove the top element)
    public void pop() {
        if (top == null) {
            System.out.println("Stack is empty, cannot pop.");
            return;
        }
        System.out.println(top.data + " popped from stack.");
        top = top.next; // Move top to the next node
    }

    // Peek operation (View the top element without removing it)
    public void peek() {
        if (top == null) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Top element is: " + top.data);
        }
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Display the stack (from top to bottom)
    public void display() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return;
        }
        Node temp = top;
        System.out.print("Stack: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        stack.display(); // Display the stack

        stack.peek(); // View the top element

        stack.pop(); // Pop an element
        stack.display(); // Display the stack after pop

        stack.peek(); // View the top element after pop
    }
}
