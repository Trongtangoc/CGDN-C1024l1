public class Teacher {
    private String teacherId;
    private String teacherName;
    private String dateOfBirth;
    private String gender;
    private String phoneNumber;

    public Teacher(String teacherId,
                   String teacherName,
                   String dateOfBirth,
                   String gender,
                   String phoneNumber) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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

    public static Teacher fromCSV(String line) {
        String COMMA = ",";
        String[] fields = line.split(COMMA);
        return new Teacher(fields[0].trim(), fields[1].trim(), fields[2].trim(), fields[3].trim(), fields[4].trim());
    }

    public String toCSV() {
        return teacherId + "," + teacherName + "," + dateOfBirth + "," + gender + "," + phoneNumber;
    }

    public String toString() {


        return teacherId + " - "
                + teacherName + " - "
                + dateOfBirth + " - "
                + gender + " - "
                + phoneNumber;

    }
}
