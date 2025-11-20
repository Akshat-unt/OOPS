// Program 14: Write a program in Java to handle the Exception using try and multiple catch block
import java.util.Scanner;

public class Program14_ExceptionHandling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.print("Enter first number: ");
            int num1 = Integer.parseInt(sc.nextLine());
            
            System.out.print("Enter second number: ");
            int num2 = Integer.parseInt(sc.nextLine());
            
            System.out.print("Enter array size: ");
            int size = Integer.parseInt(sc.nextLine());
            int[] arr = new int[size];
            
            System.out.print("Enter index to access array: ");
            int index = Integer.parseInt(sc.nextLine());
            
            System.out.print("Enter value to store at index: ");
            arr[index] = Integer.parseInt(sc.nextLine());
            
            int result = num1 / num2;
            System.out.println("Division result: " + result);
            System.out.println("Array value at index " + index + ": " + arr[index]);
            
        } catch (NumberFormatException e) {
            System.out.println("Exception caught: NumberFormatException - Invalid number format!");
            System.out.println("Message: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: ArithmeticException - Division by zero!");
            System.out.println("Message: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught: ArrayIndexOutOfBoundsException - Invalid array index!");
            System.out.println("Message: " + e.getMessage());
        } catch (NegativeArraySizeException e) {
            System.out.println("Exception caught: NegativeArraySizeException - Array size cannot be negative!");
            System.out.println("Message: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception caught: General Exception!");
            System.out.println("Message: " + e.getMessage());
        } finally {
            System.out.println("\nFinally block executed - cleanup code here");
            sc.close();
        }
        
        System.out.println("Program continues after exception handling...");
    }
}

