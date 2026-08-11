package lostandfounfsystem.domain;

//230939023

public class Student extends User {

    private String studentNumber;
    private String course;

    public Student() {
        super();
    }

    public Student(
            int personId,
            String name,
            String surname, 
            String password, 
            String secQuestion, 
            String secAnswer,
            String studentNumber, 
            String course
    ) {
        super(personId, name, surname, password, secQuestion, secAnswer);
        this.studentNumber = studentNumber;
        this.course = course;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "personId=" + getPersonId() +
                ", name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}