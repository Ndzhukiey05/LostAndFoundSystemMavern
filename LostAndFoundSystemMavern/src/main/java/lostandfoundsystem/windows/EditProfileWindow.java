//240822757
package lostandfoundsystem.windows;

import lostandfoundsystem.constants.Colors;
import lostandfoundsystem.constants.Fonts;
import lostandfoundsystem.components.UIComponents;

import lostandfoundsystem.domain.User;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.regex.Pattern;

import lostandfoundsystem.dao.ProfileDAO;

public class EditProfileWindow extends JFrame {

//    private JPanel northPanel;
//    private JLabel title;
    private User currentUser;

    private UIComponents.RoundedTextField txtName;
    private UIComponents.RoundedTextField txtSurname;
    private UIComponents.RoundedTextField txtEmail;
    private JComboBox<String> cbSecurityQuestions;
    private File selectedImageFile;

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    public EditProfileWindow(User currentUser) {

//        title = new JLabel("Edit Profile");
//        northPanel = new JPanel();
//
//        guiSetUp();
        setTitle("Edit Profile Window");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Full screen setup
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(800, 600));

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Colors.MAIN_BACKGROUND_COLOR);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 10, 8, 10);

        // Title
        JLabel lblTitle = new JLabel("EDIT PROFILE");
        lblTitle.setFont(Fonts.Bold != null ? Fonts.Bold.deriveFont(22f) : new Font("SansSerif", Font.BOLD, 22));
        lblTitle.setForeground(Colors.WHITE_TEXT_COLOR);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(lblTitle, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;

        // Name
        gbc.gridy = 1;
        gbc.gridx = 0;
        mainPanel.add(createLabel("Name:"), gbc);
        txtName = new UIComponents.RoundedTextField(18);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(txtName, gbc);

        // Surname
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(createLabel("Surname:"), gbc);
        txtSurname = new UIComponents.RoundedTextField(18);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(txtSurname, gbc);

        // Email
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(createLabel("Email:"), gbc);
        txtEmail = new UIComponents.RoundedTextField(18);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(txtEmail, gbc);

        // Security Question Dropdown
        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(createLabel("Update Security Question:"), gbc);

        String[] questions = {
            "Select Question...",
            "What is your pet's name?",
            "What is your mother's maiden name?",
            "What was your first school's name?"
        };
        cbSecurityQuestions = new JComboBox<>(questions);
        cbSecurityQuestions.setPreferredSize(new Dimension(210, 30));
        cbSecurityQuestions.setBackground(Color.WHITE);
        cbSecurityQuestions.setFont(Fonts.Regular != null ? Fonts.Regular.deriveFont(12f) : new Font("SansSerif", Font.PLAIN, 12));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(cbSecurityQuestions, gbc);

        // Upload Image Drop Area
        UIComponents.RoundedPanel uploadPanel = new UIComponents.RoundedPanel(15, Color.WHITE);
        uploadPanel.setPreferredSize(new Dimension(220, 120));
        uploadPanel.setLayout(new GridBagLayout());

        JButton btnUpload = new JButton(" Upload Image");
        btnUpload.setFont(Fonts.Medium != null ? Fonts.Medium.deriveFont(13f) : new Font("SansSerif", Font.PLAIN, 13));
        btnUpload.setFocusPainted(false);
        btnUpload.setContentAreaFilled(false);
        btnUpload.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnUpload.addActionListener(e -> chooseImage());

        uploadPanel.add(btnUpload);

        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15, 10, 15, 10);
        mainPanel.add(uploadPanel, gbc);

        // Action Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttonPanel.setOpaque(false);

        UIComponents.RoundedButton btnCancel = new UIComponents.RoundedButton("Cancel", Colors.BLACK_BUTTON_COLOR, Colors.WHITE_TEXT_COLOR, 20);
        btnCancel.setPreferredSize(new Dimension(100, 35));
        btnCancel.addActionListener(e -> {
            dispose();
            new ProfileWindow(currentUser).setVisible(true);
        });

        UIComponents.RoundedButton btnSave = new UIComponents.RoundedButton("Save Changes", Colors.WHITE_TEXT_COLOR, Colors.BLACK_TEXT_COLOR, 20);
        btnSave.setPreferredSize(new Dimension(130, 35));
        btnSave.addActionListener(e -> validateAndSave());

        buttonPanel.add(btnCancel);
        buttonPanel.add(btnSave);

        gbc.gridy = 6;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        mainPanel.add(buttonPanel, gbc);

        add(mainPanel);
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(Fonts.Medium != null ? Fonts.Medium.deriveFont(14f) : new Font("SansSerif", Font.PLAIN, 14));
        label.setForeground(Colors.WHITE_TEXT_COLOR);
        return label;
    }

    private void chooseImage() {
        JFileChooser chooser = new JFileChooser();
        int res = chooser.showOpenDialog(this);
        if (res == JFileChooser.APPROVE_OPTION) {
            selectedImageFile = chooser.getSelectedFile();
            JOptionPane.showMessageDialog(this, "Selected file: " + selectedImageFile.getName());
        }
    }

    private void validateAndSave() {
        String name = txtName.getText().trim();
        String surname = txtSurname.getText().trim();
        String email = txtEmail.getText().trim();
        int questionIndex = cbSecurityQuestions.getSelectedIndex();
        String securityQuestion = (String) cbSecurityQuestions.getSelectedItem();

        if (name.isEmpty() || surname.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all text fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!EMAIL_PATTERN.matcher(email).matches()) {
            JOptionPane.showMessageDialog(this, "Please enter a valid email address.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (questionIndex <= 0) {
            JOptionPane.showMessageDialog(this, "Please select a valid security question.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "Profile updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

        // Dispose EditProfileWindow and re-open ProfileWindow
        dispose();
        new ProfileWindow(currentUser).setVisible(true);

        ProfileDAO profileDAO = new ProfileDAO();
        boolean updated = profileDAO.updateUserProfile(currentUser, name, surname, email, securityQuestion);

        if (updated) {
            JOptionPane.showMessageDialog(this, "Profile updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            new ProfileWindow(currentUser).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Failed to update profile. Please check database connection.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

//    private void guiSetUp() {
//
//        northPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
//        northPanel.add(title);
//
//        setLayout(new BorderLayout());
//        add(northPanel, BorderLayout.NORTH);
//
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setVisible(true);
//    }

