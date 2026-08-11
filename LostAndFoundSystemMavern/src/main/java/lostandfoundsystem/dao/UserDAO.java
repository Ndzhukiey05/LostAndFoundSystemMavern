package lostandfoundsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import lostandfoundsystem.connection.DBConnection;
import lostandfoundsystem.domain.Admin;
import lostandfoundsystem.domain.Lecturer;
import lostandfoundsystem.domain.Staff;
import lostandfoundsystem.domain.Student;
import lostandfoundsystem.domain.User;

public class UserDAO {

    private Connection con;
    private Statement stmt;
    private PreparedStatement pstmt;

    public UserDAO() {
        try {
            con = DBConnection.derbyConnection();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // SAVES A STUDENT USER
    public void saveStudent(Student student) {

        int ok;

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
            stmt = this.con.createStatement();
            ok = stmt.executeUpdate(sql);

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    "SQL Error: " + sqlException.getMessage());

        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,
                        exception.getMessage());
            }
        }
    }

    // SAVES A STAFF USER
    public void saveStaff(Staff staff) {

        int ok;

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
            stmt = this.con.createStatement();
            ok = stmt.executeUpdate(sql);

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    "SQL Error: " + sqlException.getMessage());

        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,
                        exception.getMessage());
            }
        }
    }

    // SAVES A LECTURER USER
    public void saveLecturer(Lecturer lecturer) {

        int ok;

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
            stmt = this.con.createStatement();
            ok = stmt.executeUpdate(sql);

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    "SQL Error: " + sqlException.getMessage());

        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,
                        exception.getMessage());
            }
        }
    }

    // SAVES AN ADMIN USER
    public void saveAdmin(Admin admin) {

        int ok;

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
            stmt = this.con.createStatement();
            ok = stmt.executeUpdate(sql);

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    "SQL Error: " + sqlException.getMessage());

        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,
                        exception.getMessage());
            }
        }
    }

    // AUTHENTICATE USER
    public User login(String identifier, String password) {

        String sql = "SELECT * FROM USERS "
                + "WHERE (student_number = ? "
                + "OR employee_id = ? "
                + "OR CAST(person_id AS VARCHAR(20)) = ?) "
                + "AND password = ?";

        try {
            pstmt = this.con.prepareStatement(sql);

            pstmt.setString(1, identifier);
            pstmt.setString(2, identifier);
            pstmt.setString(3, identifier);
            pstmt.setString(4, password);

            ResultSet rs = pstmt.executeQuery();

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

            rs.close();

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null,
                    "SQL Error: " + sqlException.getMessage());

        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null,
                        exception.getMessage());
            }
        }

        return null;
    }
}