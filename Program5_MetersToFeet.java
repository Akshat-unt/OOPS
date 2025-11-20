// Program 5: WAP that reads a number in meters converts it to feet and displays the result
import java.util.Scanner;

public class Program5_MetersToFeet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter distance in meters: ");
        double meters = sc.nextDouble();
        
        // 1 meter = 3.28084 feet
        double feet = meters * 3.28084;
        
        System.out.println(meters + " meters = " + feet + " feet");
        
        sc.close();
    }
}

