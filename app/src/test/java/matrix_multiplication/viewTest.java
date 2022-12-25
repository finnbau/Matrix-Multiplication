package matrix_multiplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.Test;

public class viewTest {

    private static Matrix m8;


    @Before
    public void init() {


        m8 = new Matrix(8, 8, new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
                22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47,
                48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64 });


    }

    @Test
    public void view_quarter_test() {
        Matrix actual= m8.view(0,0,m8.cols/2,m8.cols/2);

        Matrix expected = new Matrix(4, 4, new double[]{1,2,3,4,9,10,11,12,17,18,19,20,25,26,27,28});
        assertEquals(expected, actual);
    }
    @Test
    public void view_quarter_test_wrong() {
        Matrix actual= m8.view(0,0,m8.cols/2,m8.cols/2);

        Matrix expected = new Matrix(4, 4, new double[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
        assertNotEquals(expected, actual);
    }

    @Test
    public void view_of_view_test() {
        Matrix firstView = m8.view(0,0,m8.cols/2,m8.cols/2);

        Matrix actual = firstView.view(2,2,firstView.cols/2,firstView.cols/2);
        Matrix expected = new Matrix(2, 2, new double[]{19,20,27,28});
        assertEquals(expected, actual);
    }
    @Test
    public void view_of_view_test_wrong() {
        Matrix firstView = m8.view(0,0,m8.cols/2,m8.cols/2);

        Matrix actual = firstView.view(2,2,firstView.cols/2,firstView.cols/2);
        Matrix expected = new Matrix(2, 2, new double[]{1,1,1,1});
        assertNotEquals(expected, actual);
    }


}
