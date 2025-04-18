public class Student {
    private int studentId;
    private String name;
    private String dateOfBirth; 
    private String gender;
    private String phoneNumber;
    private String classroomId;  

    public Student(int studentId, String name, String dateOfBirth, String gender, String phoneNumber, String classroomId) {
        this.studentId = studentId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.classroomId = classroomId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(String classroomId) {
        this.classroomId = classroomId;
    }

    public static Student fromCSV(String line) {
        String[] fields = line.split(",");
        int id = Integer.parseInt(fields[0].trim());
        return new Student(id, fields[1].trim(), fields[2].trim(), fields[3].trim(), fields[4].trim(), fields[5].trim());
    }

    // Chuyển đổi đối tượng sang CSV
    public String toCSV() {
        return studentId + "," + name + "," + dateOfBirth + "," + gender + "," + phoneNumber + "," + classroomId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", classroomId='" + classroomId + '\'' +
                '}';
    }
}
