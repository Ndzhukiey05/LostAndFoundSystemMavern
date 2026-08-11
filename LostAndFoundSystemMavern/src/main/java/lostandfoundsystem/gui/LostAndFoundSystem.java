package lostandfoundsystem.gui;
// 230939023
// WE EXPECT A USER TO LOG_IN OR SIGN_UP
// THEREFORE WE USE THE LogInWindow AS OUR ENTRY POINT FOR THE APP
// LOST AND FOUND PROJECT SETUP COMPLETE
import javax.swing.JFrame;
import lostandfoundsystem.windows.Dashboard;
public class LostAndFoundSystem {
    public static void main(String[] args) {
        //Entry Point set to DASHBOARD until ready for testing and bug fixes       
        Dashboard LogInGui = new Dashboard();
        // FULLSCREEN             
        LogInGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // LogInGui.setSize(900, 600); 
        LogInGui.setExtendedState(JFrame.MAXIMIZED_BOTH);
        LogInGui.setLocationRelativeTo(null);
        LogInGui.setVisible(true);
    }
}