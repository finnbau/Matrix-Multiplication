package matrix_multiplication;

// add possible package statement here

public class Matrix {
    /**
     * number of rows in the matrix
     */
    public int rows = 0;
    /**
     * number of columns in the matrix
     */
    public int cols = 0;
    /**
     * reference to underlying data (can be much larger than rows * columns)
     */
    public double[] data = null;
    /**
     * Index of the first element (0,0) in the data array
     */
    public int start = 0;
    /**
     * Underlying row length (the distance from (i,j) to (i+1,j) in the data
     * array)
     */
    public int stride = 0;

    /**
     * The full constructor
     * 
     * @param rows   rows
     * @param cols   columns
     * @param data   reference to data
     * @param start  start index
     * @param stride stride length
     */
    public Matrix(int rows, int cols, double[] data, int start, int stride) {
        this.rows = rows;
        this.cols = cols;
        this.data = data;
        this.start = start;
        this.stride = stride;
    }

    /**
     * Initializes an rows * cols matrix of zeros
     * 
     * @param rows rows
     * @param cols columns
     */
    public Matrix(int rows, int cols) {
        this(rows, cols, new double[rows * cols], 0, cols);
    }

    /**
     * Initializes a rows * cols matrix with the given array of length
     * rows*cols
     * 
     * @param rows rows
     * @param cols columns
     * @param data data array of length rows*cols
     */
    public Matrix(int rows, int cols, double[] data) {
        this(rows, cols, data, 0, cols);
    }

    /**
     * Initializes an empty matrix
     */
    public Matrix() {

    }

    /**
     * Returns a string representation of the matrix
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; ++i) {
            if (i > 0)
                sb.append('\n');
            for (int j = 0; j < cols; ++j) {
                if (j > 0)
                    sb.append(" ");
                sb.append(data[start + i * stride + j]);
            }
        }
        return sb.toString();
    }

    /**
     * A slow bounds-checked helper function to get an element in the array.
     * This function is only good for debugging purposes, don't use in your
     * matrix multiplication routines.
     * 
     * @param i row
     * @param j column
     * @return Element at (i,j)
     */
    public double getSlow(int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return data[start + i * stride + j];
    }

