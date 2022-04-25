import java.util.Arrays;

public class Matrix {

    private final int rows;
    private final int columns;

    private final int[][] table;

    public Matrix(int rows, int columns, int[][] table) {
        this.rows = rows;
        this.columns = columns;

        this.table = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            this.table[i] = table[i].clone();
        }

    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int[][] getTable() {
        int[][] data = new int[this.rows][this.columns];
        for (int i = 0; i < rows; i++) {
            data[i] = this.table[i].clone();
        }
        return data;
    }

    public static Matrix sum(Matrix a, Matrix b) {
        if (a.getRows() != b.getRows()
                || a.getColumns() != b.getColumns()) {
            throw new IllegalArgumentException("ERROR");
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(table).forEach(row -> {
            Arrays.stream(row).forEach(item -> sb.append(item).append(" "));
            sb.append("\n");
        });
        return sb.toString();
    }
}
