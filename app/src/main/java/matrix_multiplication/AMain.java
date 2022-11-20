package matrix_multiplication;

public class AMain {

    public static void main(String[] args) {

        // Matrix A = new Matrix(8, 8, new double[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
        // 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
        // 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47,
        // 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64 });
        // System.out.println(A.toString());

        Matrix A = new Matrix(4, 4, new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
                12, 13, 14, 15, 16 });

        Matrix t1 = Matrix.elementaryMultiplication(A, A);
        Matrix t2 = Matrix.elementaryMultiplicationTransposed(A, A, 3);
        Matrix t3 = Matrix.tiledMultiplication(A, A, 2);
        System.out.println(t1.equals(t2));
        System.out.println(t1.equals(t3));

        System.out.println(t1.toString());
        System.out.println();

        System.out.println(t2.toString());
        System.out.println();

        System.out.println(t3.toString());
        System.out.println();

        // System.out.println(A.view(0, 0, n / 2, n / 2).toString());
        // System.out.println();
        // System.out.println(A.view(n / 2, 0, n / 2, n / 2).toString());
        // System.out.println();
        // System.out.println(A.view(0, n / 2, n / 2, n / 2).toString());
        // System.out.println();
        // System.out.println(A.view(n / 2, n / 2, n / 2, n / 2).toString());

    }
}
