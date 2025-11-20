// Student Data Access Object (DAO) Class
// Handles all database operations for Student entity
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private Connection connection;
    
    public StudentDAO() throws SQLException, ClassNotFoundException {
        this.connection = DatabaseConnection.getConnection();
    }
    
    // CREATE: Insert a new student record
    public boolean insertStudent(Student student) {
        String sql = "INSERT INTO students (id, name, age, course, email, phone) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, student.getId());
            pstmt.setString(2, student.getName());
            pstmt.setInt(3, student.getAge());
            pstmt.setString(4, student.getCourse());
            pstmt.setString(5, student.getEmail());
            pstmt.setString(6, student.getPhone());
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error inserting student: " + e.getMessage());
            return false;
        }
    }
    
    // READ: Get all students
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students ORDER BY id";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Student student = new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("course"),
                    rs.getString("email"),
                    rs.getString("phone")
                );
                students.add(student);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving students: " + e.getMessage());
        }
        
        return students;
    }
    
    // READ: Get student by ID
    public Student getStudentById(int id) {
        String sql = "SELECT * FROM students WHERE id = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("course"),
                        rs.getString("email"),
                        rs.getString("phone")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving student: " + e.getMessage());
        }
        
        return null;
    }
    
    // UPDATE: Update student information
    public boolean updateStudent(Student student) {
        String sql = "UPDATE students SET name = ?, age = ?, course = ?, email = ?, phone = ? WHERE id = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getAge());
            pstmt.setString(3, student.getCourse());
            pstmt.setString(4, student.getEmail());
            pstmt.setString(5, student.getPhone());
            pstmt.setInt(6, student.getId());
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
            return false;
        }
    }
    
    // DELETE: Delete student by ID
    public boolean deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("Error deleting student: " + e.getMessage());
            return false;
        }
    }
    
    // Search students by name
    public List<Student> searchStudentsByName(String name) {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students WHERE name LIKE ? ORDER BY id";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, "%" + name + "%");
            
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("course"),
                        rs.getString("email"),
                        rs.getString("phone")
                    );
                    students.add(student);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error searching students: " + e.getMessage());
        }
        
        return students;
    }
    
    // Get total number of students
    public int getTotalStudents() {
        String sql = "SELECT COUNT(*) FROM students";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error counting students: " + e.getMessage());
        }
        
        return 0;
    }
    
    // Close connection
    public void closeConnection() {
        DatabaseConnection.closeConnection(connection);
    }
}

