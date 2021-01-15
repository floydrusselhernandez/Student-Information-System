import java.util.ArrayList;
import java.util.Scanner;

/**
 * <h1>Record</h1>
 *Process all input and output
 */
public class Record{
    /**
     * instance of Scanner class for user inputs
     */
    public Scanner scan = new Scanner(System.in);
    /**
     * holds the records of the Student objects
     */
    public ArrayList<Student> studentRecords;
    /**
     * constructor for the Record class
     */
    public Record(){
        this.studentRecords = new ArrayList<>();
        programLoop();
    }
    /**
     * Method programLoop is the main loop of the program
     */
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
    /**
     * This banner displays the welcome statement of the program
     */
    public void banner(){
        System.out.println("===================================");
        System.out.println("\t\tWelcome to CRS");
        System.out.println("===================================");
    }
    /**
     * This method is used to clear the screen
     */
    public void clearScreen(){
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    /**
     * This method displays all the choices of the user
     */
    public void displayOptions(){
        System.out.println("[1] Create Student's Info");
        System.out.println("[2] Display Student's Info");
        System.out.println("[3] Update Student's Info");
        System.out.println("[4] Display All Students Info");
        System.out.println("[5] Exit");
    }
    /**
     * Method used for the creation of new student record.
     * Takes the student's personal information as well as courses for the semester and corresponding grades
     */
    public void createRecord(){
        //holds the list of courses
        ArrayList<Course> courseList = new ArrayList<Course>();
        //holds the name of the student, to be used for creating an instance of Student
        String studentName;
        //holds the degree of the student, to be used for creating an instance of Student
        String degree;
        //holds the year level of the student, to be used for creating an instance of Student
        int year;
        //holds the ID of the student, to be used for creating an instance of Student
        int studentID;
        //holds the corresponding semester, to be used for creating an instance of Semester
        int semester;
        //holds the corresponding academic year, to be used for creating an instance of Semester
        int acadYear;
        //holds the number of courses in the semester, to be used for creating an instances of Course
        int subjects;

        scan.nextLine();
        System.out.print ("Enter Student Name: ");
        studentName = scan.nextLine();
        System.out.print ("Enter Degree Program: ");
        degree = scan.nextLine();
        System.out.print ("Enter Student ID: ");
        studentID = scan.nextInt();
        System.out.print ("Enter Student Year Level: ");
        year = scan.nextInt();
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
        newStudent.addSem(acadYear, semester, courseList);
        studentRecords.add(newStudent);
        clearScreen();
        newStudent.printStudent();

        System.out.println("\nCreated Successfully!!");
        scan.nextLine();
        retExit();
    }

    /**
     * This method displays all the users' name and student ID and searches a certain user
     * information which displays their grades and the courses they are currently taking.
     */
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
    /**
     * This method also used an arrayList for changing the stored information of the user.
     * The user will be given two choices in changing their information; whether their
     * personal information or add new semester to record. This method used switch cases
     * since it has more than one choices.
     */
    public void updateInfo(){
        int ID = 0; //is set to 0 initialize storing
        int option; //to ask the user the options in updating their information
        ArrayList<Course> courseList = new ArrayList<Course>(); //to store new courses of the user
        int newAcadYear; //to store changes in the Acad Year
        int newSemester; //to store new semester
        int newSubjects; //to store new subjects

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

    /**
     * This method is used to display all the information of all students being stored in the program.
     */
    public void displayAll(){
        for (Student student : studentRecords) {
            student.printStudent();
            System.out.println("=======================================================================================================================");
        }
    }

    /**
     * This method asks the user if they want to terminate the program after they run certain options.
     */
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

