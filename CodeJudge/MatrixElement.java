package CodeJudge;

import java.util.ArrayList;
import java.util.Scanner;

class MatrixElement {

    static String order;
    static int n;
    static int m;
    static int p;

    // public static void main(String[] args) {

    // Scanner sc = new Scanner(System.in);

    // n = sc.nextInt();
    // m = sc.nextInt();
    // order = sc.nextLine().trim();
    // String[] stringMatrix = sc.nextLine().split(" ");
    // matrix = new int[stringMatrix.length];

    // for (int i = 0; i < stringMatrix.length; i++) {
    // matrix[i] = Integer.parseInt(stringMatrix[i]);

    // }

    // ArrayList<Integer> toPrint = new ArrayList<>();

    // while (sc.hasNextLine()) {

    // int x = sc.nextInt();
    // int y = sc.nextInt();
    // toPrint.add(getValue(x, y));

    // try {
    // sc.nextLine();
    // } catch (Exception e) {
    // break;
    // }

    // }

    // toPrint.stream().forEach(s -> System.out.println(s));

    // }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        p = sc.nextInt();
        order = sc.next();

        int[] A = new int[n * m];
        int[] B = new int[m * p];

        for (int i = 0; i < n * m; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < m * p; i++) {
            B[i] = sc.nextInt();
        }
        int[] C = multiply(A, B);
        for (int i : C) {
            System.out.println(i);
        }
    }

    public static int getValue(int[] matrix, int x, int y) {

        if (order.equals("C")) {

            return matrix[(x) * m + (y)];
        }
        return matrix[y * n + x];

    }

    public static void setValue(int[] matrix, int x, int y, int val) {

        if (order.equals("C")) {

            matrix[(x) * m + (y)] = val;
        }
        matrix[y * n + x] = val;

    }

    static int[] multiply(int[] A, int[] B) {
        int[] C = new int[n * p];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < m; k++) {
                    setValue(C, i, j, getValue(C, i, j) + getValue(A, i, k) * getValue(B, k, j));
                }
            }
        }
        return C;
    }

}