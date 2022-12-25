package matrix_multiplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.Test;

public class transposeRecTest {

    private static Matrix m2;
    private static Matrix m2trans;
    private static Matrix m2trans_wrong;
    private static Matrix m4;
    private static Matrix m4trans;
    private static Matrix m4trans_wrong;
    private static Matrix m6;
    private static Matrix m6trans;
    private static Matrix m8;
    private static Matrix m8trans;
    private static Matrix m8trans_wrong;
    private static Matrix m16;
    private static Matrix m16trans;
    private static Matrix m16trans_wrong;

    @Before
    public void init() {
        m2 = new Matrix(2, 2, new double[] { 1, 2, 3, 4 });
        m2trans = new Matrix(2, 2, new double[] {1, 3, 2,4 });
        m2trans_wrong = new Matrix(2, 2, new double[] { 1, 1, 1, 1 });

        m4 = new Matrix(4, 4, new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 });
        m4trans = new Matrix(4, 4,
                new double[] {1, 5, 9, 13,2, 6, 10, 14,3, 7, 11, 15,4, 8, 12, 16});
        m4trans_wrong = new Matrix(4, 4,
                new double[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});

        m8 = new Matrix(8, 8, new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
                22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47,
                48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64 });
        m8trans = new Matrix(8, 8,
                new double[] { 1, 9, 17, 25, 33, 41, 49, 57,
                    2, 10, 18, 26, 34, 42, 50, 58,
                    3, 11, 19, 27, 35, 43, 51, 59,
                    4, 12, 20, 28, 36, 44, 52, 60,
                    5, 13, 21, 29, 37, 45, 53, 61,
                    6, 14, 22, 30, 38, 46, 54, 62,
                    7, 15, 23, 31, 39, 47, 55, 63,
                    8, 16, 24, 32, 40, 48, 56, 64 });
        m8trans_wrong = new Matrix(8, 8,
            new double[] { 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1 });

        m6 = new Matrix(6, 6, new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
                22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36});
        m6trans = new Matrix(6, 6, new double[] {1.0, 7.0, 13.0, 19.0, 25.0, 31.0, 2.0, 8.0, 14.0, 20.0, 26.0, 32.0, 3.0,
            9.0, 15.0, 21.0, 27.0, 33.0, 4.0, 10.0, 16.0, 22.0, 28.0, 34.0, 5.0, 11.0, 17.0, 23.0, 29.0, 35.0, 6.0, 12.0, 18.0, 24.0, 30.0, 36.0});

        m16 = new Matrix(16, 16, new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21,
                22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47,
                48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73,
                74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99,
                100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120,
                121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141,
                142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162,
                163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183,
                184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204,
                205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225,
                226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246,
                247, 248, 249, 250, 251, 252, 253, 254, 255, 256 });
        m16trans= new Matrix(16, 16, new double[] {1.0, 17.0, 33.0, 49.0, 65.0, 81.0, 97.0, 113.0, 129.0, 145.0, 161.0, 177.0,
            193.0, 209.0, 225.0, 241.0, 2.0, 18.0, 34.0, 50.0, 66.0, 82.0, 98.0, 114.0, 130.0, 146.0, 162.0, 178.0, 194.0, 210.0,
            226.0, 242.0, 3.0, 19.0, 35.0, 51.0, 67.0, 83.0, 99.0, 115.0, 131.0, 147.0, 163.0, 179.0, 195.0, 211.0, 227.0, 243.0,
            4.0, 20.0, 36.0, 52.0, 68.0, 84.0, 100.0, 116.0, 132.0, 148.0, 164.0, 180.0, 196.0, 212.0, 228.0, 244.0, 5.0, 21.0, 37.0,
            53.0, 69.0, 85.0, 101.0, 117.0, 133.0, 149.0, 165.0, 181.0, 197.0, 213.0, 229.0, 245.0, 6.0, 22.0, 38.0, 54.0, 70.0, 86.0,
            102.0, 118.0, 134.0, 150.0, 166.0, 182.0, 198.0, 214.0, 230.0, 246.0, 7.0, 23.0, 39.0, 55.0, 71.0, 87.0, 103.0, 119.0, 135.0,
            151.0, 167.0, 183.0, 199.0, 215.0, 231.0, 247.0, 8.0, 24.0, 40.0, 56.0, 72.0, 88.0, 104.0, 120.0, 136.0, 152.0, 168.0, 184.0,
            200.0, 216.0, 232.0, 248.0, 9.0, 25.0, 41.0, 57.0, 73.0, 89.0, 105.0, 121.0, 137.0, 153.0, 169.0, 185.0, 201.0, 217.0, 233.0,
            249.0, 10.0, 26.0, 42.0, 58.0, 74.0, 90.0, 106.0, 122.0, 138.0, 154.0, 170.0, 186.0, 202.0, 218.0, 234.0, 250.0, 11.0, 27.0,
            43.0, 59.0, 75.0, 91.0, 107.0, 123.0, 139.0, 155.0, 171.0, 187.0, 203.0, 219.0, 235.0, 251.0, 12.0, 28.0, 44.0, 60.0, 76.0, 92.0,
            108.0, 124.0, 140.0, 156.0, 172.0, 188.0, 204.0, 220.0, 236.0, 252.0, 13.0, 29.0, 45.0, 61.0, 77.0, 93.0, 109.0, 125.0, 141.0, 157.0,
            173.0, 189.0, 205.0, 221.0, 237.0, 253.0, 14.0, 30.0, 46.0, 62.0, 78.0, 94.0, 110.0, 126.0, 142.0, 158.0, 174.0, 190.0, 206.0,
            222.0, 238.0, 254.0, 15.0, 31.0, 47.0, 63.0, 79.0, 95.0, 111.0, 127.0, 143.0, 159.0, 175.0, 191.0, 207.0, 223.0, 239.0, 255.0,
            16.0, 32.0, 48.0, 64.0, 80.0, 96.0, 112.0, 128.0, 144.0, 160.0, 176.0, 192.0, 208.0, 224.0, 240.0, 256.0,});

        m16trans_wrong = new Matrix(16, 16, new double[] { 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
            1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1
        });

    }

    @Test
    public void transposeTest_m2() {
        Matrix actual = new Matrix(m2.cols,m2.cols);
        Matrix.transposeRec(m2,actual,2);
        Matrix expected = m2trans;
        assertEquals(expected, actual);
    }
    @Test
    public void transposeTest_m2_wrong() {
        Matrix actual = new Matrix(m2.cols,m2.cols);
        Matrix.transposeRec(m2,actual,2);
        Matrix expected = m2trans_wrong;
        assertNotEquals(expected, actual);
    }

    @Test
    public void transposeTest_m4() {
        Matrix actual = new Matrix(m4.cols,m4.cols);
        Matrix.transposeRec(m4,actual,2);
        Matrix expected = m4trans;
        assertEquals(expected, actual);
    }
    @Test
    public void transposeTest_m4_wrong() {
        Matrix actual = new Matrix(m4.cols,m4.cols);
        Matrix.transposeRec(m4,actual,2);
        Matrix expected = m4trans_wrong;
        assertNotEquals(expected, actual);
    }

    /*This test shows that the recursive method, in our implementation, does not work
     * if n is not in the doubling sequence.
     */
    @Test
    public void transposeTest_m6() {
        Matrix actual = new Matrix(m6.cols,m6.cols);
        Matrix.transposeRec(m6,actual,2);
        Matrix expected = m6trans;
        assertNotEquals(expected, actual);
    }

    @Test
    public void transposeTest_m8() {
        Matrix actual = new Matrix(m8.cols,m8.cols);
        Matrix.transposeRec(m8,actual,2);
        Matrix expected = m8trans;
        assertEquals(expected, actual);
    }
    @Test
    public void transposeTest_m8_wrong() {
        Matrix actual = new Matrix(m8.cols,m8.cols);
        Matrix.transposeRec(m8,actual,2);
        Matrix expected = m8trans_wrong;
        assertNotEquals(expected, actual);
    }

    @Test
    public void transposeTest_m16() {
        Matrix actual = new Matrix(m16.cols,m16.cols);
        Matrix.transposeRec(m16,actual,2);
        Matrix expected = m16trans;
        assertEquals(expected, actual);
    }
    @Test
    public void transposeTest_m16_wrong() {
        Matrix actual = new Matrix(m16.cols,m16.cols);
        Matrix.transposeRec(m16,actual,2);
        Matrix expected = m16trans_wrong;
        assertNotEquals(expected, actual);
    }

}