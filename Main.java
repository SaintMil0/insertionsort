import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input as a single line
        String input = scanner.nextLine();
        String[] elements = input.trim().split("\\s+");

        // Convert string elements to integers
        int size = Integer.parseInt(elements[0]);
        int[] arr = new int[elements.length - 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(elements[i + 1]);
        }

        // Perform insertion sort
        performInsertionSort(arr);

        scanner.close();
    }

    public static void performInsertionSort(int[] arr) {
        int comparisons = 0;
        int swaps = 0;

        // Print the initial array
        printArray(arr);
        System.out.println();

        // Perform insertion sort
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            boolean didSwap = false;

            // Compare the current element with each element in the sorted portion
            while (j >= 0) {
                comparisons++;
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];  // Shift element to the right
                    didSwap = true;
                    j--;
                } else {
                    break;
                }
            }

            // Place the key in its correct position
            arr[j + 1] = key;

            // If we performed any shifts, count it as one swap operation
            if (didSwap) {
                swaps++;
            }

            // Print the array after each iteration
            printArray(arr);
        }

        System.out.println();
        System.out.println("comparisons: " + comparisons);
        System.out.println("swaps: " + swaps);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
