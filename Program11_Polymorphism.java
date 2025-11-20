// Program 11: Write a program in Java to the concept of polymorphism by designing functions to sum different type of numbers
public class Program11_Polymorphism {
    // Method overloading - compile-time polymorphism
    public static int sum(int a, int b) {
        System.out.println("Sum of two integers:");
        return a + b;
    }
    
    public static int sum(int a, int b, int c) {
        System.out.println("Sum of three integers:");
        return a + b + c;
    }
    
    public static double sum(double a, double b) {
        System.out.println("Sum of two doubles:");
        return a + b;
    }
    
    public static double sum(double a, double b, double c) {
        System.out.println("Sum of three doubles:");
        return a + b + c;
    }
    
    public static float sum(float a, float b) {
        System.out.println("Sum of two floats:");
        return a + b;
    }
    
    public static void main(String[] args) {
        System.out.println("Demonstrating Polymorphism (Method Overloading)\n");
        
        // Sum of integers
        System.out.println(sum(10, 20));
        System.out.println();
        
        // Sum of three integers
        System.out.println(sum(10, 20, 30));
        System.out.println();
        
        // Sum of doubles
        System.out.println(sum(10.5, 20.7));
        System.out.println();
        
        // Sum of three doubles
        System.out.println(sum(10.5, 20.7, 30.3));
        System.out.println();
        
        // Sum of floats
        System.out.println(sum(15.5f, 25.3f));
    }
}

