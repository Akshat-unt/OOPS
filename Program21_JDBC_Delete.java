// Program 21: Write a java program to connect to a database using JDBC and delete values from table
import java.sql.*;
import java.util.Scanner;

public class Program21_JDBC_Delete {
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
            
            // Display current records
            System.out.println("\nCurrent records in " + TABLE_NAME + " table:");
            displayRecords(conn);
            
            // Get input from user
            System.out.print("\nEnter student ID to delete: ");
            int id = sc.nextInt();
            
            // Prepare delete statement
            String sql = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            
            // Execute delete
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("\nRecord deleted successfully!");
                System.out.println("Rows affected: " + rowsAffected);
                
                // Display updated records
                System.out.println("\nUpdated records:");
                displayRecords(conn);
            } else {
                System.out.println("\nNo record found with ID: " + id);
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
    
    // Helper method to display records
    private static void displayRecords(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM students");
        
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        
        // Print column headers
        for (int i = 1; i <= columnCount; i++) {
            System.out.print(metaData.getColumnName(i) + "\t");
        }
        System.out.println();
        System.out.println("---------------------------------------------------");
        
        // Print rows
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }
        
        rs.close();
        stmt.close();
    }
}

