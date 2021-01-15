import java.util.ArrayList;

/**
 * <h1>Semester</h1>
 * Used for all semestral records of the student
 */
public class Semester {
    /**
     * acadYear is used to store Academic Year object
     */
    private int acadYear; //is used to store Academic Year object
    /**
     * semester is used to store the Semester object
     */
    private int semester; //is used to store the Semester object
    /**
     * courseList is used to store all the information in Course
     */
    private ArrayList<Course> courseList; //is used to store all the information in Course

    /**
     * Constructor for semester class
     * @param year the academic year of the semester
     * @param semester first/second semester
     * @param courseList list of courses in that semester
     */
    public Semester(int year, int semester, ArrayList<Course> courseList){
        this.acadYear = year;
        this.semester = semester;
        this.courseList = courseList;
    }
    /**
     * Gets Academic Year of the Semester object
     * @return acadYear the academic year of the corresponding semester
     */
    public int getYear(){
        return acadYear;
    }
    /**
     * Sets new Academic Year of the Semester object
     * @param newYear new academic year of the semester
     */
    public void setYear(int newYear){
        this.acadYear = newYear;
    }
    /**
     * Gets Semester of the Semester object
     * @return semester first of second semester
     */
    public int getSemester(){
        return semester;
    }
    /**
     * Sets new Semester of the Semester object
     * @param newSemester sets the new semester
     */
    public void setSemester(int newSemester){
        this.semester = newSemester;
    }
    /**
     * Creates an object of Course and adds it into the array
     */
    public void addCourse(String name, int unit, float finGrade, float compGrade){
        courseList.add( new Course(name, unit, finGrade, compGrade));
    }
    /**
     * Calculates the total Unit of the Semester object and gets Course from courseList and copies it
     * @return total total unit of the semester
     */
    public int getTotalUnit(){
        int total = 0;
        for (Course course : courseList){
            total += course.getUnit();
        }
        return total;
    }
    /**
     * prints all the details of the semester including courses, grade, gwa, total units
     */
    public void printSem() {
        System.out.println("\nRecords for Academic Year: " + acadYear);
        System.out.println("Semester: " + semester);
        System.out.printf("\n%10s%-45s%22s%15s%25s\n\n", " ", "Subject", "Units", "Final Grade", "Completion Grade");

        for (Course course : courseList) {
            System.out.printf("%s%-8s%36s", "  ", course.getName(), "=======");
            System.out.printf("%30d", course.getUnit());
            System.out.printf("%12.2f", course.getfinGrade());
            System.out.printf("%22.2f", course.getcompGrade());
            System.out.println();
        }
        System.out.println("GWA: \t"+GWA());
        System.out.println("Class Standing: \t"+standing());
        System.out.println("Total Units: \t"+getTotalUnit());
    }
    /**
     * This method is used in computing the Total Grade, Total Unit, and the GWA
     * @return gwa general weighted grade of that semester
     */
    public float GWA(){
        float totalGrade = 0;
        float totalUnit = 0;
        float gwa = 0;
        for (Course course: courseList){
            if (course.getcompGrade() == 0.0){
                totalGrade += course.getfinGrade() * course.getUnit();
            }
            else{
                totalGrade += course.getcompGrade() * course.getUnit();
            }
        }
        totalUnit = getTotalUnit();
        gwa = totalGrade / totalUnit;
        return gwa;
    }
    public String standing(){
        if(GWA()>= 1.0 && GWA() < 3.0 ){
            return "Good Standing";
        }
        else if(GWA()>= 3.00 && GWA() < 3.25){
            return "Warning";
        }
        else if(GWA() >= 3.25 && GWA() < 3.75){
            return "Dismissal";
        }
        else {
            return "Permanent Dismissal";
        }
    }
}