import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentManager implements StudentService {
    private int bestStudentID;
    private List<Student> studentList;

    public int getBestStudentID() {
        return bestStudentID;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setBestStudentID(int bestStudentID) {
        this.bestStudentID = bestStudentID;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public StudentManager(List<Student> studentList) {
        this.studentList = studentList;
    }

    public StudentManager() {
        this.studentList = new ArrayList<>();
    }

    @Override
    public float calculateAvg(Student student) {
        float sum = 0;
        Map<String,Float> grades = student.getGrades();

        if (grades != null){
            if(grades.isEmpty()){
                return 0;
            }
            for (Map.Entry<String,Float> grade: grades.entrySet()){
                sum += grade.getValue();
            }
            return sum/grades.size();
        }
        return 0;
    }

    public List<Student> findBestStudents(List<Student> studentList) {
        List<Student> bestStudentList = new ArrayList<Student>();
        float bestAvg = 0;
        if(studentList != null) {

            for (Student student : studentList) {
                if (student.getAvg() >= bestAvg) {
                    bestAvg = student.getAvg();
                    bestStudentList.add(student);
                }
            }
        }
        return bestStudentList;
    }

    @Override
    public List<Student> showVeryBadStudents(List<Student> studentList) {
        List<Student> veryBadStudentList = new ArrayList<Student>();
        if(studentList != null) {
            for (Student student : studentList) {
                if (student.getRank() == StudentRank.VERY_BAD) {
                    veryBadStudentList.add(student);
                }
            }
        }
        return veryBadStudentList;
    }

    @Override
    public List<Student> findStudentByName(String name) {
        List<Student> searchResult = new ArrayList<Student>();
        for(Student student: this.getStudentList()){
            if(student.getName().toUpperCase().contains(name.toUpperCase())){
                searchResult.add(student);
            }
        }
        return searchResult;
    }

    @Override
    public Student findStudentbyId(String studentID) {
        for(Student student: this.getStudentList()){
            if(student.getStudentID().equals(studentID)){
                return student;
            }
        }
        return null;
    }

    @Override
    public boolean addStudent(Student student) {
        Student foundStudent = findStudentbyId(student.getStudentID());
        if(foundStudent == null) {
            this.getStudentList().add(student);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteStudent(String studentID) {
        Student student = findStudentbyId(studentID);
        if(student != null){
            this.getStudentList().remove(student);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "StudentManager{" +
                "bestStudentID=" + bestStudentID +
                ", studentList=" + studentList +
                '}';
    }
}
