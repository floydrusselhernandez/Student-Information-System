import java.util.ArrayList;

/**
 *<h1>Student</h1>
 * Template for Student objects
 */
public class Student {
    /**
     * studentName is used to store student's name
     */
    private String studentName;
    /**
     * degree is used to store student's degree program
     */
    private String degree;
    /**
     * studentID is used to store student's ID number
     */
    private int studentID;
    /**
     *  yearLevel is used to store student's year level
     */
    private int yearLevel;
    /**
     * semList has an array to store several student's semestral information
     */
    private ArrayList<Semester> semList;

    /**
     * Constructor for the Student class
     * @param name is used to store student's name
     * @param degree is used to store student's degree program
     * @param ID is used to store student's ID number
     * @param yearLevel is used to store student's year level
     */
    public Student(String name, String degree, int ID, int yearLevel){
        this.studentName = name;
        this.degree = degree;
        this.studentID = ID;
        this.yearLevel = yearLevel;
        this.semList = new ArrayList<>();
    }
    /**
     * Gets Name of the Student object
     * @return studentName name of the student
     */
    public String getName(){
        return studentName;
    }
    /**
     * Sets new Name of the Student object
     * @param newName new name of the student
     */
    public void setName(String newName){
        this.studentName = newName;
    }
    /**
     * Gets Degree Program of the Student object
     * @return degree degree of the student
     */
    public String getDegree(){
        return degree;
    }
    /**
     * Sets new Degree Program of the Student object
     * @param newDegree new degree of the student
     */
    public void setDegree(String newDegree){
        this.degree = degree;
    }
    /**
     * Gets ID of the Student object
     * @return studentID ID of the student
     */
    public int getID(){
        return studentID;
    }
    /**
     * Sets new ID of the Student object
     * @param newID  new ID of the student
     */
    public void setID(int newID){
        this.studentID = newID;
    }
    /**
     * Gets Year Level of the Student object
     * @return yearLevel year level of the student
     */
    public int getYearLevel(){
        return yearLevel;
    }
    /**
     * Sets new Year Level of the Student object
     * @param newYear new year level of the student
     */
    public void setYear(int newYear){
        this.yearLevel = newYear;
    }
    /**
     * This method adds new Semester with new Year Level, Semester, and courses
     */
    public void addSem(int acadYear, int semester, ArrayList<Course> courseList){
        semList.add( new Semester(acadYear, semester, courseList));        //create an object of course and add into the array
    }
    /**
     * This method displays inputs of the Student object
     */
    public void printStudent(){
        System.out.println("Student ID: \t"+studentID);
        System.out.println("Name:\t"+studentName);
        System.out.println("Degree Program: \t"+degree);
        System.out.println("Year: \t"+yearLevel);
        for (Semester sem: semList) {
            sem.printSem();
        }
    }
}
