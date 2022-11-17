package CodeJudge;

import java.util.Scanner;

public class AMain {
    

    public static void main(String[] args) {

        Matrix A = new Matrix(6, 6, new double[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36});
        System.out.println(A.toString());
        
        int n=A.rows;
        Matrix subA1 = A.view(0, 0, n/2, n/2);
        System.out.println(subA1.toString());
        n= subA1.rows;
        Matrix subA12 = subA1.view(0, 0, n/2, n/2);
        System.out.println(subA12.toString());
        Matrix subA13 = subA1.view(n/2+1, 0, n/2, n/2);
        System.out.println(subA13.toString());




        
        // System.out.println(A.view(0, 0, n/2, n/2).toString());
        // System.out.println();
        // System.out.println(A.view(n/2, 0, n/2, n/2).toString());
        // System.out.println();
        // System.out.println(A.view(0, n/2, n/2, n/2).toString());
        // System.out.println();
        // System.out.println(A.view(n/2, n/2, n/2, n/2).toString());

      
    }
}
