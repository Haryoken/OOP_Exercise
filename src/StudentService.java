import java.util.List;

public interface StudentService {
    public float calculateAvg(Student student);
    public List<Student> findBestStudents(List<Student> studentList);
    public List<Student> showVeryBadStudents(List<Student> studentList);
    public List<Student> findStudentByName(String name);
    public Student findStudentbyId(String studentID);

    public boolean addStudent(Student student);
    public boolean deleteStudent(String studentID);
}
