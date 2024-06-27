import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AttendanceManagementSystem {

    private static List<String> graduates = new ArrayList<>();
    private static List<String> courses = new ArrayList<>();
    private static List<List<Boolean>> attendanceRecords = new ArrayList<>();

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
        try {
            System.out.println("\nAttendance Management System");
            System.out.println("1. Register Graduate");
            System.out.println("2. Add Course");
            System.out.println("3. Record Attendance");
            System.out.println("4. View Attendance Report");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerGraduate(scanner);
                    break;
                case 2:
                    addCourse(scanner);
                    break;
                case 3:
                    recordAttendance(scanner);
                    break;
                case 4:
                    viewAttendanceReport();
                    break;
                case 5:
                    System.out.println("Exiting the system...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Input error encountered. Please try again.");
            scanner = new Scanner(System.in); // Reinitialize scanner to recover from error
        }
    }
}

    private static void registerGraduate(Scanner scanner) {
        System.out.print("Enter graduate name: ");
        String name = scanner.nextLine();
        if (!graduates.contains(name)) {
            graduates.add(name);
            // Initialize attendance record for the new graduate
            List<Boolean> attendance = new ArrayList<>();
            for (int i = 0; i < courses.size(); i++) {
                attendance.add(false); // False indicates absence by default
            }
            attendanceRecords.add(attendance);
            System.out.println(name + " has been registered successfully.");
        } else {
            System.out.println("Graduate already registered.");
        }
    }

    private static void addCourse(Scanner scanner) {
        System.out.print("Enter course name: ");
        String course = scanner.nextLine();
        if (!courses.contains(course)) {
            courses.add(course);
            // Update all attendance records to include the new course
            for (List<Boolean> attendance : attendanceRecords) {
                attendance.add(false); // False indicates absence by default
            }
            System.out.println(course + " has been added successfully.");
        } else {
            System.out.println("Course already exists.");
        }
    }

    private static void recordAttendance(Scanner scanner) {
        System.out.println("Select a course to record attendance for:");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i));
        }
        int courseIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline
        if (courseIndex >= 0 && courseIndex < courses.size()) {
            System.out.println("Recording attendance for " + courses.get(courseIndex) + ":");
            for (int i = 0; i < graduates.size(); i++) {
                System.out.print("Is " + graduates.get(i) + " present? (Y/N): ");
                String input = scanner.nextLine();
                boolean isPresent = input.equalsIgnoreCase("Y");
                attendanceRecords.get(i).set(courseIndex, isPresent);
            }
        } else {
            System.out.println("Invalid course selection.");
        }
    }

    private static void viewAttendanceReport() {
        System.out.println("\nAttendance Report:");
        for (int i = 0; i < graduates.size(); i++) {
            System.out.println("Graduate: " + graduates.get(i));
            for (int j = 0; j < courses.size(); j++) {
                System.out.println(courses.get(j) + ": " + (attendanceRecords.get(i).get(j) ? "Present" : "Absent"));
            }
            System.out.println();
        }
    }
}