package lostandfoundsystem.dao;

// 240822757

import lostandfoundsystem.connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import lostandfoundsystem.domain.User;

public class ProfileDAO {
    
    public boolean updateUserProfile(User currentUser, String name, String surname, String email, String securityQuestion) {
        String query = "UPDATE users SET first_name = ?, last_name = ?, email = ?, security_question = ? WHERE username = ?";

        try (Connection conn = DBConnection.derbyConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setString(2, surname);
            stmt.setString(3, email);
            stmt.setString(4, securityQuestion);
            stmt.setInt(5, currentUser.getPersonId());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Map<String, String> getUserProfile(int userId) {
        Map<String, String> userData = new HashMap<>();
        String query = "SELECT first_name, last_name, email, role FROM users WHERE user_id = ?";

        try (Connection conn = DBConnection.derbyConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String fullName = rs.getString("first_name") + " " + rs.getString("last_name");
                    userData.put("fullName", fullName);
                    userData.put("email", rs.getString("email"));
                    userData.put("role", rs.getString("role"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userData;
    }
    
    // Option A: Soft Delete (Deactivation - Recommended)
    public boolean deactivateUserAccount(int userId) {
        String query = "UPDATE users SET is_active = false WHERE user_id = ?";

        try (Connection conn = DBConnection.derbyConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteUserAccount(int userId) {
        String query = "DELETE FROM users WHERE user_id = ?";

        try (Connection conn = DBConnection.derbyConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
