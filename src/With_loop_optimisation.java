import java.util.Scanner;
import java.util.Random;

public class With_loop_optimisation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter the number of elements: ");
            int n = scanner.nextInt();

            int[] arr = generateRandomArray(n);

            System.out.println("Original array:");
            printArray(arr);

            bubbleSortWithOptimization(arr);

            System.out.println("Sorted array:");
            printArray(arr);

            System.out.println("Do you want to repeat? (Yes/No): ");
            String repeat = scanner.next();

            if (!repeat.equalsIgnoreCase("yes")) {
                break;
            }

        } while (true);

        System.out.println("Goodbye!");
        scanner.close();
    }

    public static void bubbleSortWithOptimization(int[] arr) {
        // Outer loop
        int n = arr.length;
        boolean swapped = true;
        for (int i = 0; i < n - 1 && swapped; i++) {
            swapped = false;
// The outer loop optimization works by initializing a boolean variable swapped to true before the outer loop.
// If no swaps are made in any iteration of the outer loop, then the array is already sorted and we can break out of the loop.
// This is because if no swaps are needed in any iteration of the outer loop, then the array must already be sorted.


            // Inner loop
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
        }
    }
// The inner loop optimization works by checking if a swap was made at the end of each iteration of the inner loop.
// If no swap was made, then the array is already sorted and we can break out of the inner loop.
// This is because if no swaps are needed, then the elements in the array are already in the correct order.

    public static int[] generateRandomArray(int n) {
        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(100);
        }
        return arr;
    }

    public static int[] getInputArray(int n, Scanner scanner) {
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");

        for (int i = 0; i < n; i++) {
            System.out.print("Element #" + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Element #" + (i + 1) + ": " + arr[i]);
        }
    }
}


// In general, the code with loop optimization avoids unnecessary iterations of the outer and inner loops.



