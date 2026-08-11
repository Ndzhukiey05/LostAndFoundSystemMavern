package lostandfoundsystem.gui;
// 230939023
// WE EXPECT A USER TO LOG_IN OR SIGN_UP
// THEREFORE WE USE THE LogInWindow AS OUR ENTRY POINT FOR THE APP
// LOST AND FOUND PROJECT SETUP COMPLETE
import javax.swing.JFrame;
import lostandfoundsystem.windows.LogInWindow;
public class LostAndFoundSystem {
    public static void main(String[] args) {
        // Entry point of the application
        LogInWindow logInGui = new LogInWindow();
        // FULLSCREEN
        logInGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logInGui.setExtendedState(JFrame.MAXIMIZED_BOTH);
        logInGui.setLocationRelativeTo(null);
        logInGui.setVisible(true);
    }
}