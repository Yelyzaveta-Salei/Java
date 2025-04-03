package lab2;
import java.util.Scanner;
import java.util.Random;

public class App {

    // Constants to define the maximum size and value range of the matrix elements
    private static final int SIZE_MAX = 20;
    private static final int MIN = 10;
    private static final int MAX = 99;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome! Please set the parameters for the matrix.");

        // Prompting the user to input width and height of the matrix
        System.out.println("Width (no more than 20):");
        int width = scanner.nextInt();
        System.out.println("Height (no more than 20):");
        int height = scanner.nextInt();

        // Check if the width or height exceeds the maximum allowed size
        if (width > SIZE_MAX || height > SIZE_MAX) {
            System.out.println("Width or height exceeds the maximum size.");
            return;
        }

        // Initializing the matrix with given dimensions
        int[][] matrix = new int[height][width];

        // Ask the user to choose the method for matrix creation
        System.out.println("Choose the method to create the matrix: 1 - manually, any other number - randomly");
        int choice = scanner.nextInt();

        // Filling the matrix based on user's choice
        if (choice == 1) {
            manual(matrix, scanner);
        } else {
            random(matrix);
        }

        // Print the filled matrix
        print(matrix);

        // Calculate and display matrix properties using separate methods
        System.out.println("Minimum element: " + findMin(matrix));
        System.out.println("Maximum element: " + findMax(matrix));
        System.out.println("Arithmetic mean: " + findArithmetic(matrix));
        System.out.println("Geometric mean: " + findGeometric(matrix));
    }

    // Method for manually entering matrix elements
    private static void manual(int[][] matrix, Scanner scanner) {
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int value;
                while (true) {
                    value = scanner.nextInt();
                    // Validate the entered value to be within the allowed range
                    if (value >= MIN && value <= MAX) {
                        break;
                    } else {
                        System.out.println("Value must be between " + MIN + " and " + MAX + ". Please try again.");
                    }
                }
                matrix[i][j] = value;
            }
        }
    }

    // Method for generating matrix elements randomly
    private static void random(int[][] matrix) {
        Random random = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // Generate random values within the specified range
                matrix[i][j] = MIN + random.nextInt(MAX - MIN + 1);
            }
        }
    }

    // Method for printing the matrix
    private static void print(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    // Method to find the minimum element in the matrix
    private static int findMin(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        for (int[] row : matrix) {
            for (int element : row) {
                if (element < min) min = element;
            }
        }
        return min;
    }

    // Method to find the maximum element in the matrix
    private static int findMax(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            for (int element : row) {
                if (element > max) max = element;
            }
        }
        return max;
    }

    // Method to calculate the arithmetic mean of matrix elements
    private static double findArithmetic(int[][] matrix) {
        double sum = 0;
        int count = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                sum += element;
                count++;
            }
        }
        return sum / count;
    }

    // Method to calculate the geometric mean of the absolute values of matrix elements
    private static double findGeometric(int[][] matrix) {
        double product = 1.0;
        int count = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                product *= Math.abs(element);
                count++;
            }
        }
        return Math.pow(product, 1.0 / count);
    }
}