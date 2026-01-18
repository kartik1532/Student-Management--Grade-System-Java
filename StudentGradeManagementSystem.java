import java.util.*;

public class StudentGradeManagementSystem {

    static HashMap<String, Integer> studentGrades = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== STUDENT GRADE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student & Grade");
            System.out.println("2. View All Students");
            System.out.println("3. Sort Students by Grade");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    sortStudentsByGrade();
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);
    }

    // Add student and grade
    static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter grade: ");
        int grade = scanner.nextInt();

        studentGrades.put(name, grade);
        System.out.println("Student added successfully!");
    }

    // View all students
    static void viewStudents() {
        if (studentGrades.isEmpty()) {
            System.out.println("No student data available.");
            return;
        }

        System.out.println("\nStudent Grades:");
        for (Map.Entry<String, Integer> entry : studentGrades.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    // Sort students by grade
    static void sortStudentsByGrade() {
        if (studentGrades.isEmpty()) {
            System.out.println("No student data available.");
            return;
        }

        ArrayList<Map.Entry<String, Integer>> list =
                new ArrayList<>(studentGrades.entrySet());

        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("\nStudents Sorted by Grade (High to Low):");
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
