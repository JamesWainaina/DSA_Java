// implement a factorial of a number using iterative approach

public class factorial {
    // iterative approach
    static int factorial(int n){
        int res = 1, i;
        for ( i = 2; i <= n; i++){
            res *= i;
        }
        return res;
        // time complexity 0{n}
        // space complexity 0(1)
    }

    // Recursive approach
    static int factorialrecurse(int n){
        if (n == 0) {
            return 1;
        }

        return n * factorialrecurse(n-1);
        // time complexity 0{n}
        // space complexity 0(n)
    }
    
    public static void main(String[] args) {
        int num = 5;
        System.out.println("Factorial of " + num + " is "
                + factorial(5));
    }
}




// using the recurviv