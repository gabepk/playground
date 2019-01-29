package fibonacci;

public class Fibonacci {

    public static long[] arrFib;

    public static void main(String[] args) {

        try {
            int maxIndex = Integer.valueOf(args[0]);

            arrFib = new long[maxIndex + 1];

            //System.out.println( "findFibonacciRecursion(" + maxIndex + ") = " + 
                //findFibonacciRecursion(maxIndex) );

            System.out.println( "findFibonacciDynamicProgramming(" + maxIndex + ") = " + 
                findFibonacciDynamicProgramming(maxIndex) );
        } catch (NumberFormatException e) {
            System.out.println("Integer expected");
        }

    }

    public static long findFibonacciRecursion(int maxIndex) {
        if (maxIndex < 0) return 0;
        if (maxIndex < 2) return 1;

        return findFibonacciRecursion(maxIndex - 1) + 
            findFibonacciRecursion(maxIndex - 2);
    }

    public static long findFibonacciDynamicProgramming(int maxIndex) {
        // Verifica se valor ja foi armazenado
        if (arrFib[maxIndex] > 0) {
            return arrFib[maxIndex];
        }
        
        if (maxIndex <= 0) {
            return 0;
        } else if (maxIndex < 3) {
            arrFib[maxIndex] = 1;
        } else {
            long a = findFibonacciDynamicProgramming(maxIndex - 1);
            long b = findFibonacciDynamicProgramming(maxIndex - 2);
            arrFib[maxIndex] = a + b;
        }

        return arrFib[maxIndex];
    }
}