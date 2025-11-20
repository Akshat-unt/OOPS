// Program 20: Write a program to connect to a database using JDBC and insert values into it
import java.sql.*;
import java.util.Scanner;

public class Program20_JDBC_Insert {
    // Database connection parameters - Update these according to your database
    static final String DB_URL = "jdbc:mysql://localhost:3306/studentdb";
    static final String USER = "root";
    static final String PASS = "password";
    static final String TABLE_NAME = "students"; // Change table name as per your database
    
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        Scanner sc = new Scanner(System.in);
        
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // Get input from user
            System.out.print("Enter student ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline
            
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            
            System.out.print("Enter student age: ");
            int age = sc.nextInt();
            sc.nextLine();
            
            System.out.print("Enter student course: ");
            String course = sc.nextLine();
            
            // Prepare insert statement
            String sql = "INSERT INTO " + TABLE_NAME + " (id, name, age, course) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            
            // Set parameters
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            pstmt.setString(4, course);
            
            // Execute insert
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("\nRecord inserted successfully!");
                System.out.println("Rows affected: " + rowsAffected);
            } else {
                System.out.println("\nNo record inserted.");
            }
            
        } catch (SQLException se) {
            System.out.println("SQL Exception occurred:");
            se.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception occurred:");
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
                if (sc != null) sc.close();
                System.out.println("\nConnection closed.");
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}

