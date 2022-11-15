package CodeJudge;

import java.util.ArrayList;
import java.util.Scanner;

class MatrixElement {

    static int[] matrix;
    static String order;
    static int n;
    static int m;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        order = sc.nextLine().trim();
        String[] stringMatrix = sc.nextLine().split(" ");
        matrix = new int[stringMatrix.length];

        for (int i = 0; i < stringMatrix.length; i++) {
            matrix[i] = Integer.parseInt(stringMatrix[i]);

        }

        ArrayList<Integer> toPrint = new ArrayList<>();

        while (sc.hasNextLine()) {

            int x = sc.nextInt();
            int y = sc.nextInt();
            toPrint.add(getValue(x, y));

            try {
                sc.nextLine();
            } catch (Exception e) {
                break;
            }

        }

        toPrint.stream().forEach(s -> System.out.println(s));

    }

    public static int getValue(int x, int y) {

        if (order.equals("C")) {
            int index = (x) * m + (y);
            return matrix[index];
        }
        return matrix[y * n + x];

    }

}