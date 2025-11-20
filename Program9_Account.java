// Program 9: Write a program in Java to design accounts class and two functions withdraw() and deposit()
import java.util.Scanner;

class Account {
    private double balance;
    
    public Account(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
            System.out.println("Initial balance cannot be negative. Setting balance to 0.");
        }
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: Rs. " + amount);
            System.out.println("New balance: Rs. " + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawn: Rs. " + amount);
                System.out.println("New balance: Rs. " + balance);
            } else {
                System.out.println("Insufficient balance! Current balance: Rs. " + balance);
            }
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }
    
    public double getBalance() {
        return balance;
    }
}

public class Program9_Account {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter initial balance: ");
        double initialBalance = sc.nextDouble();
        
        Account account = new Account(initialBalance);
        
        int choice;
        do {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current balance: Rs. " + account.getBalance());
                    break;
                case 4:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
        
        sc.close();
    }
}

