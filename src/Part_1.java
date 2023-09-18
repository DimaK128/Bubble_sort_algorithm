import java.util.Random;
import java.util.Scanner;

public class Part_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            int[] arr;
            int n;

            System.out.println("Enter the number of elements: ");
            n = scanner.nextInt();

            System.out.println("Choose an option (1 for random values, 2 for user input): ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                arr = generateRandomArray(n);
            } else if (choice == 2) {
                arr = getUserInputArray(n);
            } else {
                System.out.println("Invalid choice. Please enter 1 or 2.");
                continue;
            }

            System.out.println("Original array:");
            printArray(arr);

            bubbleSort(arr);

            System.out.println("Sorted array:");
            printArray(arr);

            System.out.println("Do you want to repeat the process? (1 for Yes and 0 for No): ");
        } while (scanner.nextInt() == 1);

        System.out.println("Have a nice day! :D!");
        scanner.close();
    }

    // Method to generate an array of random values
    private static int[] generateRandomArray(int n) {
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100); // Adjust the range as needed
        }
        return arr;
    }

    // Method to create an array with values from user input
    private static int[] getUserInputArray(int n) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    // Method to perform the bubble sort algorithm
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break; // If no two elements were swapped in inner loop, the array is already sorted
            }
        }
    }

    // Method to print an array
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
