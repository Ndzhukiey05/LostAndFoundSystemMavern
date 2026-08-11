package lostandfoundsystem.dao;

import lostandfounfsystem.domain.*;
import lostandfoundsystem.connection.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    // SAVES A STUDENT USER
    public boolean saveStudent(Student student) {
        String sql = "INSERT INTO USERS (name, surname, password, sec_question, sec_answer, role, student_number, course) " +
                     "VALUES (?, ?, ?, ?, ?, 'STUDENT', ?, ?)";

        try (Connection conn = DBConnection.derbyConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getSurname());
            pstmt.setString(3, student.getPassword());
            pstmt.setString(4, student.getSecQuestion());
            pstmt.setString(5, student.getSecAnswer());
            pstmt.setString(6, student.getStudentNumber());
            pstmt.setString(7, student.getCourse());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // SAVES A STAFF USER
    public boolean saveStaff(Staff staff) {
        String sql = "INSERT INTO USERS (name, surname, password, sec_question, sec_answer, role, employee_id, department) " +
                     "VALUES (?, ?, ?, ?, ?, 'STAFF', ?, ?)";

        try (Connection conn = DBConnection.derbyConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, staff.getName());
            pstmt.setString(2, staff.getSurname());
            pstmt.setString(3, staff.getPassword());
            pstmt.setString(4, staff.getSecQuestion());
            pstmt.setString(5, staff.getSecAnswer());
            pstmt.setString(6, staff.getEmployeeId());
            pstmt.setString(7, staff.getDepartment());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // SAVES A LECTURER 
    public boolean saveLecturer(Lecturer lecturer) {
        String sql = "INSERT INTO USERS (name, surname, password, sec_question, sec_answer, role, employee_id, department) " +
                     "VALUES (?, ?, ?, ?, ?, 'LECTURER', ?, ?)";

        try (Connection conn = DBConnection.derbyConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, lecturer.getName());
            pstmt.setString(2, lecturer.getSurname());
            pstmt.setString(3, lecturer.getPassword());
            pstmt.setString(4, lecturer.getSecQuestion());
            pstmt.setString(5, lecturer.getSecAnswer());
            pstmt.setString(6, lecturer.getEmployeeId());
            pstmt.setString(7, lecturer.getDepartment());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // SAVES AN ADMIN
    public boolean saveAdmin(Admin admin) {
        String sql = "INSERT INTO USERS (name, surname, password, sec_question, sec_answer, role, employee_id, department, access_level) " +
                     "VALUES (?, ?, ?, ?, ?, 'ADMIN', ?, ?, ?)";

        try (Connection conn = DBConnection.derbyConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, admin.getName());
            pstmt.setString(2, admin.getSurname());
            pstmt.setString(3, admin.getPassword());
            pstmt.setString(4, admin.getSecQuestion());
            pstmt.setString(5, admin.getSecAnswer());
            pstmt.setString(6, admin.getEmployeeId());
            pstmt.setString(7, admin.getDepartment());
            pstmt.setInt(8, admin.getAccessLevel());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Authenticate user by ID/Student Number/Employee ID and Password
    public User login(String identifier, String password) {
        String sql = "SELECT * FROM USERS WHERE (student_number = ? OR employee_id = ? OR CAST(person_id AS VARCHAR(20)) = ?) AND password = ?";

        try (Connection conn = DBConnection.derbyConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, identifier);
            pstmt.setString(2, identifier);
            pstmt.setString(3, identifier);
            pstmt.setString(4, password);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String role = rs.getString("role");

                    // Map specific subclass based on role in database
                    if ("STUDENT".equalsIgnoreCase(role)) {
                        return new Student(
                            rs.getInt("person_id"),
                            rs.getString("name"),
                            rs.getString("surname"),
                            rs.getString("password"),
                            rs.getString("sec_question"),
                            rs.getString("sec_answer"),
                            rs.getString("student_number"),
                            rs.getString("course")
                        );
                    } else if ("ADMIN".equalsIgnoreCase(role)) {
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
                    } else if ("LECTURER".equalsIgnoreCase(role)) {
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
                    } else if ("STAFF".equalsIgnoreCase(role)) {
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}