class Array {
    private int[] arr;
    private int size;

    // Constructor to initialize the array
    public Array(int capacity) {
        arr = new int[capacity];
        size = 0;
    }

    // Insertion method
    public void insert(int element) {
        if (size < arr.length) {
            arr[size] = element;
            size++;
            System.out.println(element + " inserted.");
        } else {
            System.out.println("Array is full, cannot insert.");
        }
    }

    // Deletion method
    public void delete(int element) {
        int index = -1;
        // Finding the element to delete
        for (int i = 0; i < size; i++) {
            if (arr[i] == element) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            // Shift elements to the left
            for (int i = index; i < size - 1; i++) {
                arr[i] = arr[i + 1];
            }
            size--;
            System.out.println(element + " deleted.");
        } else {
            System.out.println("Element not found.");
        }
    }

    // Searching method
    public void search(int element) {
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (arr[i] == element) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println(element + " found.");
        } else {
            System.out.println(element + " not found.");
        }
    }

    // Display the array elements
    public void display() {
        if (size == 0) {
            System.out.println("Array is empty.");
        } else {
            System.out.print("Array: ");
            for (int i = 0; i < size; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Array array = new Array(5); // Creating an array with capacity 5

        array.insert(10);
        array.insert(20);
        array.insert(30);
        array.insert(40);
        array.insert(50);

        array.display(); // Display array before deletion

        array.delete(30); // Deleting element 30
        array.display(); // Display array after deletion

        array.search(20); // Searching for element 20
        array.search(60); // Searching for element 60
    }
}
