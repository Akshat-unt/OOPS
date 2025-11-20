// Main Student Management System Class
// Menu-driven application for managing student records
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {
    private static StudentDAO studentDAO;
    private static Scanner scanner;
    
    public static void main(String[] args) {
        try {
            // Initialize database connection
            studentDAO = new StudentDAO();
            scanner = new Scanner(System.in);
            
            System.out.println("========================================");
            System.out.println("   STUDENT MANAGEMENT SYSTEM (JDBC)");
            System.out.println("========================================\n");
            
            // Main menu loop
            int choice;
            do {
                displayMenu();
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                
                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        displayAllStudents();
                        break;
                    case 3:
                        searchStudentById();
                        break;
                    case 4:
                        searchStudentByName();
                        break;
                    case 5:
                        updateStudent();
                        break;
                    case 6:
                        deleteStudent();
                        break;
                    case 7:
                        displayStatistics();
                        break;
                    case 8:
                        System.out.println("\nThank you for using Student Management System!");
                        break;
                    default:
                        System.out.println("\nInvalid choice! Please try again.");
                }
                
                if (choice != 8) {
                    System.out.println("\nPress Enter to continue...");
                    scanner.nextLine();
                }
                
            } while (choice != 8);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (studentDAO != null) {
                studentDAO.closeConnection();
            }
            if (scanner != null) {
                scanner.close();
            }
        }
    }
    
    private static void displayMenu() {
        System.out.println("\n========================================");
        System.out.println("            MAIN MENU");
        System.out.println("========================================");
        System.out.println("1. Add New Student");
        System.out.println("2. Display All Students");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Search Student by Name");
        System.out.println("5. Update Student Information");
        System.out.println("6. Delete Student");
        System.out.println("7. Display Statistics");
        System.out.println("8. Exit");
        System.out.println("========================================\n");
    }
    
    private static void addStudent() {
        System.out.println("\n--- ADD NEW STUDENT ---");
        
        try {
            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            // Check if student already exists
            Student existing = studentDAO.getStudentById(id);
            if (existing != null) {
                System.out.println("Student with ID " + id + " already exists!");
                return;
            }
            
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            
            System.out.print("Enter Course: ");
            String course = scanner.nextLine();
            
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();
            
            System.out.print("Enter Phone: ");
            String phone = scanner.nextLine();
            
            Student student = new Student(id, name, age, course, email, phone);
            
            if (studentDAO.insertStudent(student)) {
                System.out.println("\n✓ Student added successfully!");
            } else {
                System.out.println("\n✗ Failed to add student!");
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void displayAllStudents() {
        System.out.println("\n--- ALL STUDENTS ---\n");
        
        List<Student> students = studentDAO.getAllStudents();
        
        if (students.isEmpty()) {
            System.out.println("No students found in the database.");
        } else {
            System.out.println("+----+------------------+-----+----------------------+----------------------+----------------+");
            System.out.printf("| %-3s| %-17s| %-4s| %-21s| %-21s| %-15s|\n", 
                "ID", "Name", "Age", "Course", "Email", "Phone");
            System.out.println("+----+------------------+-----+----------------------+----------------------+----------------+");
            
            for (Student student : students) {
                System.out.printf("| %-3d| %-17s| %-4d| %-21s| %-21s| %-15s|\n",
                    student.getId(),
                    student.getName(),
                    student.getAge(),
                    student.getCourse(),
                    student.getEmail(),
                    student.getPhone()
                );
            }
            
            System.out.println("+----+------------------+-----+----------------------+----------------------+----------------+");
            System.out.println("\nTotal Students: " + students.size());
        }
    }
    
    private static void searchStudentById() {
        System.out.println("\n--- SEARCH STUDENT BY ID ---");
        System.out.print("Enter Student ID: ");
        
        try {
            int id = scanner.nextInt();
            scanner.nextLine();
            
            Student student = studentDAO.getStudentById(id);
            
            if (student != null) {
                System.out.println("\nStudent Found:");
                System.out.println("+----+------------------+-----+----------------------+----------------------+----------------+");
                System.out.printf("| %-3s| %-17s| %-4s| %-21s| %-21s| %-15s|\n", 
                    "ID", "Name", "Age", "Course", "Email", "Phone");
                System.out.println("+----+------------------+-----+----------------------+----------------------+----------------+");
                System.out.printf("| %-3d| %-17s| %-4d| %-21s| %-21s| %-15s|\n",
                    student.getId(),
                    student.getName(),
                    student.getAge(),
                    student.getCourse(),
                    student.getEmail(),
                    student.getPhone()
                );
                System.out.println("+----+------------------+-----+----------------------+----------------------+----------------+");
            } else {
                System.out.println("\nStudent with ID " + id + " not found!");
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void searchStudentByName() {
        System.out.println("\n--- SEARCH STUDENT BY NAME ---");
        System.out.print("Enter Student Name (or part of name): ");
        String name = scanner.nextLine();
        
        List<Student> students = studentDAO.searchStudentsByName(name);
        
        if (students.isEmpty()) {
            System.out.println("\nNo students found with name containing: " + name);
        } else {
            System.out.println("\nSearch Results:");
            System.out.println("+----+------------------+-----+----------------------+----------------------+----------------+");
            System.out.printf("| %-3s| %-17s| %-4s| %-21s| %-21s| %-15s|\n", 
                "ID", "Name", "Age", "Course", "Email", "Phone");
            System.out.println("+----+------------------+-----+----------------------+----------------------+----------------+");
            
            for (Student student : students) {
                System.out.printf("| %-3d| %-17s| %-4d| %-21s| %-21s| %-15s|\n",
                    student.getId(),
                    student.getName(),
                    student.getAge(),
                    student.getCourse(),
                    student.getEmail(),
                    student.getPhone()
                );
            }
            
            System.out.println("+----+------------------+-----+----------------------+----------------------+----------------+");
            System.out.println("\nFound " + students.size() + " student(s)");
        }
    }
    
    private static void updateStudent() {
        System.out.println("\n--- UPDATE STUDENT INFORMATION ---");
        System.out.print("Enter Student ID to update: ");
        
        try {
            int id = scanner.nextInt();
            scanner.nextLine();
            
            Student student = studentDAO.getStudentById(id);
            
            if (student == null) {
                System.out.println("Student with ID " + id + " not found!");
                return;
            }
            
            System.out.println("\nCurrent Information:");
            System.out.println(student);
            System.out.println("\nEnter new information (press Enter to keep current value):");
            
            System.out.print("Name [" + student.getName() + "]: ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                student.setName(name);
            }
            
            System.out.print("Age [" + student.getAge() + "]: ");
            String ageStr = scanner.nextLine();
            if (!ageStr.isEmpty()) {
                student.setAge(Integer.parseInt(ageStr));
            }
            
            System.out.print("Course [" + student.getCourse() + "]: ");
            String course = scanner.nextLine();
            if (!course.isEmpty()) {
                student.setCourse(course);
            }
            
            System.out.print("Email [" + student.getEmail() + "]: ");
            String email = scanner.nextLine();
            if (!email.isEmpty()) {
                student.setEmail(email);
            }
            
            System.out.print("Phone [" + student.getPhone() + "]: ");
            String phone = scanner.nextLine();
            if (!phone.isEmpty()) {
                student.setPhone(phone);
            }
            
            if (studentDAO.updateStudent(student)) {
                System.out.println("\n✓ Student information updated successfully!");
            } else {
                System.out.println("\n✗ Failed to update student information!");
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void deleteStudent() {
        System.out.println("\n--- DELETE STUDENT ---");
        System.out.print("Enter Student ID to delete: ");
        
        try {
            int id = scanner.nextInt();
            scanner.nextLine();
            
            Student student = studentDAO.getStudentById(id);
            
            if (student == null) {
                System.out.println("Student with ID " + id + " not found!");
                return;
            }
            
            System.out.println("\nStudent to be deleted:");
            System.out.println(student);
            System.out.print("\nAre you sure you want to delete this student? (yes/no): ");
            String confirm = scanner.nextLine();
            
            if (confirm.equalsIgnoreCase("yes")) {
                if (studentDAO.deleteStudent(id)) {
                    System.out.println("\n✓ Student deleted successfully!");
                } else {
                    System.out.println("\n✗ Failed to delete student!");
                }
            } else {
                System.out.println("\nDeletion cancelled.");
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void displayStatistics() {
        System.out.println("\n--- STATISTICS ---\n");
        
        int totalStudents = studentDAO.getTotalStudents();
        List<Student> allStudents = studentDAO.getAllStudents();
        
        System.out.println("Total Students: " + totalStudents);
        
        if (!allStudents.isEmpty()) {
            // Count students by course
            System.out.println("\nStudents by Course:");
            System.out.println("+----------------------+--------+");
            System.out.printf("| %-21s| %-7s|\n", "Course", "Count");
            System.out.println("+----------------------+--------+");
            
            // Simple grouping (for better implementation, use SQL GROUP BY)
            java.util.Map<String, Integer> courseCount = new java.util.HashMap<>();
            for (Student s : allStudents) {
                courseCount.put(s.getCourse(), courseCount.getOrDefault(s.getCourse(), 0) + 1);
            }
            
            for (java.util.Map.Entry<String, Integer> entry : courseCount.entrySet()) {
                System.out.printf("| %-21s| %-7d|\n", entry.getKey(), entry.getValue());
            }
            System.out.println("+----------------------+--------+");
        }
    }
}

