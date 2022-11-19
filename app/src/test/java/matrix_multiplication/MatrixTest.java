package matrix_multiplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MatrixTest {
    
    private static Matrix m2;
    private static Matrix m4;
    private static Matrix m6;

    @Before
    public void init(){
        Matrix m2 = new Matrix(2, 2, new double[] { 1, 2, 3, 4});

        Matrix m4 = new Matrix(4, 4, new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16});

        Matrix m6 = new Matrix(6, 6, new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19,
            20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36 });

    }

    @Test
    public void isEqualTest(){
        Matrix m2Copy = m2.copy();
        
    }
}
