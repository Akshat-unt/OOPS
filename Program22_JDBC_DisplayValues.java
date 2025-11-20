// Program 22: Write a program that connects to a database using JDBC display all values
import java.sql.*;

public class Program22_JDBC_DisplayValues {
    // Database connection parameters - Update these according to your database
    static final String DB_URL = "jdbc:mysql://localhost:3306/studentdb";
    static final String USER = "root";
    static final String PASS = "password";
    static final String TABLE_NAME = "students"; // Change table name as per your database
    
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "SELECT * FROM " + TABLE_NAME;
            rs = stmt.executeQuery(sql);
            
            // Extract data from result set
            System.out.println("\nDisplaying all values from " + TABLE_NAME + " table:\n");
            
            // Get metadata
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            
            // Print column headers with formatting
            System.out.println("+--------+------------------+------+----------------------+");
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("| %-15s ", metaData.getColumnName(i));
            }
            System.out.println("|");
            System.out.println("+--------+------------------+------+----------------------+");
            
            // Print rows
            int rowCount = 0;
            while (rs.next()) {
                rowCount++;
                for (int i = 1; i <= columnCount; i++) {
                    System.out.printf("| %-15s ", rs.getString(i));
                }
                System.out.println("|");
            }
            System.out.println("+--------+------------------+------+----------------------+");
            System.out.println("\nTotal records: " + rowCount);
            
        } catch (SQLException se) {
            System.out.println("SQL Exception occurred:");
            se.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception occurred:");
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
                System.out.println("\nConnection closed.");
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}