    /**
     * A slow bounds-checked helper function to set an element in the array.
     * This function is only good for debugging purposes, don't use in your
     * matrix multiplication routines.
     * 
     * @param i row
     * @param j column
     * @param v Value to set at (i,j)
     */
    public void setSlow(int i, int j, double v) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            throw new ArrayIndexOutOfBoundsException();
        }
        data[start + i * stride + j] = v;
    }

    /**
     * @return Returns a deep copy of the matrix
     */
    public Matrix copy() {
        Matrix A = new Matrix(rows, cols);
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                A.data[i * cols + j] = data[start + i * stride + j];
            }
        }
        return A;
    }

    /**
     * Performs the O(n^3) elementary multiplication with three nested loops.
     * 
     * @param A Left-hand input of size n*m.
     * @param B Right-hand input of size m*p.
     * @return Matrix C of size n*p satisfying C=AB.
     */
    public static Matrix elementaryMultiplication(Matrix A, Matrix B) {
        int n = A.rows;
        int m = A.cols;
        int p = B.cols;
        Matrix C = new Matrix(n, p);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    double currentVal = C.data[C.start + i * C.stride + j];
                    double aVal = A.data[A.start + i * A.stride + k];
                    double bVal = B.data[B.start + k * B.stride + j];
                    C.data[C.start + i * C.stride + j] = currentVal + (aVal * bVal);
                }
            }
        }
        return C;
    }

    /**
     * Performs the O(n^3) elementary matrix multiplication in place, that is,
     * computes C += AB. Importantly, the matrix C must be of correct shape,
     * and it is *not* zeroed; this enables us to accumulate products.
     * 
     * @param C Output matrix
     * @param A Left-hand operand
     * @param B Right-hand operand
     */
    public static void elementaryMultiplication(Matrix A, Matrix B, Matrix C) {
        Matrix intermediary = elementaryMultiplication(A, B);
        for(int i=0;i<C.rows*C.cols;i++){
            C.data[i]+=intermediary.data[i];
        }
    }



    /**
     * Returns a transposed copy of the matrix.
     * 
     * @return A transposed copy of the matrix.
     */
    public static Matrix transpose(Matrix A) {
        Matrix transposed = new Matrix(A.rows, A.cols);
        int n = A.rows;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transposed.data[transposed.start + j * transposed.stride + i] = A.data[A.start + i * A.stride + j];
            }
        }
        return transposed;
    }

    /**
     * Stores a transposed version of the matrix A into B. Assuming A has
     * m rows and n cols, B should have n rows and m cols. The function does
     * not reallocate any data in B, but simply stores the transposed matrix
     * *in* B.
     * 
     * @param A
     * @param B
     */
    public static void transpose(Matrix A, Matrix B) {
        int n = A.rows;
        for (int i = A.start; i < n; i++) {
            for (int j = A.start; j < n; j++) {
                B.data[B.start + j * B.stride + i] = A.data[A.start + i * A.stride + j];
            }
        }
    }

    /**
     * Recursive transpose
     * 
     * @param A Input matrix
     * @param B Output matrix (must be of correct shape)
     * @param s Minimum size: if the subproblem size is at most this, then the
     *          regular transpose is called.
     */
    public static void transposeRec(Matrix A, Matrix B, int s) {
        int n = A.rows;
        if (n <= s) {
            transpose(A, B);
        } else {
            transposeRec(A.view(0, 0, n / 2, n / 2), B.view(0, 0, n / 2, n / 2), s);
            transposeRec(A.view(n / 2, 0, n / 2, n / 2), B.view(n / 2, 0, n / 2, n / 2), s);
            transposeRec(A.view(0, n / 2, n / 2, n / 2), B.view(0, n / 2, n / 2, n / 2), s);
            transposeRec(A.view(n / 2, n / 2, n / 2, n / 2), B.view(n / 2, n / 2, n / 2, n / 2), s);
        }
    }

    /**
     * Performs the O(n^3) elementary multiplication with three nested loops.
     * A transposed copy of the right-hand operand is constructed before
     * computing the multiplication, using the transposeRec function.
     * 
     * @param A Left-hand input of size n*m.
     * @param B Right-hand input of size m*p.
     * @param s The minimum size parameter for transposeRec.
     * @return Matrix C of size n*p satisfying C=AB.
     */
    public static Matrix elementaryMultiplicationTransposed(Matrix A, Matrix B, int s) {
        int n = A.rows;
        Matrix bTransposed = transpose(B);
        Matrix C = new Matrix(n, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    double currentVal = C.data[C.start + i * C.stride + j];
                    double aVal = A.data[A.start + i * A.stride + k];
                    double bVal = bTransposed.data[bTransposed.start + j * bTransposed.stride + k];
                    C.data[C.start + i * C.stride + j] = currentVal + (aVal * bVal);
                }
            }
        }

        return C;
    }

    /**
     * Performs tiled matrix multiplication using a tile size of s*s.
     * 
     * @param A Left-hand input.
     * @param B Right-hand input.
     * @param s Tile size.
     * @return Matrix C satisfying C=AB.
     */
    public static Matrix tiledMultiplication(Matrix A, Matrix B, int s) {
        int n = A.rows;
        if (n%s!=0) {
            throw new RuntimeException("Faulty use of tiledMultiplication, s does not divide n.");
        }

        Matrix C = new Matrix(n, n);
        for(int i=0;i<n/s;i++){ //Per instructions assumes n%s == 0
            for(int j=0;j<n/s;j++){
                for(int k=0;k<n/s;k++){
                    Matrix cView = C.view(i, j, s, s);
                    Matrix aView = A.view(i, k, s, s);
                    Matrix bView = B.view(k,j,s,s);
                    elementaryMultiplication(aView, bView, cView);
                }
            }
        }

        return C;
    }

    /**
     * Returns a view (a shallow matrix header) of the submatrix with the
     * given number of rows and columns whose upper-left corner is at (i0,j0).
     * No data is copied.
     * 
     * @param i0   Upper-left row.
     * @param j0   Upper-left column.
     * @param rows Number of rows.
     * @param cols Number of columns.
     * @return A shallow view of the submatrix.
     */
    public Matrix view(int i0, int j0, int rows, int cols) {
        return new Matrix(rows, cols, data, start + stride * i0 + j0, stride);
    }

    /**
     * Recursive matrix multiplication
     * 
     * @param A Left-hand operand
     * @param B Right-hand operand
     * @param C Output matrix
     * @param s Subproblem size
     */
    public static void recursiveMultiplication(Matrix A, Matrix B, Matrix C, int s) {
        /* Fill here the missing implementation */
    }

    /**
     * Computes the matrix product using Strassen's algorithm.
     * 
     * @param A Left-hand operand
     * @param B Right-hand operand
     * @param C Output matrix such that C=AB
     * @param s Minimum size for recursion: for subproblem sizes at most this,
     *          an O(n^3) algorithm will be used.
     */
    public static void strassen(Matrix A, Matrix B, Matrix C, int s) {
        /* Fill here the missing implementation */
    }

    /**
     * Set all elements of the matrix equal to v.
     * 
     * @param v Target value.
     */
    public void setAll(double v) {
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                data[start + i * stride + j] = v;
            }
        }
    }

    /**
     * Computes A += B in-place
     * 
     * @param B The right-hand-side operand
     */
    public void add(Matrix B) {
        if (this.rows != B.rows && this.cols != B.cols) {
            throw new RuntimeException("Faulty addition, matrixes were not of same shape.");
        }
        for(int i=0;i<this.rows*this.cols;i++){
            this.data[i]+=B.data[i];
        }
    }

    /**
     * Returns a new matrix C satisfying C = A+B
     * 
     * @param A Left-hand operand
     * @param B Right-hand operan
     * @return Matrix C satisfying C=A+B
     */
    public static Matrix add(Matrix A, Matrix B) {
        if (A.rows != B.rows && A.cols != B.cols) {
            throw new RuntimeException("Faulty addition, matrixes were not of same shape.");
        }
        Matrix result = new Matrix(A.rows, A.cols);
        for (int i = 0; i < A.data.length; i++) {
            result.data[i] = A.data[i] + B.data[i];
        }
        return result;
    }

    /**
     * Stores A+B into C. Shapes of all matrices must match.
     * 
     * @param A Left-hand operand
     * @param B Right-hand operand
     * @param C Output matrix
     */
    public static void add(Matrix A, Matrix B, Matrix C) {
        if (A.rows != B.rows && A.cols != B.cols && A.rows!=C.rows && A.cols!=C.cols) {
            throw new RuntimeException("Faulty addition, matrixes were not of same shape.");
        }
        for(int i=0;i<A.rows*A.cols;i++){
            C.data[i]=A.data[i]+B.data[i];
        }
    }

    /**
     * Computes A -= B in-place
     * 
     * @param B The right-hand-side operand
     */
    public void sub(Matrix B) {
        if (this.rows != B.rows && this.cols != B.cols) {
            throw new RuntimeException("Faulty addition, matrixes were not of same shape.");
        }
        for(int i=0;i<this.rows*this.cols;i++){
            this.data[i]-=B.data[i];
        }
    }

    /**
     * Returns a new matrix C satisfying C = A-B
     * 
     * @param A Left-hand operand
     * @param B Right-hand operan
     * @return Matrix C satisfying C=A-B
     */
    public static Matrix sub(Matrix A, Matrix B) {
        if (A.rows != B.rows && A.cols != B.cols) {
            throw new RuntimeException("Faulty addition, matrixes were not of same shape.");
        }
        Matrix result = new Matrix(A.rows, A.cols);
        for (int i = 0; i < A.data.length; i++) {
            result.data[i] = A.data[i] - B.data[i];
        }
        return result;
    }

    /**
     * Stores A-B into C. Shapes of all matrices must match.
     * 
     * @param A Left-hand operand
     * @param B Right-hand operand
     * @param C Output matrix
     */
    public static void sub(Matrix A, Matrix B, Matrix C) {
        if (A.rows != B.rows && A.cols != B.cols && A.rows!=C.rows && A.cols!=C.cols) {
            throw new RuntimeException("Faulty addition, matrixes were not of same shape.");
        }
        for(int i=0;i<A.rows*A.cols;i++){
            C.data[i]=A.data[i]-B.data[i];
        }
    }

    /**
     * Returns true iff that is a Matrix that corresponds in shape to this and
     * all elements of this and that compare equal.
     * 
     * @param that The right hand side operand
     */
    @Override
    public boolean equals(Object that) {
        if (!(that instanceof Matrix))
            return false;
        Matrix M = (Matrix) that;
        if (cols != M.cols)
            return false;
        if (rows != M.rows)
            return false;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (data[start + i * stride + j] != M.data[M.start + i * M.stride + j])
                    return false;
            }
        }
        return true;
    }
}