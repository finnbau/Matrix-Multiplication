package matrix_multiplication;

public class Main {
    public static void main(String[] args) {

        /*NOTES ON THE STRUCTURE OF THE MAIN METHOD:
         * 1. args[0] is where we determine which algorithm should be run.
         * 2. args[1] is n, the length/width of the n*n matrix
         * 3. args[2] is, if it is needed, s, which alters the functioning of multiplication algorithms.
         * 4. By default all matrix cells are filled with 2.
         *    This is arbitrary and 2 was chosen because it shows a multiplication happend.
         */
        
        //Taking in arguments
        String algoCmd = args[0];
        int n = Integer.parseInt(args[1]);
        int s;
        if(args.length==3){s = Integer.parseInt(args[2]);}
        else{s = 1;} //Default s if none is given. Should never be used.

        /* Initialize the matrixes. 
         * They are all n*n, A and B are identical, while C is empty.
        */
        Matrix A = new Matrix(n, n);
        A.setAll(2.0);
        Matrix B = new Matrix(n, n);
        B.setAll(2.0);
        Matrix C = new Matrix(n, n);

        /*Elementary multiplication. */
        if(algoCmd.equals("elementary_multiplication")){
            long start = System.nanoTime();
            Matrix.elementaryMultiplication(A, B, C);
            long end = System.nanoTime();
            System.out.println(end-start);
        }//Elementary multiplication.


        /*Task 4: Finding the suitable block size, s, for recursive transpose. */
        else if(algoCmd.equals("rec_trans")){
            long start = System.nanoTime();
            Matrix.transposeRec(A, C, s);
            long end = System.nanoTime();
            System.out.println(end-start);
        }//End of Task 4.

        /*Transposed Matrix Multiplication */
        else if(algoCmd.equals("transposed_multiplication")){
            long start = System.nanoTime();
            Matrix.elementaryMultiplicationTransposed(A, B, C, s);
            long end = System.nanoTime();
            System.out.println(end-start);
        }//End Transposed Matrix Multiplication.

        /*Tiled Matrix Multiplication */
        else if(algoCmd.equals("tiled_multiplication")){
            long start = System.nanoTime();
            Matrix.tiledMultiplication(A, B, C, s);
            long end = System.nanoTime();
            System.out.println(end-start);
        }//End Transposed Matrix Multiplication.

        /*Recursive Matrix Multiplication */
        else if(algoCmd.equals("recursive_multiplication")){
            long start = System.nanoTime();
            Matrix.recursiveMultiplication(A, B, C, s);
            long end = System.nanoTime();
            System.out.println(end-start);
        }//End Recursive Matrix Multiplication.

        /*Strassen Matrix Multiplication */
        else if(algoCmd.equals("strassen_multiplication")){
            long start = System.nanoTime();
            Matrix.strassen(A, B, C, s);
            long end = System.nanoTime();
            System.out.println(end-start);
        }//End Strassen Matrix Multiplication.

        else{System.out.println("Something went wrong, check the runtime arguments...");}
    }
}
