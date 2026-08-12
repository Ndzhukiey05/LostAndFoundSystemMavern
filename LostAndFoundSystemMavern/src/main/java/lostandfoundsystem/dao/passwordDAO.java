package lostandfoundsystem.dao;

// 240822757

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import lostandfoundsystem.connection.DBConnection;

public class passwordDAO {
    
    private Connection con;
    private PreparedStatement pstmt;
    
    public passwordDAO() {
        
        try {
            con = DBConnection.derbyConnection();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(
                    Level.SEVERE,
                    null,
                    ex
            );
        }
    }
    
    public boolean updatePassword(Connection con, String userEmail, String newPassword) {
        String updatePassword = "UPDATE person_id SET password = ? WHERE email = ?";
        
        try (PreparedStatement pstmt = con.prepareStatement(updatePassword)) {
            
            pstmt.setString(1, newPassword);
            pstmt.setString(2, userEmail);

            int rowsAffected = pstmt.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            System.err.println("Database error while updating password: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }    
    
    private void closeStatement() {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                    null,
                    ex.getMessage()
            );
        }
    }
    
}
