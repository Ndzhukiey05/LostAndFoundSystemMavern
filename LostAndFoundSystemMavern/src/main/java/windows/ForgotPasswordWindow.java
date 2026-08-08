//240822757
package windows;

//import java.awt.BorderLayout;
//import java.awt.FlowLayout;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
import constants.Colors;
import constants.Fonts;
import components.UIComponents;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Pattern;

public class ForgotPasswordWindow extends JFrame {

//    private JPanel northPanel;
//    private JLabel title;
    private UIComponents.RoundedTextField txtUsername;
    private UIComponents.RoundedTextField txtPetName;
    private UIComponents.RoundedPasswordField txtNewPassword;
    private UIComponents.RoundedPasswordField txtConfirmPassword;

    public ForgotPasswordWindow() {

//        title = new JLabel("Forgot Password");
//        northPanel = new JPanel();
//
//        guiSetUp();
        setTitle("Forgot Password");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Full screen setup
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(800, 600));

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Colors.MAIN_BACKGROUND_COLOR);
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Title
        JLabel lblTitle = new JLabel("Forgot Password");
        lblTitle.setFont(Fonts.Bold != null ? Fonts.Bold.deriveFont(26f) : new Font("SansSerif", Font.BOLD, 26));
        lblTitle.setForeground(Colors.WHITE_TEXT_COLOR);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(lblTitle, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;

        // Username
        gbc.gridy = 1;
        gbc.gridx = 0;
        mainPanel.add(createLabel("Username:"), gbc);
        txtUsername = new UIComponents.RoundedTextField(18);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(txtUsername, gbc);

        // Security Question
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(createLabel("What is your pets name?"), gbc);
        txtPetName = new UIComponents.RoundedTextField(18);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(txtPetName, gbc);

        // New Password
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(createLabel("New Password:"), gbc);
        txtNewPassword = new UIComponents.RoundedPasswordField(18);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(txtNewPassword, gbc);

        // Confirm Password
        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(createLabel("Confirm New Password:"), gbc);
        txtConfirmPassword = new UIComponents.RoundedPasswordField(18);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(txtConfirmPassword, gbc);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttonPanel.setOpaque(false);

        UIComponents.RoundedButton btnCancel = new UIComponents.RoundedButton("Cancel", Colors.BLACK_BUTTON_COLOR, Colors.WHITE_TEXT_COLOR, 20);
        btnCancel.setPreferredSize(new Dimension(110, 35));
        btnCancel.addActionListener(e -> {
            dispose();
            new ProfileWindow().setVisible(true);
        });

        UIComponents.RoundedButton btnSave = new UIComponents.RoundedButton("Save Changes", Colors.WHITE_TEXT_COLOR, Colors.BLACK_TEXT_COLOR, 20);
        btnSave.setPreferredSize(new Dimension(130, 35));
        btnSave.addActionListener(e -> validateAndSave());

        buttonPanel.add(btnCancel);
        buttonPanel.add(btnSave);

        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(25, 10, 10, 10);
        mainPanel.add(buttonPanel, gbc);

        add(mainPanel);
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(Fonts.Medium != null ? Fonts.Medium.deriveFont(14f) : new Font("SansSerif", Font.PLAIN, 14));
        label.setForeground(Colors.WHITE_TEXT_COLOR);
        return label;
    }

    private void validateAndSave() {
        String username = txtUsername.getText().trim();
        String petName = txtPetName.getText().trim();
        String password = new String(txtNewPassword.getPassword());
        String confirmPassword = new String(txtConfirmPassword.getPassword());

        if (username.isEmpty() || petName.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (password.length() < 6) {
            JOptionPane.showMessageDialog(this, "Password must be at least 6 characters long.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "Password updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        dispose();
        new LogInWindow().setVisible(true);
    }
}
