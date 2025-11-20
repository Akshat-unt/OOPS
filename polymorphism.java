// Write a program in Java to the concept of polymorphism by designing functions to sum different type of numbers
public class Polymorphism {

    // Method to sum two integers
    public int sum(int a, int b) {
        return a + b;
    }

    // Method to sum three integers
    public int sum(int a, int b, int c) {
        return a + b + c;
    }

    // Method to sum two double values
    public double sum(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        Polymorphism poly = new Polymorphism();
        
        System.out.println("Sum of two integers: " + poly.sum(5, 10));
        System.out.println("Sum of three integers: " + poly.sum(5, 10, 15));
        System.out.println("Sum of two doubles: " + poly.sum(5.5, 10.5));
    }
}
