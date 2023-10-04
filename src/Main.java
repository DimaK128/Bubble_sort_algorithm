import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter the number of elements: ");
            int n = scanner.nextInt();

            int[] arr;

            System.out.println("Do you want to generate random values or input them by yourself? (Random/Input): ");
            String choice = scanner.next();

            if (choice.equalsIgnoreCase("Random")) {
                arr = generateRandomArray(n);
            } else if (choice.equalsIgnoreCase("Input")) {
                arr = getInputArray(n, scanner);
            } else {
                System.out.println("Invalid choice. Please enter 'generate' or 'input'.");
                continue;
            }

            System.out.println("Original array:");
            printArray(arr);

            bubbleSort(arr);

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

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];                                    // Swap arr[j] and arr[j+1]
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }
            }
        }
    }

    public static int[] generateRandomArray(int n) {
        int[] arr = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(100);      // Generates random values from 1 to 100
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
        return arr;                           // Here user types elements of his array and that array returns back
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Element #" + (i + 1) + ": " + arr[i]);   // Prints elements of our array
        }
    }
}
