import java.util.Scanner;

public class str1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        int vowels = 0, consonants = 0;
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                if ("AEIOUaeiou".contains(String.valueOf(c))) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}
