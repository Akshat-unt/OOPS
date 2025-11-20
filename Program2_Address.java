// Program 2: WAP to print your address i) using single print ii) using multiple println
import java.util.Scanner;

public class Program2_Address {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter your address:");
        String address = sc.nextLine();
        
        // Using single print
        System.out.print("\nUsing single print:\n");
        System.out.print(address);
        
        // Using multiple println
        System.out.println("\n\nUsing multiple println:");
        String[] addressLines = address.split(",");
        for (String line : addressLines) {
            System.out.println(line.trim());
        }
        
        sc.close();
    }
}

