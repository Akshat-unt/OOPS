// Program 4: Write a program in Java to design simple calculator for (+, -, *, and /) using switch case
import java.util.Scanner;

public class Program4_Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();
        
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();
        
        System.out.print("Enter operator (+, -, *, /): ");
        char operator = sc.next().charAt(0);
        
        double result = 0;
        
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Division by zero!");
                    sc.close();
                    return;
                }
                break;
            default:
                System.out.println("Invalid operator!");
                sc.close();
                return;
        }
        
        System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
        
        sc.close();
    }
}

