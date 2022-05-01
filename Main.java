import java.util.ArrayList;
import java.util.List;
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
                    "4. Transpose matrix\n" +
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
                case 4:
                    transposeMatrix();
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
        
        if (scanner.hasNextInt()) {
            List<List<Integer>> data = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                List<Integer> r = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    r.add(scanner.nextInt());
                }
                data.add(r);
            }
            scanner.nextLine();

            Matrix<Integer> matrix0 = new Matrix<>(m, n, data);

            System.out.print("Enter size of second matrix: ");
            m = scanner.nextInt();
            n = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter second matrix:");

            data = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                List<Integer> r = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    r.add(scanner.nextInt());
                }
                data.add(r);
            }
            scanner.nextLine();
            Matrix<Integer> matrix1 = new Matrix<>(m, n, data);

            try{
                Matrix<Integer> matrix = MatrixProcessor.sum(matrix0, matrix1);
                System.out.println("The result is:");
                System.out.println(matrix);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        } else if (scanner.hasNextDouble()) {
            List<List<Double>> data = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                List<Double> r = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    r.add(scanner.nextDouble());
                }
                data.add(r);
            }
            scanner.nextLine();

            Matrix<Double> matrix0 = new Matrix<>(m, n, data);

            System.out.print("Enter size of second matrix: ");
            m = scanner.nextInt();
            n = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter second matrix:");

            data = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                List<Double> r = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    r.add(scanner.nextDouble());
                }
                data.add(r);
            }
            scanner.nextLine();
            Matrix<Double> matrix1 = new Matrix<>(m, n, data);

            try{
                Matrix<Double> matrix = MatrixProcessor.sum(matrix0, matrix1);
                System.out.println("The result is:");
                System.out.println(matrix);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }        
        
    }

    private static void multiplyByConstant() {

        System.out.print("Enter size of matrix: ");
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter matrix:");
        
        if (scanner.hasNextInt()) {
            List<List<Integer>> data = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                List<Integer> r = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    r.add(scanner.nextInt());
                }
                data.add(r);
            }
            scanner.nextLine();

            Matrix<Integer> matrix0 = new Matrix<>(m, n, data);

            System.out.println("Enter constant: ");
            double scalar = scanner.nextDouble();
            scanner.nextLine();

            Matrix<Integer> matrix = MatrixProcessor.scalarMultiplication(matrix0, scalar);
            System.out.println("The result is:");
            System.out.println(matrix);
        } else if (scanner.hasNextDouble()) {
            List<List<Double>> data = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                List<Double> r = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    r.add(scanner.nextDouble());
                }
                data.add(r);
            }
            scanner.nextLine();

            Matrix<Double> matrix0 = new Matrix<>(m, n, data);

            System.out.println("Enter constant: ");
            double scalar = scanner.nextDouble();
            scanner.nextLine();

            Matrix<Double> matrix = MatrixProcessor.scalarMultiplication(matrix0, scalar);
            System.out.println("The result is:");
            System.out.println(matrix);
            
        }
        
    }

    private static void multiplyMatrices() {

        System.out.print("Enter size of first matrix: ");
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter first matrix:");

        if (scanner.hasNextInt())  {
            List<List<Integer>> data = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                List<Integer> r = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    r.add(scanner.nextInt());
                }
                data.add(r);
            }
            scanner.nextLine();

            Matrix<Integer> matrix0 = new Matrix<>(m, n, data);

            System.out.print("Enter size of second matrix: ");
            m = scanner.nextInt();
            n = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter second matrix:");

            data = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                List<Integer> r = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    r.add(scanner.nextInt());
                }
                data.add(r);
            }
            scanner.nextLine();
            Matrix<Integer> matrix1 = new Matrix<>(m, n, data);

            try{
                Matrix<Integer> matrix = MatrixProcessor.matrixMultiplication(matrix0, matrix1);
                System.out.println("The result is:");
                System.out.println(matrix);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        } else if (scanner.hasNextDouble()) {
            List<List<Double>> data = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                List<Double> r = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    r.add(scanner.nextDouble());
                }
                data.add(r);
            }
            scanner.nextLine();

            Matrix<Double> matrix0 = new Matrix<>(m, n, data);

            System.out.print("Enter size of second matrix: ");
            m = scanner.nextInt();
            n = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter second matrix:");

            data = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                List<Double> r = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    r.add(scanner.nextDouble());
                }
                data.add(r);
            }
            scanner.nextLine();
            Matrix<Double> matrix1 = new Matrix<>(m, n, data);

            try{
                Matrix<Double> matrix = MatrixProcessor.matrixMultiplication(matrix0, matrix1);
                System.out.println("The result is:");
                System.out.println(matrix);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }    
        
    }

    private static void transposeMatrix() {

        System.out.print("\n" +
                "1. Main diagonal\n" +
                "2. Side diagonal\n" +
                "3. Vertical line\n" +
                "4. Horizontal line\n" +
                "Your choice: ");

        int transposition = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter size of matrix: ");
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine();


        
        System.out.println("Enter matrix:");
        if (scanner.hasNextInt()) {
            List<List<Integer>> data = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                List<Integer> r = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    r.add(scanner.nextInt());
                }
                data.add(r);
            }
            scanner.nextLine();

            Matrix<Integer> matrix = new Matrix<>(m, n, data);
            executeTransposition(matrix, transposition);

        } else if (scanner.hasNextDouble()) {
            List<List<Double>> data = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                List<Double> r = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    r.add(scanner.nextDouble());
                }
                data.add(r);
            }
            scanner.nextLine();

            Matrix<Double> matrix = new Matrix<>(m, n, data);
            executeTransposition(matrix, transposition);
            
        }
        
    }

    private static <T> void executeTransposition(Matrix<T> matrix, int transposition) {
        Matrix<T> matrix0 = new Matrix<>(matrix.getRows(), matrix.getColumns(), matrix.getTable());
        switch(transposition) {
            case 1:
                matrix0 = MatrixProcessor.mdTransposition(matrix0);
                break;
            case 2:
                matrix0 = MatrixProcessor.sdTransposition(matrix0);
                break;
            case 3:
            matrix0 = MatrixProcessor.vlTransposition(matrix0);
                break;
            case 4:
                //transposeMatrix();
                break;
        }

        System.out.println("The result is:");
        System.out.println(matrix0);
    }
}
