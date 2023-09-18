import java.util.Arrays;
import java.util.Random;

public class Part_2 {
    public static void main(String[] args) {
        // Generate a random array with 6 elements
        int[] array = generateRandomArray(6);

        // Display the initial array
        System.out.println("Initial array:");
        printArray(array);

        // Perform bubble sort and create iteration snapshots
        bubbleSortWithSnapshots(array);
    }

    // Function to generate a random array with n elements
    private static int[] generateRandomArray(int n) {
        Random rand = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(100); // Random integers between 0 and 99
        }
        return array;
    }

    // Function to perform bubble sort and create iteration snapshots
    private static void bubbleSortWithSnapshots(int[] array) {
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            System.out.println("\nOuter loop, iteration " + (i + 1) + ":");
            printArray(array);

            for (int j = 0; j < n - i - 1; j++) {
                System.out.println("\nInner loop:");
                printArray(array);
                System.out.println("Comparing elements at indices " + j + " and " + (j + 1));

                if (array[j] > array[j + 1]) {
                    // Swap the elements
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    System.out.println("Swapping elements at indices " + j + " and " + (j + 1) + ":");
                    printArray(array);
                    swapped = true;
                }
            }

            if (!swapped) {
                // If no swaps were made in this pass, the array is already sorted
                break;
            }
        }

        System.out.println("\nFinal sorted array:");
        printArray(array);
    }

    // Function to print an array
    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
