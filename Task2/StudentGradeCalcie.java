package Task2;
import java.util.Scanner;

public class StudentGradeCalcie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input marks for each subject
        System.out.println("Enter marks obtained (out of 100) for each subject:");
        System.out.print("English: ");
        int english = validateMarks(scanner);
        System.out.print("Maths: ");
        int maths = validateMarks(scanner);
        System.out.print("Physics: ");
        int physics = validateMarks(scanner);
        System.out.print("Chemistry: ");
        int chemistry = validateMarks(scanner);
        System.out.print("Biology: ");
        int biology = validateMarks(scanner);

        // Calculate total marks
        int totalMarks = english + maths + physics + chemistry + biology;

        // Calculate average percentage
        double averagePercentage = totalMarks / 5.0;

        // Calculate grade
        String grade = calculateGrade(averagePercentage);

        // Display results
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks + " out of 500");
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    // Method to validate input marks (between 0 and 100)
    private static int validateMarks(Scanner scanner) {
        int marks;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 0 and 100.");
                scanner.next(); // Consume the invalid input
            }
            marks = scanner.nextInt();
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks. Please enter a number between 0 and 100.");
            }
        } while (marks < 0 || marks > 100);
        return marks;
    }

    // Method to calculate grade based on average percentage
    private static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B";
        } else if (averagePercentage >= 60) {
            return "C";
        } else if (averagePercentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}