/**
 * <h1>Course</h1>
 * This class is the template for the Courses (Subjects) of the Student
 */
public class Course {
    /**
     * name of the Course object
     */
    private String courseName;
    /**
     * number of units of the course
     */
    private int unit;
    /**
     * final grade of the student in the Course object
     */
    private float finalGrade;
    /**
     * completion grade of the student in the Course object
     */
    private float completionGrade;

    /**
     * Constructor for Course Class
     * @param name name of the course
     * @param unit number of units of the course
     * @param finGrade final grade for the course
     * @param compGrade completion grade for the course
     */
    public Course(String name, int unit, float finGrade, float compGrade){
        this.courseName = name;
        this.unit = unit;
        this.finalGrade = finGrade;
        this.completionGrade = compGrade;
    }

    /**
     * Gets Degree Program Name of the Course object
     * @return courseName name of the course
     */
    public String getName(){
        return courseName;
    }
    /**
     * Sets new Name of the Course object
     * @param newName new name of the Course object
     */
    public void setName(String newName){
        this.courseName = newName;
    }
    /**
     * Gets Unit of the Course object
     * @return unit number of units of the course
     */
    public int getUnit(){
        return unit;
    }
    /**
     * Sets new Unit of the Course object
     * @param newUnit new unit for the course
     */
    public void setUnit(int newUnit){
        this.unit = newUnit;
    }
    /**
     * Gets Final Grade of the Course object
     * @return finalGrade final grade of the student in the course
     */
    public float getfinGrade(){
        return finalGrade;
    }
    /**
     * Sets Final Grade of the Course object
     * @param finGrade final grade of the student in the course
     */
    public void setfinGrade(float finGrade){
        this.finalGrade = finGrade;
    }
    /**
     * Gets Completion Grade of the Course object
     * @return completionGrade the student's completion grade in the course
     */
    public float getcompGrade(){
        return completionGrade;
    }
    /**
     * Sets Completion Grade of the Course object
     * @param compGrade sets the student's completion grade for the course
     */
    public void setcompGrade(float compGrade){
        this.completionGrade = compGrade;
    }
}
