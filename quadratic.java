import java.util.Scanner;

public class Quad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter coefficient a: ");
        double a = scanner.nextDouble();
        
        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();
        
        System.out.print("Enter coefficient c: ");
        double c = scanner.nextDouble();
        
        double d = b * b - 4 * a * c;
        
        if (d > 0) {
            double root1 = (-b + Math.sqrt(d)) / (2 * a);
            double root2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.printf("Roots are real and different.\nRoot 1: %.2f\nRoot 2: %.2f\n", root1, root2);
        } else if (d == 0) {
            double root = -b / (2 * a);
            System.out.printf("Roots are real and the same.\nRoot: %.2f\n", root);
        } else {
            System.out.println("There are no real solutions.");
        }
        
        scanner.close();
    }
}
