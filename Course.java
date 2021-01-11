public class Course {
    private String courseName;
    private int unit;
    private float finalGrade;
    private float completionGrade;
    public Course(String name, int unit, float finGrade, float compGrade){
        this.courseName = name;
        this.unit = unit;
        this.finalGrade = finGrade;
        this.completionGrade = compGrade;
    }
    public String getName(){
        return courseName;
    }
    public void setName(String newName){
        this.courseName = newName;
    }
    public int getUnit(){
        return unit;
    }
    public void setUnit(int newUnit){
        this.unit = newUnit;
    }
    public float getfinGrade(){
        return finalGrade;
    }
    public void setfinGrade(float finGrade){
        this.finalGrade = finGrade;
    }
    public float getcompGrade(){
        return completionGrade;
    }
    public void setcompGrade(float compGrade){
        this.completionGrade = compGrade;
    }
}
