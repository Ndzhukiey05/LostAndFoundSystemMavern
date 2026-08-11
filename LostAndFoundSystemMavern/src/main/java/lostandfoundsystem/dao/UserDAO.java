package lostandfoundsystem.dao;

import lostandfoundsystem.domain.*;
import lostandfoundsystem.connection.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {

    // SAVES A STUDENT USER
    public boolean saveStudent(Student student) {

        String sql = "INSERT INTO USERS "
                + "(name, surname, password, sec_question, sec_answer, role, student_number) "
                + "VALUES ('"
                + student.getName() + "', '"
                + student.getSurname() + "', '"
                + student.getPassword() + "', '"
                + student.getSecQuestion() + "', '"
                + student.getSecAnswer() + "', "
                + "'STUDENT', '"
                + student.getStudentNumber() + "')";

        try {
            Connection conn = DBConnection.derbyConnection();
            Statement stmt = conn.createStatement();

            int result = stmt.executeUpdate(sql);

            return result > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // SAVES A STAFF USER
    public boolean saveStaff(Staff staff) {

        String sql = "INSERT INTO USERS "
                + "(name, surname, password, sec_question, sec_answer, role, employee_id, department) "
                + "VALUES ('"
                + staff.getName() + "', '"
                + staff.getSurname() + "', '"
                + staff.getPassword() + "', '"
                + staff.getSecQuestion() + "', '"
                + staff.getSecAnswer() + "', "
                + "'STAFF', '"
                + staff.getEmployeeId() + "', '"
                + staff.getDepartment() + "')";

        try {
            Connection conn = DBConnection.derbyConnection();
            Statement stmt = conn.createStatement();

            int result = stmt.executeUpdate(sql);

            return result > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // SAVES A LECTURER USER
    public boolean saveLecturer(Lecturer lecturer) {

        String sql = "INSERT INTO USERS "
                + "(name, surname, password, sec_question, sec_answer, role, employee_id, department) "
                + "VALUES ('"
                + lecturer.getName() + "', '"
                + lecturer.getSurname() + "', '"
                + lecturer.getPassword() + "', '"
                + lecturer.getSecQuestion() + "', '"
                + lecturer.getSecAnswer() + "', "
                + "'LECTURER', '"
                + lecturer.getEmployeeId() + "', '"
                + lecturer.getDepartment() + "')";

        try {
            Connection conn = DBConnection.derbyConnection();
            Statement stmt = conn.createStatement();

            int result = stmt.executeUpdate(sql);

            return result > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // SAVES AN ADMIN USER
    public boolean saveAdmin(Admin admin) {

        String sql = "INSERT INTO USERS "
                + "(name, surname, password, sec_question, sec_answer, role, employee_id, department, access_level) "
                + "VALUES ('"
                + admin.getName() + "', '"
                + admin.getSurname() + "', '"
                + admin.getPassword() + "', '"
                + admin.getSecQuestion() + "', '"
                + admin.getSecAnswer() + "', "
                + "'ADMIN', '"
                + admin.getEmployeeId() + "', '"
                + admin.getDepartment() + "', "
                + admin.getAccessLevel() + ")";

        try {
            Connection conn = DBConnection.derbyConnection();
            Statement stmt = conn.createStatement();

            int result = stmt.executeUpdate(sql);

            return result > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // AUTHENTICATES USER
    public User login(String identifier, String password) {

        String sql = "SELECT * FROM USERS "
                + "WHERE (student_number = '" + identifier + "' "
                + "OR employee_id = '" + identifier + "' "
                + "OR CAST(person_id AS VARCHAR(20)) = '" + identifier + "') "
                + "AND password = '" + password + "'";

        try {
            Connection conn = DBConnection.derbyConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {

                String role = rs.getString("role");

                // STUDENT
                if ("STUDENT".equalsIgnoreCase(role)) {

                    return new Student(
                            rs.getInt("person_id"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getString("password"),
                            rs.getString("sec_question"),
                            rs.getString("sec_answer"),
                            rs.getString("student_number")
                    );
                }

                // ADMIN
                else if ("ADMIN".equalsIgnoreCase(role)) {

                    return new Admin(
                            rs.getInt("person_id"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getString("password"),
                            rs.getString("sec_question"),
                            rs.getString("sec_answer"),
                            rs.getString("employee_id"),
                            rs.getString("department"),
                            rs.getInt("access_level")
                    );
                }

                // LECTURER
                else if ("LECTURER".equalsIgnoreCase(role)) {

                    return new Lecturer(
                            rs.getInt("person_id"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getString("password"),
                            rs.getString("sec_question"),
                            rs.getString("sec_answer"),
                            rs.getString("employee_id"),
                            rs.getString("department")
                    );
                }

                // STAFF
                else if ("STAFF".equalsIgnoreCase(role)) {

                    return new Staff(
                            rs.getInt("person_id"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getString("password"),
                            rs.getString("sec_question"),
                            rs.getString("sec_answer"),
                            rs.getString("employee_id"),
                            rs.getString("department")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}