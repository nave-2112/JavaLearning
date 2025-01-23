import java.util.Scanner;
public class EmployeeAttendanceTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] attendance = new String[n][7];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter attendance for Employee " + (i + 1) + ":");
            for (int j = 0; j < 7; j++) {
                System.out.print("Day " + (j + 1) + " (Present/Absent): ");
                attendance[i][j] = sc.next();
            }
        }
        
        for (int i = 0; i < n; i++) {
            System.out.print("Employee " + (i + 1) + "\t");
            for (int j = 0; j < 7; j++) {
                System.out.print(attendance[i][j] + "\t");
            }
            System.out.println();
        }
    }
}