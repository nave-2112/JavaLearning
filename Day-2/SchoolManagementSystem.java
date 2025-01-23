import java.util.Scanner;
class Student {
    String name;
    int rollNumber;
    double[] grades;  
    boolean[] attendance;

    public Student(String name, int rollNumber, int numSubjects) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grades = new double[numSubjects];
        this.attendance = new boolean[numSubjects];  
    }
    public void displayStudentDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);

        System.out.print("Grades: ");
        for (double grade : grades) {
            System.out.print(grade + " ");
        }
        System.out.println();
        System.out.print("Attendance: ");
        for (boolean attended : attendance) {
            System.out.print(attended ? "Present " : "Absent ");
        }
        System.out.println();
    }
    public double calculateAverageGrade() {
        double total = 0;
        for (double grade : grades) {
            total += grade;
        }
        return grades.length > 0 ? total / grades.length : 0.0;
    }

    public void markAttendance(int subjectIndex, boolean isPresent) {
        if (subjectIndex >= 0 && subjectIndex < attendance.length) {
            attendance[subjectIndex] = isPresent;
        } else {
            System.out.println("Invalid subject index.");
        }
    }

    public void setGrade(int subjectIndex, double grade) {
        if (subjectIndex >= 0 && subjectIndex < grades.length) {
            grades[subjectIndex] = grade;
        } else {
            System.out.println("Invalid subject index.");
        }
    }
}

public class SchoolManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student("Naveen", 123, 5);

        student.setGrade(0, 85.5);  
        student.setGrade(1, 90.0);  
        student.setGrade(2, 88.0);  
        student.setGrade(3, 92.5);  
        student.setGrade(4, 76.0);  
        student.markAttendance(0, true);  
        student.markAttendance(1, false); 
        student.markAttendance(2, true);  
        student.markAttendance(3, true); 
        student.markAttendance(4, false); 

        System.out.println("Displaying student details:");
        student.displayStudentDetails();

        double averageGrade = student.calculateAverageGrade();
        System.out.println("Average Grade: " + String.format("%.2f", averageGrade));
        
        System.out.print("\nWould you like to input a new student? (y/n): ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("y")) {
            System.out.print("Enter student's name: ");
            String name = scanner.nextLine();
            System.out.print("Enter roll number: ");
            int rollNumber = scanner.nextInt();
            System.out.print("Enter number of subjects: ");
            int numSubjects = scanner.nextInt();
            scanner.nextLine();  
            Student newStudent = new Student(name, rollNumber, numSubjects);
            for (int i = 0; i < numSubjects; i++) {
                System.out.print("Enter grade for subject " + (i + 1) + ": ");
                double grade = scanner.nextDouble();
                newStudent.setGrade(i, grade);

                System.out.print("Enter attendance for subject " + (i + 1) + " (true for present, false for absent): ");
                boolean attendance = scanner.nextBoolean();
                newStudent.markAttendance(i, attendance);
            }

            System.out.println("\nDisplaying new student details:");
            newStudent.displayStudentDetails();
            double newAverageGrade = newStudent.calculateAverageGrade();
            System.out.println("Average Grade: " + String.format("%.2f", newAverageGrade));
        }

    }
}