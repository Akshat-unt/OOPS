// Program 7: Write a java program to find the Fibonacci series using recursive and non-recursive functions
import java.util.Scanner;

public class Program7_Fibonacci {
    // Non-recursive function
    public static void fibonacciNonRecursive(int n) {
        int first = 0, second = 1;
        System.out.print("Fibonacci series (Non-recursive): ");
        if (n >= 1) {
            System.out.print(first);
        }
        if (n >= 2) {
            System.out.print(" " + second);
        }
        for (int i = 3; i <= n; i++) {
            int next = first + second;
            System.out.print(" " + next);
            first = second;
            second = next;
        }
        System.out.println();
    }
    
    // Recursive function to find nth Fibonacci number
    public static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of terms: ");
        int n = sc.nextInt();
        
        // Non-recursive approach
        fibonacciNonRecursive(n);
        
        // Recursive approach
        System.out.print("Fibonacci series (Recursive): ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciRecursive(i) + " ");
        }
        System.out.println();
        
        sc.close();
    }
}

