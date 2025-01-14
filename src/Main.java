import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static StudentManager studentManager = new StudentManager();
    public static void main(String[] args) {
        boolean isRunning = true;
        int currentChoice = 0;


        System.out.println("WELCOME TO STUDENT MANAGEMENT PROGRAM.");
        do {
            try {
                System.out.println("Your class is currently having " + studentManager.getStudentList().size() + " student(s).");
                printFunctionList();
                System.out.println("You Choose:");
                try {
                    currentChoice = scanner.nextInt();
                }catch(Exception e){
                    System.out.println("Invalid option.");
                    scanner.nextLine();
                    continue;
                }
                switch (currentChoice) {
                    case 1:
                        scanner.nextLine();
                        addStudent();
                        break;
                    case 2:
                        scanner.nextLine();
                        addStudentWithGrade();
                        break;
                    case 3:
                        scanner.nextLine();
                        addGradeToStudent();
                        break;
                    case 4:
                        scanner.nextLine();
                        removeStudent();
                        break;
                    case 5:
                        listAllStudent();
                        break;
                    case 6:
                        scanner.nextLine();
                        findStudentByName();
                        break;
                    case 7:
                        scanner.nextLine();
                        findStudentByID();
                        break;
                    case 8:
                        showBestStudentsByAVG();
                        break;
                    case 9:
                        showVeryBadStudents();
                        break;
                    case 10:
                        System.out.println("THANK YOU FOR USING OUR PROGRAM.EXIT NOW.");
                        isRunning = false;
                        break;
                    case 666:
                        mockStudents();
                        break;
                    default:
                        System.out.println("Invalid option. Please choose again.");
                        break;
                }

            }catch (Exception e){
                System.out.println("error:"+e.getMessage());

            }
        }while(isRunning);
    }
    private static void mockStudents(){
        Student student = new Student("OOP1","Ha");
        student.getGrades().put("MATH",9.0f);
        student.getGrades().put("PHYS",10.0f);
        student.getGrades().put("CHEM",9.0f);
        refreshStudent(student);
        studentManager.addStudent(student);

        student = new Student("OOP2","Hana");
        student.getGrades().put("MATH",7.0f);
        student.getGrades().put("PHYS",7.0f);
        student.getGrades().put("CHEM",9.0f);
        refreshStudent(student);
        studentManager.addStudent(student);

        student = new Student("OOP3","Nabi");
        student.getGrades().put("MATH",9.0f);
        student.getGrades().put("PHYS",6.0f);
        student.getGrades().put("CHEM",4.0f);
        refreshStudent(student);
        studentManager.addStudent(student);

        student = new Student("OOP4","Karina");
        student.getGrades().put("MATH",4.0f);
        student.getGrades().put("PHYS",4.0f);
        student.getGrades().put("CHEM",4.0f);
        refreshStudent(student);
        studentManager.addStudent(student);

        student = new Student("OOP4","Sol");
        student.getGrades().put("MATH",5.0f);
        student.getGrades().put("PHYS",5.0f);
        student.getGrades().put("CHEM",5.0f);
        refreshStudent(student);
        studentManager.addStudent(student);

        student = new Student("OOP5","Jane");
        student.getGrades().put("MATH",3.0f);
        student.getGrades().put("PHYS",2.0f);
        student.getGrades().put("CHEM",1.0f);
        refreshStudent(student);
        studentManager.addStudent(student);
    }
    public static void printFunctionList(){
        System.out.println("FUNCTION MENU:");
        System.out.println("1.Add a new Student");
        System.out.println("2.Add a new Student with Grades");
        System.out.println("3.Add Grade to Student");
        System.out.println("4.Remove a Student");
        System.out.println("5.List all students");
        System.out.println("6.Find student by Name");
        System.out.println("7.Find student by Student ID");
        System.out.println("8.Show the best student by Grade AVG");
        System.out.println("9.Show the VERY_BAD Student list");
        System.out.println("666.To mock data");
        System.out.println("10.EXIT");

    }

    public static void addStudent(){
        String studentName;
        String studentID;

        System.out.println("==============ADD A NEW STUDENT==============");
        System.out.println("Please Enter Student Name:");
        studentName = scanner.nextLine();
        System.out.println("Please Enter Student ID:");
        studentID = scanner.nextLine();

        Student student = new Student(studentID,studentName);
        if(studentManager.addStudent(student)){
            System.out.println("Student "+student.getName()+" has been added.");
            System.out.println(student.toString());
        } else {
            System.out.println("Student with ID: "+student.getStudentID() +" already existed.");
        }
        System.out.println("============================================");
    }

    private static void refreshStudent(Student student){
        student.setAvg(studentManager.calculateAvg(student));
        student.setRank(StudentRank.getRankByGrade(student.getAvg()));
        System.out.println(student.toString());
    }
    public static void addGradeToStudent(){
        String studentID;
        System.out.println("Please Enter Student ID:");
        studentID = scanner.nextLine();
        String subject;
        float grade;

        Student  student = studentManager.findStudentbyId(studentID);
        if(student != null){
            System.out.println(student.toString());
            while(true){
                System.out.println("Please Enter Subject Name:");
                subject = scanner.nextLine();
                System.out.println("Grade for "+subject+":");
                grade = scanner.nextFloat();
                student.getGrades().put(subject,grade);
                refreshStudent(student);
                scanner.nextLine();
                System.out.println("Continue? Y/N");
                String choice = scanner.nextLine();
                if(choice.equals("Y")){
                    System.out.println("Adding another grade.");

                }else{
                    break;
                }
            }
        }else{
            System.out.println("Student "+studentID +" not found.");
        }
    }

    public static void addStudentWithGrade(){
        String studentName;
        String studentID;
        float math;
        float phys;
        float chem;

        System.out.println("==============ADD A NEW STUDENT WITH GRADE==============");
        System.out.println("Please Enter Student Name:");
        studentName = scanner.nextLine();
        System.out.println("Please Enter Student ID:");
        studentID = scanner.nextLine();
        System.out.println("Please Enter MATH GRADE:");
        math = scanner.nextFloat();
        System.out.println("Please Enter PHYSIC GRADE:");
        phys = scanner.nextFloat();
        System.out.println("Please Enter CHEMISTRY GRADE:");
        chem = scanner.nextFloat();

        Student student = new Student(studentID,studentName);
        student.getGrades().put("MATH",math);
        student.getGrades().put("PHYS",phys);
        student.getGrades().put("CHEM",chem);
        refreshStudent(student);

        if(studentManager.addStudent(student)){
            System.out.println("Student "+student.getName()+" has been added.");
            System.out.println(student.toString());
        } else {
            System.out.println("Student with ID: "+student.getStudentID() +" already existed.");
        }
        System.out.println("============================================");
    }

    public static void removeStudent(){
        String studentName;
        String studentID;

        System.out.println("==============REMOVE A STUDENT==============");
        System.out.println("Please Enter Student ID:");
        studentID = scanner.nextLine();
        if(studentManager.deleteStudent(studentID)){
            System.out.println("Student "+studentID+" has been removed.");
        } else {
            System.out.println("Student "+studentID +" not found.");
        }
        System.out.println("============================================");
    }

    public static void listAllStudent(){
        System.out.println("==============STUDENT LIST==============");
        for(Student student:studentManager.getStudentList()){
            System.out.println(student.toString());
        }
        System.out.println("============================================");
    }

    public static void findStudentByName(){
        System.out.println("==============FIND STUDENT BY NAME==============");
        System.out.println("Please Enter Student Name:");
        String studentName = scanner.nextLine();
        List<Student> studentList = studentManager.findStudentByName(studentName);
        if(!studentList.isEmpty()){
            for(Student student:studentList){
                System.out.println(student.toString());
            }
        }else {
            System.out.println("No student match.");
        }
        System.out.println("================================================");
    }

    public static void findStudentByID(){
        System.out.println("==============FIND STUDENT BY ID==============");
        System.out.println("Please Enter Student ID:");
        String studentId = scanner.nextLine();
        Student student = studentManager.findStudentbyId(studentId);
        if(student != null){
            System.out.println(student.toString());
        }else {
            System.out.println("No student match.");
        }
        System.out.println("===============================================");
    }

    public static void showBestStudentsByAVG(){
        System.out.println("==============THE BEST STUDENT(S) BY AVG GRADE ==============");
        List<Student> studentList = studentManager.findBestStudents(studentManager.getStudentList());
        if(!studentList.isEmpty()){
            for(Student student:studentList){
                System.out.println(student.toString());
            }
        }else {
            System.out.println("No student found.");
        }
        System.out.println("===============================================");
    }

    public static void showVeryBadStudents(){
        System.out.println("==============VERY_BAD STUDENT LIST ==============");
        List<Student> studentList = studentManager.showVeryBadStudents(studentManager.getStudentList());
        if(!studentList.isEmpty()){
            for(Student student:studentList){
                System.out.println(student.toString());
            }
        }else {
            System.out.println("No student found.");
        }
        System.out.println("===============================================");
    }
}