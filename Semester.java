import java.util.ArrayList;

public class Semester {
    private int acadYear;
    private int semester;
    private ArrayList<Course> courseList = new ArrayList<>();
    public Semester(int year, int semester, ArrayList<Course> courseList){
        this.acadYear = year;
        this.semester = semester;
        this.courseList = courseList;
    }
    public int getYear(){
        return acadYear;
    }
    public void setYear(int newYear){
        this.acadYear = newYear;
    }
    public int getSemester(){
        return semester;
    }
    public void setSemester(int newSemester){
        this.semester = newSemester;
    }
    public void addCourse(String name, int unit, float finGrade, float compGrade){
        courseList.add( new Course(name, unit, finGrade, compGrade));        //create an object of course and add into the array
    }
    public int getTotalUnit(){
        int total = 0;
        for (Course course : courseList){           // get Course from courseList and copies it
            total += course.getUnit();
        }
        return total;
    }
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
        System.out.println("Total Units: \t"+getTotalUnit());
    }
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
}