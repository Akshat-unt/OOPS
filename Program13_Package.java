// Program 13: Write a program in Java that import the user define package and access the Member variable of classes that Contained by Package
import mypackage.Student;

public class Program13_Package {
    public static void main(String[] args) {
        // Creating object of Student class from mypackage
        Student student = new Student("John Doe", 101, "Computer Science");
        
        System.out.println("Student Information:");
        System.out.println("Name: " + student.name);
        System.out.println("Roll Number: " + student.rollNumber);
        System.out.println("Course: " + student.course);
        
        System.out.println("\nUsing display method:");
        student.display();
        
        // Accessing and modifying member variables
        System.out.println("\nModifying member variables:");
        student.name = "Jane Smith";
        student.rollNumber = 102;
        student.course = "Information Technology";
        
        student.display();
    }
}

