import java.util.ArrayList;
import java.util.List;
public class MatrixProcessor {

    public static <T> Matrix<T> sum(Matrix<T> a, Matrix<T> b) {
        if (a.getRows() != b.getRows()
                || a.getColumns() != b.getColumns()) {
            throw new IllegalArgumentException("The operation cannot be performed.");
        }
        int rows = a.getRows();
        int columns = a.getColumns();

        List<List<T>> data = new ArrayList<>();
        List<List<T>> aTable = a.getTable();
        List<List<T>> bTable = b.getTable();;

        for (int i = 0; i < rows; i++) {
            List<T> r = new ArrayList<>();
            List<T> aR = aTable.get(i);
            List<T> bR = bTable.get(i);
            for (int j = 0; j < columns; j++) {
                r.add(add(aR.get(j), bR.get(j))); ;
            }
            data.add(r);
        }

        return new Matrix<T>(rows, columns, data);
    }

    public static <T> Matrix<T> scalarMultiplication(Matrix<T> matrix, double scalar) {
        int rows = matrix.getRows();
        int columns = matrix.getColumns();

        List<List<T>> data = new ArrayList<>();
        List<List<T>> mTable = matrix.getTable();
        for (int i = 0; i < rows; i++) {
            List<T> r = new ArrayList<>();
            List<T> rTable = mTable.get(i);
            for (int j = 0; j < columns; j++) {
                r.add(multiplyByS(rTable.get(j), scalar));
            }
            data.add(r);
        }

        return new Matrix<T>(rows, columns, data);
    }

    public static <T> Matrix<T> matrixMultiplication(Matrix<T> a, Matrix<T> b) {
        if (a.getColumns() != b.getRows()) {
            throw new IllegalArgumentException("The operation cannot be performed.");
        }

        int rows = a.getRows();
        int columns = b.getColumns();

        List<List<T>> data = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            List<T> r = a.getRow(i);
            List<T> rTable = new ArrayList<>();

            for (int j = 0; j < columns; j++) {
                List<T> c = b.getColumn(j);
                T sum = getZero(c.get(0));
                for (int k = 0; k < r.size(); k++) {
                    sum = add(sum, multiply(r.get(k), c.get(k)));
                }
                rTable.add(sum);
            }
            data.add(rTable);
        }

        return new Matrix<T>(rows, columns, data);
    }

    private static<T> T add(T x, T y){

        if (x == null || y == null) {
            return null;
        }

        if (x instanceof Double) {
            return (T) new Double((Double) x + (Double) y);
        } else if (x instanceof Integer) {
            return (T)new Integer((Integer) x + (Integer) y);
        } else {
            throw new IllegalArgumentException("Type " + x.getClass() + " is not supported by this method");
        }
    }

    private static<T> T multiplyByS(T x, double s){

        if (x == null) {
            return null;
        }

        if (x instanceof Double) {
            return (T) new Double((Double) x * s);
        } else if (x instanceof Integer) {
            return (T)new Integer((Integer) x * (int)s);
        } else {
            throw new IllegalArgumentException("Type " + x.getClass() + " is not supported by this method");
        }
    }

    private static<T> T multiply(T x, T y){

        if (x == null || y == null) {
            return null;
        }

        if (x instanceof Double) {
            return (T) new Double((Double) x * (Double) y);
        } else if (x instanceof Integer) {
            return (T)new Integer((Integer) x * (Integer) y);
        } else {
            throw new IllegalArgumentException("Type " + x.getClass() + " is not supported by this method");
        }
    }

    private static<T> T getZero(T data){
        if (data instanceof Double) {
            return (T) new Double(0);
        } else if (data instanceof Integer) {
            return (T) new Integer(0);
        }

        return null;
    }

}
