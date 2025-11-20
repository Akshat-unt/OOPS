// Program 6: Write a Java program that prints all real solutions to the quadratic equation
// ax^2+bx+c = 0. Read in a, b, c and use the quadratic formula.
import java.util.Scanner;

public class Program6_QuadraticEquation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Quadratic Equation: ax^2 + bx + c = 0");
        System.out.print("Enter value of a: ");
        double a = sc.nextDouble();
        
        System.out.print("Enter value of b: ");
        double b = sc.nextDouble();
        
        System.out.print("Enter value of c: ");
        double c = sc.nextDouble();
        
        // Calculate discriminant: b^2 - 4ac
        double discriminant = (b * b) - (4 * a * c);
        
        if (discriminant < 0) {
            System.out.println("There are no real solutions (discriminant is negative).");
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println("One real solution: x = " + root);
        } else {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("Two real solutions:");
            System.out.println("x1 = " + root1);
            System.out.println("x2 = " + root2);
        }
        
        sc.close();
    }
}

