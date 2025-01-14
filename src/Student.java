import java.util.HashMap;
import java.util.Map;

public class Student {
    private String studentID;
    private String name;
    private StudentRank rank;
    private float avg;
    private Map<String,Float> grades;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.grades = new HashMap<>();
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }

    public StudentRank getRank() {
        return rank;
    }

    public void setRank(StudentRank rank) {
        this.rank = rank;
    }

    public Map<String, Float> getGrades() {
        return grades;
    }

    public void setGrades(Map<String, Float> grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", name='" + name + '\'' +
                ", rank=" + rank +
                ", avg=" + avg +
                ", grades=" + grades +
                '}';
    }
}

