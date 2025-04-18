import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    private final List<Student> students;
    private final String STUDENT_FILE_PATH = "src/data/students.csv";
    private final String CLASSROOM_FILE_PATH= "src/data/batchs.csv";
    private final String TEACHER_FILE_PATH = "src/data/teachers.csv";
    public StudentManager() {
        students = new ArrayList<>();
        loadStudents();
    }

    public void loadStudents() {
        students.clear();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(STUDENT_FILE_PATH))) {
            String line;

            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    Student s = Student.fromCSV(line);
                    students.add(s);
                }
            }
        } catch (IOException e) {
            System.out.println("Can't read file Student : " + e.getMessage());
        }
    }

    private void saveStudents() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(STUDENT_FILE_PATH))) {
            bufferedWriter.write("studentId,name,dateOfBirth,gender,phoneNumber,classroomId");
            bufferedWriter.newLine();
            for (Student student : students) {
                bufferedWriter.write(student.toCSV());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Can't write file Student : " + e.getMessage());
        }
    }

    private int generateStudentIdAuto() {
        if (students.isEmpty()) {
            return 1;
        } else {
            return students.get(students.size() - 1).getStudentId() + 1;
        }
    }

    private boolean validateStudent(Student student) {
        if (student.getName() == null || student.getName().trim().isEmpty() ||
                student.getDateOfBirth() == null || student.getDateOfBirth().trim().isEmpty() ||
                student.getGender() == null || student.getGender().trim().isEmpty() ||
                student.getPhoneNumber() == null || student.getPhoneNumber().trim().isEmpty() ||
                student.getClassroomId() == null || student.getClassroomId().trim().isEmpty()) {
            System.out.println("Required fields cannot be left blank.");
            return false;
        }

        if (student.getName().length() < 4 || student.getName().length() > 50) {
            System.out.println("Name Student must be between 4 and 50 characters.");
            return false;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setLenient(false);
        try {
            simpleDateFormat.parse(student.getDateOfBirth());
        } catch (ParseException e) {
            System.out.println("Date of birth is not in dd/MM/yyyy format.");
            return false;
        }
        String phoneNumber = student.getPhoneNumber();
        if (!phoneNumber.matches("^(090|091)\\d{7}$")) {
            System.out.println("Phone number must be 10 digits and start with 090 or 091.");
            return false;
        }
        for (Student studentUnique : students) {
            if (studentUnique.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Phone number is already in used.");
                return false;
            }
        }
        if (!checkClassroomExists(student.getClassroomId())) {
            System.out.println("Classroom ID does not exist in validateStudent.");
            return false;
        }
        return true;
    }
    private boolean checkClassroomExists(String classroomId) {
        try (BufferedReader bufferedReader= new BufferedReader( new FileReader(CLASSROOM_FILE_PATH))){
            bufferedReader.readLine();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    Classroom classroom = Classroom.fromCSV(line);
                    if (classroom.getClassroomId().equalsIgnoreCase(classroomId)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Can't read Classroom in checkClassroomExists: " + e.getMessage());
        }
        return false;
    }


    public void addStudent(Scanner scanner) {
        System.out.println("Nhập thông tin sinh viên mới:");
        int id = generateStudentIdAuto();
        System.out.print("Tên sinh viên: ");
        String name = scanner.nextLine();
        System.out.print("Ngày sinh (dd/MM/yyyy): ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Giới tính: ");
        String gender = scanner.nextLine();
        System.out.print("Số điện thoại: ");
        String phone = scanner.nextLine();
        System.out.print("Mã lớp học: ");
        String classroomId = scanner.nextLine();

        Student student = new Student(id, name, dateOfBirth, gender, phone, classroomId);
        if (validateStudent(student)) {
            students.add(student);
            saveStudents();
            System.out.println("Add Student Successfully.");
        }
    }


    public void deleteStudent(Scanner scanner) {
        System.out.print("Nhập mã sinh viên cần xóa: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Mã sinh viên phải là số.");
            return;
        }

        Student found = null;
        for (Student s : students) {
            if (s.getStudentId() == id) {
                found = s;
                break;
            }
        }
        if (found == null) {
            try {
                throw new NotFoundStudentException("Sinh viên không tồn tại.");
            } catch (NotFoundStudentException ex) {
                System.out.println(ex.getMessage());
                return;
            }
        }

        System.out.print("Bạn có chắc chắn muốn xóa sinh viên này không (Yes/No): ");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("Yes")) {
            students.remove(found);
            saveStudents();
            System.out.println("Xóa sinh viên thành công!");
            listStudents();
        } else {
            System.out.println("Hủy thao tác xóa.");
        }
    }


    public void listStudents() {
        System.out.println("Danh sách sinh viên:");
        for (Student s : students) {
            String className = getClassroomName(s.getClassroomId());
            System.out.println(s.toString() + " - Lớp: " + className);
        }
    }

    private String getClassroomName(String classroomId) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(CLASSROOM_FILE_PATH))) {

            bufferedReader.readLine();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    Classroom classroom = Classroom.fromCSV(line);
                    if (classroom.getClassroomId().equalsIgnoreCase(classroomId)) {
                        return classroom.getClassroomName();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error when read classroom " + e.getMessage());
        }
        return "error in getClassroomName";
    }

    public void searchStudents(Scanner scanner) {
        System.out.print("Nhập từ khóa tìm kiếm theo tên sinh viên: ");
        String keyword = scanner.nextLine().toLowerCase();
        System.out.println("Kết quả tìm kiếm:");
        for (Student s : students) {
            if (s.getName().toLowerCase().contains(keyword)) {
                String className = getClassroomName(s.getClassroomId());
                System.out.println(s.toString() + " - Lớp: " + className);
            }
        }
    }

    public void viewTeacher(Scanner scanner) {
        System.out.print("Nhập mã giáo viên: ");
        String teacherId = scanner.nextLine();
        Teacher teacher = getTeacherById(teacherId);
        if (teacher != null) {
            System.out.println(teacher.toString());
        } else {
            System.out.println("Không tìm thấy giáo viên với mã: " + teacherId);
        }
    }

    private Teacher getTeacherById(String teacherId) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(TEACHER_FILE_PATH))) {
            bufferedReader.readLine();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    Teacher t = Teacher.fromCSV(line);
                    if (t.getTeacherId().equalsIgnoreCase(teacherId)) {
                        return t;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error when read Teacher in getTeacherById " + e.getMessage());
        }
        return null;
    }

}
