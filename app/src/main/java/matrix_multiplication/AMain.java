package matrix_multiplication;

public class AMain {

    public static void main(String[] args) {


        Matrix m16 = new Matrix(16, 16, new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
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

        Matrix m16Transposed = m16.transpose(m16);

        for(double e:m16Transposed.data){
            System.out.print(e+", ");
        }
        // Matrix A = new Matrix(8, 8, new double[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
        // 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
        // 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47,
        // 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64 });

        // Matrix A = new Matrix(4, 4, new double[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
        //     12, 13, 14, 15, 16 });
        
        // System.out.println(A.toString());
        // System.out.println("---------");
        // Matrix view = A.view(0, 0, A.cols/2, A.cols/2);
        // System.out.println(view.toString());
        // System.out.println("---------");

        // Matrix B = new Matrix(4,4);
        // Matrix.transposeRec(A, B, 2);
        // Matrix C = new Matrix(4,4);
        // Matrix.transpose(A,C);
        // System.out.println(B.toString());
        // System.out.println("--------");
        // System.out.println(C.toString());
        // System.out.println("-------");
        // System.out.println(B.equals(C));

        // Matrix B = A.view(0, 0, A.cols/2, A.cols/2);
        // Matrix C = A.view(A.two, A.two, A.cols/2, A.cols/2);
        // System.out.println(B);
        // System.out.println("----------");
        // System.out.println(C);
        // Matrix D = C.view(2, 2, 2, 2);
        // System.out.println("------");
        // System.out.println(D.toString());

        // Matrix A = new Matrix(4, 4, new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
        //         12, 13, 14, 15, 16 });
        // Matrix A = new Matrix(2, 2, new double[] { 1, 2, 3, 4});

        // Matrix resStrassen = new Matrix(8,8);
        // Matrix.strassen(A, A,resStrassen,1);
        // Matrix t1 = Matrix.elementaryMultiplication(A, A);
        // Matrix res = new Matrix(8, 8);
        // Matrix.recursiveMultiplication(A, A, res, 1);

        // System.out.println(t1.toString());
        // System.out.println("############");
        // System.out.println(res.toString());
        // System.out.println(t1.equals(res));
        // System.out.println(t1.equals(resStrassen));

        // System.out.println(A.view(0, 0, n / 2, n / 2).toString());
        // System.out.println();
        // System.out.println(A.view(n / 2, 0, n / 2, n / 2).toString());
        // System.out.println();
        // System.out.println(A.view(0, n / 2, n / 2, n / 2).toString());
        // System.out.println();
        // System.out.println(A.view(n / 2, n / 2, n / 2, n / 2).toString());

    }
}
