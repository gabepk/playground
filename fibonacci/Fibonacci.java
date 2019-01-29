package fibonacci;

public class Fibonacci {

    public static void main(String[] args) {

        try {
            int index = Integer.valueOf(args[0]);
            System.out.println( "findFibonacci(" + args[0] + ") = " + findFibonacciRecursion(index) );
        } catch (NumberFormatException e) {
            System.out.println("Integer expected");
        }

    }

    public static int findFibonacciRecursionAux(int a, int b) {
        return 0;
    }

    public static int findFibonacciRecursion(int maxIndex) {
        if (maxIndex < 1) return 0;
        if (maxIndex < 3) return 1;

        int result = 1;
        for(int i = 1; i < maxIndex; i++) {
            //findFibonacciRecursionAux(result, )
        }
        return 0;
    }

    public static int findFibonacciReduce(int index) {
        return 0;
    }

    public static int findFibonacciDynamicProgramming(int index) {
        return 0;
    }
}