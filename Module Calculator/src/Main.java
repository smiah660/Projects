import java.util.Scanner; //The 'scanner' class comes from the java.util package and allows user input

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[3];     /*An array of 'student' objects are created,
                                                  This will hold details and marks */

        Module cw001 = new CW001("CW001", 85.0, 92.0, 78.0, 90.0);
        Module ex002 = new EX002("EX002", 100);
        Module ce003 = new CE003("CE003", 2, 40, 60, 4, 100);

                                               //Since there are 3 modules, 3 Module objects are created

        for (int i = 0; i < students.length; i++) {
            System.out.printf("Enter details for student %d:%nID: ", (i+1));
            String id = scanner.nextLine();
            System.out.print("First name: ");
            String firstName = scanner.nextLine();
            System.out.print("Surname: ");
            String surname = scanner.nextLine();

            System.out.println("Enter marks for CW001:"); //marks are entered in the form of an array
            double[] cw001Marks = new double[4];
            for (int j = 0; j < cw001Marks.length-1; j++) {
                System.out.printf("Homework %d: ", (j+1));
                cw001Marks[j] = scanner.nextDouble();
            }
            System.out.print("Final project: ");
            cw001Marks[cw001Marks.length-1] = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Enter mark for EX002: "); //Only single value entered, differing to the others
            double ex002Mark = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Enter marks for CE003:");  //marks are entered in the form of an array
            double[] ce003Marks = new double[6];
            for (int j = 0; j < ce003Marks.length-2; j++) {
                System.out.printf("Homework %d: ", (j+1));
                ce003Marks[j] = scanner.nextDouble();
            }
            System.out.print("Exam: ");
            ce003Marks[ce003Marks.length-2] = scanner.nextDouble();
            scanner.nextLine();

            students[i] = new Student(id, firstName, surname);
            students[i].setCw001Marks(cw001Marks);
            students[i].setEx002Mark(ex002Mark);
            students[i].setCe003Marks(ce003Marks);
        }
        System.out.printf("%-15s %-15s %-20s %-20s %-20s%n", "Name", "Surname", "CW001", "EX002", "CE003");
        for (Student student : students) {
            System.out.printf("%-15s %-15s %-20s %-20s %-20s%n", student.getFirstName(), student.getLastName(),
                    student.getCw001FinalMark(), student.getEx002FinalMark(), student.getCe003FinalMark());
        }
        System.out.println();
        System.out.printf("%-15s %-15s %-10s %-10s %-10s %-10s%n", "Name", "Surname", "HW1", "HW2", "HW3", "Project");
        for (Student student : students) {
            System.out.printf("%-15s %-15s %-10.2f%% %-10.2f%% %-10.2f%% %-10.2f%%%n", student.getFirstName(), student.getLastName(),
                    student.getCw001Marks()[0], student.getCw001Marks()[1], student.getCw001Marks()[2], student.getCw001Marks()[3]);
        }

        scanner.close();
    }
}


