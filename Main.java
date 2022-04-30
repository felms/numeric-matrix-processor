import java.util.Scanner;

public class Main {

    private static Scanner scanner;
    public static void main(String[] args) {

        scanner = new Scanner(System.in);
        boolean exit = false;

        while(!exit) {

            System.out.print("\n1. Add matrices\n" +
                                "2. Multiply matrix by a constant\n" +
                                "3. Multiply matrices\n" +
                                "0. Exit\n" +
                                "Your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch(choice) {
                case 1:
                    addMatrices();
                    break;
                case 2:
                    multiplyByConstant();
                    break;
                case 3:
                    multiplyMatrices();
                    break;
                case 0:
                    exit = true;
                    break;
            }

        }

        scanner.close();
    
    }

    private static void addMatrices() {

        System.out.print("Enter size of first matrix: ");
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter first matrix:");

        int[][] table = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = scanner.nextInt();
            }
        }
        scanner.nextLine();

        Matrix matrix0 = new Matrix(m, n, table);

        System.out.print("Enter size of second matrix: ");
        m = scanner.nextInt();
        n = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter second matrix:");

        table = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = scanner.nextInt();
            }
        }
        scanner.nextLine();
        Matrix matrix1 = new Matrix(m, n, table);

        try{
            Matrix matrix = MatrixProcessor.sum(matrix0, matrix1);
            System.out.println("The result is:");
            System.out.println(matrix);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private static void multiplyByConstant() {

        System.out.print("Enter size of matrix: ");
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter matrix:");

        int[][] table = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = scanner.nextInt();
            }
        }
        scanner.nextLine();
        Matrix matrix0 = new Matrix(m, n, table);

        System.out.println("Enter constant: ");
        int scalar = scanner.nextInt();
        scanner.nextLine();

        Matrix matrix = MatrixProcessor.scalarMultiplication(matrix0, scalar);
        System.out.println("The result is:");
        System.out.println(matrix);
    }

    private static void multiplyMatrices() {

        System.out.print("Enter size of first matrix: ");
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter first matrix:");

        int[][] table = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = scanner.nextInt();
            }
        }
        scanner.nextLine();
        Matrix matrix0 = new Matrix(m, n, table);

        System.out.print("Enter size of second matrix: ");
        m = scanner.nextInt();
        n = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter second matrix:");

        table = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = scanner.nextInt();
            }
        }
        scanner.nextLine();
        Matrix matrix1 = new Matrix(m, n, table);

        try{
            Matrix matrix = MatrixProcessor.matrixMultiplication(matrix0, matrix1);
            System.out.println("The result is:");
            System.out.println(matrix);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
