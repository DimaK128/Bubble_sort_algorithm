import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Enter the number of elements: ");
            int n = scanner.nextInt();

            int[] arr;

            System.out.print("Do you want to generate values or input them yourself? (1 - Generate, 2 - Input): ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                arr = generateRandomArray(n);
            } else if (choice == 2) {
                arr = getInputArray(n);
            } else {
                System.out.println("Invalid choice. Please enter 1 or 2.");
                continue;
            }

            System.out.println("Original array:");
            printArray(arr);

            bubbleSort(arr);

            System.out.println("Sorted array:");
            printArray(arr);

            System.out.print("Do you want to repeat? (1 - Yes, 2 - No): ");
            int repeat = scanner.nextInt();

            if (repeat != 1) {
                break;
            }

        } while (true);

        System.out.println("Goodbye!");
        scanner.close();
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                // If no two elements were swapped in inner loop, the array is already sorted
                break;
            }
        }
    }

    public static int[] generateRandomArray(int n) {
        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(100); // Generate random values between 0 and 99
        }
        return arr;
    }

    public static int[] getInputArray(int n) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
