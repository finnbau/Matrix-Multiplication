package matrix_multiplication;

public class MainTests {
    public static void main(String[] args) {
        Matrix t = new Matrix(2, 2,new double[]{1,2,3,4});
        Matrix  r = Matrix.elementaryMultiplication(t, t);
        System.out.println(r.toString());
        Matrix rView = r.view(r.start, r.start, 1, 1);
        System.out.println(rView.data[rView.start]);
    }
}
