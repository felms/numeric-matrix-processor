public class MatrixProcessor {

    public static Matrix sum(Matrix a, Matrix b) {
        if (a.getRows() != b.getRows()
                || a.getColumns() != b.getColumns()) {
            throw new IllegalArgumentException("The operation cannot be performed.");
        }
        int rows = a.getRows();
        int columns = a.getColumns();

        int[][] data = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = a.getTable()[i][j] + b.getTable()[i][j];
            }
        }

        return new Matrix(rows, columns, data);
    }

    public static Matrix scalarMultiplication(Matrix matrix, int scalar) {
        int rows = matrix.getRows();
        int columns = matrix.getColumns();

        int[][] data = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = matrix.getTable()[i][j] * scalar;
            }
        }

        return new Matrix(rows, columns, data);
    }
    
    public static Matrix matrixMultiplication(Matrix a, Matrix b) {
         if (a.getColumns() != b.getRows()) {
            throw new IllegalArgumentException("The operation cannot be performed.");
         }

         int rows = a.getRows();
         int columns = b.getColumns();

         int[][] data = new int[rows][columns];

         for (int i = 0; i < rows; i++) {
             int[] r = a.getRow(i);
             for (int j = 0; j < columns; j++) {
                 int[] c = b.getColumn(j);
                 int sum = 0;
                 for (int k = 0; k < r.length; k++) {
                     sum += r[k] * c[k];
                 }
                 data[i][j] = sum;
             }
         }

         return new Matrix(rows, columns, data);
    }
}
