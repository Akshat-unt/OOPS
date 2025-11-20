// Program 16: Write a program in java which implement interface Student which has two methods
// Display_Grade and Attendance for PG_Students and UG_Students
interface Student {
    void Display_Grade();
    void Attendance();
}

class PG_Students implements Student {
    private String name;
    private String grade;
    private int attendancePercentage;
    
    public PG_Students(String name, String grade, int attendancePercentage) {
        this.name = name;
        this.grade = grade;
        this.attendancePercentage = attendancePercentage;
    }
    
    @Override
    public void Display_Grade() {
        System.out.println("PG Student: " + name);
        System.out.println("Grade: " + grade);
    }
    
    @Override
    public void Attendance() {
        System.out.println("PG Student: " + name);
        System.out.println("Attendance: " + attendancePercentage + "%");
        if (attendancePercentage >= 75) {
            System.out.println("Status: Eligible for examination");
        } else {
            System.out.println("Status: Not eligible for examination");
        }
    }
}

class UG_Students implements Student {
    private String name;
    private String grade;
    private int attendancePercentage;
    
    public UG_Students(String name, String grade, int attendancePercentage) {
        this.name = name;
        this.grade = grade;
        this.attendancePercentage = attendancePercentage;
    }
    
    @Override
    public void Display_Grade() {
        System.out.println("UG Student: " + name);
        System.out.println("Grade: " + grade);
    }
    
    @Override
    public void Attendance() {
        System.out.println("UG Student: " + name);
        System.out.println("Attendance: " + attendancePercentage + "%");
        if (attendancePercentage >= 75) {
            System.out.println("Status: Eligible for examination");
        } else {
            System.out.println("Status: Not eligible for examination");
        }
    }
}

public class Program16_StudentInterface {
    public static void main(String[] args) {
        System.out.println("Student Interface Implementation\n");
        
        // Creating PG Students
        PG_Students pg1 = new PG_Students("Alice", "A+", 85);
        PG_Students pg2 = new PG_Students("Bob", "B+", 70);
        
        // Creating UG Students
        UG_Students ug1 = new UG_Students("Charlie", "A", 90);
        UG_Students ug2 = new UG_Students("Diana", "B", 65);
        
        System.out.println("=== PG Students ===");
        pg1.Display_Grade();
        pg1.Attendance();
        System.out.println();
        
        pg2.Display_Grade();
        pg2.Attendance();
        System.out.println();
        
        System.out.println("=== UG Students ===");
        ug1.Display_Grade();
        ug1.Attendance();
        System.out.println();
        
        ug2.Display_Grade();
        ug2.Attendance();
    }
}

