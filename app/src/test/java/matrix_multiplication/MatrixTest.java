package matrix_multiplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import matrix.multiplication.Matrix;

public class MatrixTest {

    private static Matrix m2;
    private static Matrix m2trans;

    private static Matrix m4;
    private static Matrix m4trans;

    private static Matrix m6;
    private static Matrix m6trans;

    private static Matrix m8;
    private static Matrix m8trans;

    @Before
    public void init() {
        m2 = new Matrix(2, 2, new double[] { 1, 2, 3, 4 });
        m2trans = new Matrix(2, 2, new double[] { 1, 3, 2, 4 });

        m4 = new Matrix(4, 4, new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 });
        m4trans = new Matrix(4, 4, new double[] { 1, 5, 9, 13, 2, 6, 10, 14, 3, 7, 11, 15, 4, 8, 12, 16 });

        m6 = new Matrix(6, 6, new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
                20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36 });
        m6trans = new Matrix(6, 6,
                new double[] { 1, 7, 13, 19, 25, 31, 2, 8, 14, 20, 26, 32, 3, 9, 15, 21, 27, 33, 4, 10,
                        16, 22, 28, 34, 5, 11, 17, 23, 29, 35, 6, 12, 18, 24, 30, 36 });

        m8 = new Matrix(8, 8, new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
                22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47,
                48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64 });
        m8trans = new Matrix(8, 8, new double[] { 1, 9, 17, 25, 33, 41, 49, 57, 2, 10, 18, 26, 34, 42, 50, 58, 3, 11,
                19, 27, 35, 43, 51, 59, 4, 12, 20, 28, 36, 44, 52, 60, 5, 13, 21, 29, 37, 45, 53, 61, 6, 14, 22, 30, 38,
                46, 54, 62, 7, 15, 23, 31, 39, 47, 55, 63, 8, 16, 24, 32, 40, 48, 56, 64 });

    }

    @Test
    public void transposeTest_m2() {
        Matrix actual = Matrix.transpose(m2);
        Matrix expected = m2trans;
        assertEquals(actual, expected);
    }

    @Test
    public void transposeTest_m4() {
        Matrix actual = Matrix.transpose(m4);
        Matrix expected = m4trans;
        assertEquals(actual, expected);
    }

    @Test
    public void transposeTest_m6() {
        Matrix actual = Matrix.transpose(m6);
        Matrix expected = m6trans;
        assertEquals(actual, expected);
    }

    @Test
    public void transposeTest_m8() {
        Matrix actual = Matrix.transpose(m8);
        Matrix expected = m8trans;
        assertEquals(actual, expected);
    }
}
