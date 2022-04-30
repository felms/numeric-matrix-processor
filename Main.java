import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] table = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = scanner.nextInt();
            }
        }

        Matrix matrix0 = new Matrix(m, n, table);

        m = scanner.nextInt();
        n = scanner.nextInt();
        table = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = scanner.nextInt();
            }
        }

        Matrix matrix1 = new Matrix(m, n, table);

        System.out.println(MatrixProcessor.matrixMultiplication(matrix0, matrix1));

        // int m = scanner.nextInt();
        // int n = scanner.nextInt();
        // int[][] table = new int[m][n];
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         table[i][j] = scanner.nextInt();
        //     }
        // }

        // Matrix matrix = new Matrix(m, n, table);
        // int scalar = scanner.nextInt();

        // Matrix result = Matrix.scalarMultiplication(matrix, scalar);

        // System.out.println(result);

        // scanner.close();
//        Scanner scanner = new Scanner(System.in);
//
//        int m = scanner.nextInt();
//        int n = scanner.nextInt();
//        int[][] table = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                table[i][j] = scanner.nextInt();
//            }
//        }
//
//        Matrix matrix0 = new Matrix(m, n, table);
//
//        m = scanner.nextInt();
//        n = scanner.nextInt();
//        table = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                table[i][j] = scanner.nextInt();
//            }
//        }
//
//        Matrix matrix1 = new Matrix(m, n, table);
//
//        try{
//            Matrix matrix = Matrix.sum(matrix0, matrix1);
//            System.out.println(matrix);
//        } catch (IllegalArgumentException iae) {
//            System.out.println(iae.getMessage());
//        }
    }
}
