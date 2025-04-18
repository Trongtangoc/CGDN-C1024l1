public class Classroom {
    private String classroomId;
    private String classroomName;
    private String teacherId;
    public Classroom(String classroomId, String classroomName, String teacherId) {
        this.classroomId = classroomId;
        this.classroomName = classroomName;
        this.teacherId = teacherId;
    }

    public String getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(String classroomId) {
        this.classroomId = classroomId;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
    public static Classroom fromCSV(String line) {
        String[] fields = line.split(",");
        return new Classroom(fields[0].trim(), fields[1].trim(), fields[2].trim());
    }
    public String toCSV() {
        return classroomId + "," + classroomName + "," + teacherId;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "classroomId='" + classroomId + '\'' +
                ", classroomName='" + classroomName + '\'' +
                ", teacherId='" + teacherId + '\'' +
                '}';
    }
}
