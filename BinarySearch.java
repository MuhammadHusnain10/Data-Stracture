class BinarySearch {
    // Binary Search method (Assumes the array is sorted)
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if target is at mid
            if (arr[mid] == target) {
                return mid; // Return the index of the target
            }
            // If target is smaller than mid, search in the left half
            if (arr[mid] > target) {
                right = mid - 1;
            }
            // If target is greater than mid, search in the right half
            else {
                left = mid + 1;
            }
        }
        return -1; // Return -1 if the target is not found
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int target = 30;

        int result = binarySearch(arr, target);
        if (result == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}
