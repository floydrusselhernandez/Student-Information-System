import java.util.ArrayList;
import java.util.Scanner;

public class Record {
    public Scanner scan = new Scanner(System.in);
    public ArrayList<Student> studentRecords;
    public Record(){
         this.studentRecords = new ArrayList<>();
        programLoop();
    }
    public void programLoop(){
        boolean quit = false;
        int input;
        while (!quit){
            banner();
            displayOptions();
            input = scan.nextInt();
            switch (input){
                case 1:
                    clearScreen();
                    createRecord();
                    break;
                case 2:
                    clearScreen();
                    displayInfo();
                    break;
                case 3:
                    clearScreen();
                    updateInfo();
                    break;
                case 4:
                    clearScreen();
                    displayAll();
                    break;
                case 5:
                    System.exit(1);
            }




        }
    }
    public void banner(){
        System.out.println("===================================");
        System.out.println("\t\tWelcome to CRS");
        System.out.println("===================================");
    }
    public void clearScreen(){
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    public void displayOptions(){
        System.out.println("[1] Create Student's Info");
        System.out.println("[2] Display Student's Info");
        System.out.println("[3] Update Student's Info");
        System.out.println("[4] Display All Students Info");
        System.out.println("[5] Exit");
    }
    public void createRecord(){
        ArrayList<Course> courseList = new ArrayList<Course>();
        String studentName;
        String degree;
        int year;
        int studentID;
        int semester;
        int acadYear;
        int subjects;
        scan.nextLine();
        System.out.print ("Enter Student Name: ");
        studentName = scan.nextLine();
        System.out.print ("Enter Degree Program: ");
        degree = scan.nextLine();
        System.out.print ("Enter Student Year Level: ");
        year = scan.nextInt();
        System.out.print ("Enter Student ID: ");
        studentID = scan.nextInt();
        System.out.print ("Enter Semester: ");
        semester = scan.nextInt();
        System.out.print ("Enter Academic Year: ");
        acadYear = scan.nextInt();
        System.out.print ("Enter number of Subjects: ");
        subjects = scan.nextInt();

        Student newStudent = new Student(studentName, degree, studentID, year);
        for (int i = 0; i < subjects; i++) {
            String courseName;
            int unit;
            float finGrade;
            float compGrade;
            scan.nextLine();
            System.out.print ("Enter Course Name: ");
            courseName = scan.nextLine();
            System.out.print ("Enter number of Units: ");
            unit = scan.nextInt();
            System.out.print ("Enter your Final Grade: ");
            finGrade = scan.nextFloat();
            if (finGrade == 4.0){
                System.out.print ("Enter your Completion Grade: ");
                compGrade = scan.nextFloat();
            } else {
                compGrade = 0;
            }
            courseList.add(new Course(courseName, unit, finGrade, compGrade));
        }
        newStudent.addSem(year, semester, courseList);
        studentRecords.add(newStudent);
        clearScreen();
        newStudent.printStudent();

        System.out.println("\nCreated Successfully!!");
        scan.nextLine();
        retExit();
    }
    public void displayInfo(){
        int ID = 0;
        for (Student student:studentRecords) {
            System.out.println("ID: " +student.getID()+"\t\tName: "+student.getName());
        }
        System.out.println("Enter Student ID: ");
        ID = scan.nextInt();
        clearScreen();
        for (Student student : studentRecords) {
            if (ID == student.getID()){
                student.printStudent();
            }
        }
        retExit();
    }
    public void updateInfo(){
        int ID = 0;
        int option;
        ArrayList<Course> courseList = new ArrayList<Course>();
        int newAcadYear;
        int newSemester;
        int newSubjects;

        for (Student student:studentRecords) {
            System.out.println("ID: " +student.getID()+"\t\tName: "+student.getName());
        }
        System.out.println("Enter Student ID: ");
        ID = scan.nextInt();
        for (Student student : studentRecords) {
            if (ID == student.getID()){
                student.printStudent();
                System.out.println("\n");
                System.out.println("[1] Update Personal Info");
                System.out.println("[2] Add New Semester to Record");
                option = scan.nextInt();
                switch (option){
                    case 1:
                        scan.nextLine();
                        System.out.print ("Enter New Student Name: ");
                        student.setName(scan.nextLine());
                        System.out.print ("Enter New Degree Program: ");
                        student.setDegree(scan.nextLine());
                        System.out.print ("Enter New Student Year Level: ");
                        student.setYear(scan.nextInt());
                        break;
                    case 2:
                        System.out.print ("Enter New Semester: ");
                        newSemester = scan.nextInt();
                        System.out.print ("Enter Academic Year: ");
                        newAcadYear = scan.nextInt();
                        System.out.print ("Enter New Number of Subjects: ");
                        newSubjects = scan.nextInt();
                        for (int i = 0; i < newSubjects; i++) {
                            String courseName;
                            int unit;
                            float finGrade;
                            float compGrade;
                            scan.nextLine();
                            System.out.print ("Enter Course Name: ");
                            courseName = scan.nextLine();
                            System.out.print ("Enter number of Units: ");
                            unit = scan.nextInt();
                            System.out.print ("Enter your Final Grade: ");
                            finGrade = scan.nextFloat();
                            if (finGrade == 4.0){
                                System.out.print ("Enter your Completion Grade: ");
                                compGrade = scan.nextFloat();
                            } else {
                                compGrade = 0;
                            }
                            courseList.add(new Course(courseName, unit, finGrade, compGrade));
                        }
                        student.addSem(newAcadYear, newSemester, courseList);
                }
                clearScreen();
                student.printStudent();
                System.out.println("\nCreated Successfully!!");
                scan.nextLine();
            }
        }
        retExit();
    }
    public void displayAll(){
        for (Student student : studentRecords) {
            student.printStudent();
            System.out.println("===============================================================================================");
        }
    }
    public void retExit() {
        String option;
        System.out.print("\n\nExit Program? Y/N:\t");
        option = scan.next();
        if (option.toUpperCase().equals("Y")) {
            System.exit(1);
        }
        clearScreen();
    }
}
