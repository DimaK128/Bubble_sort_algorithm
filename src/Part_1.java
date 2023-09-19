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

            System.out.println("Choose an option (random for random values, user for user input): ");
            String choice = scanner.next();

            if (choice.equals("random")) {
                arr = generateRandomArray(n);
            } else if (choice.equals("user")) {
                arr = getUserInputArray(n);
            } else {
                System.out.println("Invalid choice. Please enter 'random' or 'user'.");
                continue;
            }

            System.out.println("Original array:");
            printArray(arr);

            bubbleSort(arr);

            System.out.println("Sorted array:");
            printArray(arr);

            System.out.println("Do you want to repeat the process? (yes or no): ");
        } while (scanner.next().equalsIgnoreCase("yes"));

        System.out.println("Have a nice day! :D");
        scanner.close();
    }

    // Method to generate an array of random values
    private static int[] generateRandomArray(int n) {
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }

    // Method to create an array with values from user input
    private static int[] getUserInputArray(int n) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[n];
        System.out.println("Enter " + n + "numbers:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    // Method of the bubble sort algorithm
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
                break;
                // If no two elements were swapped in the inner loop, the array is already sorted
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
