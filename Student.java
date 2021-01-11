import java.util.ArrayList;

public class Student {
    private String studentName;
    private String degree;
    private int studentID;
    private int yearLevel;
    private ArrayList<Semester> semList;
    public Student(String name, String degree, int ID, int yearLevel){
        this.studentName = name;
        this.degree = degree;
        this.studentID = ID;
        this.yearLevel = yearLevel;
        this.semList = new ArrayList<>();
    }
    public String getName(){
        return studentName;
    }
    public void setName(String newName){
        this.studentName = newName;
    }
    public String getDegree(){
        return degree;
    }
    public void setDegree(String newDegree){
        this.degree = degree;
    }
    public int getID(){
        return studentID;
    }
    public void setID(int newID){
        this.studentID = newID;
    }
    public int getYearLevel(){
        return yearLevel;
    }
    public void setYear(int newYear){
        this.yearLevel = newYear;
    }
    public void addSem(int yearLevel, int semester, ArrayList<Course> courseList){
        semList.add( new Semester(yearLevel, semester, courseList));        //create an object of course and add into the array
    }
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
