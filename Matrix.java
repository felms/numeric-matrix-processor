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

    public int[] getRow(int rowNumber) {
        if (rowNumber > this.rows || rowNumber < 0) {
            throw new IllegalArgumentException("value invalid for 'rowNumber' -> " + rowNumber);
        }

        int[] r = new int[this.columns];

        for (int i = 0; i < this.columns; i++) {
            r[i] = this.table[rowNumber][i];
        }

        return r;
    }

    public int[] getColumn(int columnNumber) {
        if (columnNumber > this.columns || columnNumber < 0) {
            throw new IllegalArgumentException("value invalid for 'columnNumber' -> " + columnNumber);
        }

        int[] c = new int[this.rows];

        for (int i = 0; i < this.rows; i++) {
            c[i] = this.table[i][columnNumber];
        }

        return c;
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
