// Database Connection Utility Class
// Handles database connection and disconnection
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    // Method to establish database connection
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        // Register JDBC driver
        Class.forName(DatabaseConfig.DRIVER);
        
        // Open and return connection
        Connection conn = DriverManager.getConnection(
            DatabaseConfig.DB_URL,
            DatabaseConfig.USER,
            DatabaseConfig.PASS
        );
        return conn;
    }
    
    // Method to close database connection
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Database connection closed successfully.");
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}

