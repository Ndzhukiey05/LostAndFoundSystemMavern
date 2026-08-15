package lostandfoundsystem.dao;

//240822757

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import lostandfoundsystem.connection.DBConnection;
import lostandfoundsystem.domain.Admin;
import lostandfoundsystem.domain.Lecturer;
import lostandfoundsystem.domain.Staff;
import lostandfoundsystem.domain.Student;
import lostandfoundsystem.domain.User;

public class ProfileDAO {

    private String getTableName(User user) {

        if (user instanceof Student) {
            return "STUDENT";
        }

        if (user instanceof Lecturer) {
            return "LECTURER";
        }

        if (user instanceof Staff) {
            return "STAFF";
        }

        if (user instanceof Admin) {
            return "ADMIN";
        }

        return null;
    }

    public boolean updateUserProfile(User currentUser,
            String name,
            String surname,
            String securityQuestion) {

        String table = getTableName(currentUser);

        if (table == null) {
            return false;
        }

        String query = "UPDATE " + table
                + " SET name=?, surname=?, sec_question=? "
                + "WHERE person_id=?";

        try (Connection conn = DBConnection.derbyConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setString(2, surname);
            stmt.setString(3, securityQuestion);
            stmt.setInt(4, currentUser.getPersonId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }

    public Map<String, String> getUserProfile(User currentUser) {

        Map<String, String> userData = new HashMap<>();

        String table = getTableName(currentUser);

        if (table == null) {
            return userData;
        }

        String query = "SELECT name, surname FROM "
                + table
                + " WHERE person_id=?";

        try (Connection conn = DBConnection.derbyConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, currentUser.getPersonId());

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {

                    userData.put(
                            "fullName",
                            rs.getString("name")
                            + " "
                            + rs.getString("surname")
                    );

                    userData.put("role", table);
                }
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return userData;
    }

    public boolean deleteUserAccount(User currentUser) {

        String table = getTableName(currentUser);

        if (table == null) {
            return false;
        }

        String query = "DELETE FROM "
                + table
                + " WHERE person_id=?";

        try (Connection conn = DBConnection.derbyConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, currentUser.getPersonId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }
}