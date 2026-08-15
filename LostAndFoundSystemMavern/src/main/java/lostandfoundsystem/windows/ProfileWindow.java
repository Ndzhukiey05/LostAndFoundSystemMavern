package lostandfoundsystem.windows;

import lostandfoundsystem.components.PageHeaderPanel;
import lostandfoundsystem.components.SideBarPanel;
import lostandfoundsystem.components.UIComponents;
import lostandfoundsystem.constants.Colors;
import lostandfoundsystem.constants.Fonts;

import lostandfoundsystem.domain.User;
import lostandfoundsystem.dao.ProfileDAO;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import javax.swing.JOptionPane;

public class ProfileWindow extends JFrame {

    private User currentUser;
    private JTextField txtFullName;
    private JTextField txtEmail;
    private JTextField txtRole;

    public ProfileWindow(User currentUser) {
        this.currentUser = currentUser;
        super("Campus Finder - Profile");
        guiSetUp();
    }

    private void guiSetUp() {

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(950, 600));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(Colors.DARK_BLUE_TEXT_COLOR);
        setLayout(new BorderLayout(15, 15));

        SideBarPanel sidebarPanel = new SideBarPanel(currentUser);

        JPanel center = new JPanel(new BorderLayout(15, 15));
        center.setOpaque(false);

        PageHeaderPanel headerPanel = new PageHeaderPanel("PROFILE", currentUser);

        center.add(headerPanel, BorderLayout.NORTH);
        center.add(createProfilePanel(), BorderLayout.CENTER);

        add(sidebarPanel, BorderLayout.WEST);
        add(center, BorderLayout.CENTER);
        
        loadUserProfileData();

        setVisible(true);
    }

    private JPanel createProfilePanel() {

        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(Colors.MOCKUP_FORM_CARD_BG);
        contentPanel.setBorder(new EmptyBorder(25, 30, 25, 30));

        UIComponents.RoundedPanel profileCard = new UIComponents.RoundedPanel(20, Colors.LIGHT_GREY_BACKGROUND_COLOR);

        profileCard.setLayout(new GridBagLayout());
        profileCard.setPreferredSize(new Dimension(430, 470));
        profileCard.setBorder(new EmptyBorder(25, 35, 25, 35));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.insets = new Insets(7, 7, 7, 7);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;

        JLabel lblAvatar = new JLabel(new ImageIcon(createAvatarImage()), SwingConstants.CENTER);

        gbc.gridy = 0;

        profileCard.add(lblAvatar, gbc);

        JLabel lblProfileName = new JLabel("John Doe", SwingConstants.CENTER);

        lblProfileName.setFont(Fonts.Bold.deriveFont(20f));
        lblProfileName.setForeground(Colors.DARK_BLUE_TEXT_COLOR);

        gbc.gridy = 1;

        profileCard.add(lblProfileName, gbc);

        JLabel lblRole = new JLabel("Student", SwingConstants.CENTER);

        lblRole.setFont(Fonts.Regular.deriveFont(13f));
        lblRole.setForeground(Colors.BLACK_TEXT_COLOR);

        gbc.gridy = 2;

        profileCard.add(lblRole, gbc);

        JPanel informationPanel = new JPanel(new GridLayout(3, 1, 0, 8));

        informationPanel.setOpaque(false);
        informationPanel.setPreferredSize(new Dimension(320, 135));
//        informationPanel.add(createProfileField("John Doe"));
//        informationPanel.add(createProfileField("johndoe123@gmail.com"));
//        informationPanel.add(createProfileField("Student"));
        txtFullName = createProfileField("Loading...");
        txtEmail = createProfileField("Loading...");
        txtRole = createProfileField("Loading...");

        informationPanel.add(txtFullName);
        informationPanel.add(txtEmail);
        informationPanel.add(txtRole);

        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        profileCard.add(informationPanel, gbc);

        UIComponents.RoundedButton btnEditProfile = new UIComponents.RoundedButton(
                "Edit Profile",
                Colors.BLUE_BUTTON_COLOR,
                Colors.WHITE_TEXT_COLOR,
                15
        );

        btnEditProfile.setPreferredSize(new Dimension(140, 38));
        btnEditProfile.setFont(Fonts.Bold.deriveFont(13f));
        btnEditProfile.setFocusPainted(false);
        btnEditProfile.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnEditProfile.addActionListener(e -> {
            EditProfileWindow window = new EditProfileWindow(currentUser);
            window.setVisible(true);
            dispose();

        });

        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;

        profileCard.add(btnEditProfile, gbc);

        UIComponents.RoundedButton btnChangePassword = new UIComponents.RoundedButton(
                "Change Password",
                Colors.WHITE_TEXT_COLOR,
                Colors.BLACK_TEXT_COLOR,
                15
        );

        btnChangePassword.setPreferredSize(new Dimension(180, 35));
        btnChangePassword.setFont(Fonts.Regular.deriveFont(13f));
        btnChangePassword.setFocusPainted(false);
        btnChangePassword.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnChangePassword.addActionListener(e -> {
            ForgotPasswordWindow window = new ForgotPasswordWindow(currentUser);
            window.setVisible(true);
            dispose();
        });

        gbc.gridy = 5;

        profileCard.add(btnChangePassword, gbc);

        UIComponents.RoundedButton btnDeleteAccount = new UIComponents.RoundedButton(
                "Delete Account",
                Colors.RED_STATUS_COLOR,
                Colors.WHITE_TEXT_COLOR,
                15
        );

        btnDeleteAccount.setPreferredSize(new Dimension(180, 35));
        btnDeleteAccount.setFont(Fonts.Bold.deriveFont(13f));
        btnDeleteAccount.setFocusPainted(false);
        btnDeleteAccount.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnDeleteAccount.addActionListener(e -> confirmAndDeleteAccount());

        gbc.gridy = 6;
        profileCard.add(btnDeleteAccount, gbc);

        contentPanel.add(profileCard);

        return contentPanel;
    }

    private JTextField createProfileField(String text) {

        JTextField field = new JTextField();

        field.setText(text);
        field.setEditable(false);
        field.setHorizontalAlignment(SwingConstants.CENTER);
        field.setFont(Fonts.Regular.deriveFont(13f));
        field.setForeground(Colors.BLACK_TEXT_COLOR);
        field.setBackground(Color.WHITE);

        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Colors.BORDER_GRAY, 1),
                new EmptyBorder(6, 10, 6, 10)
        )
        );

        field.setPreferredSize(new Dimension(320, 38));

        return field;
    }

    private Image createAvatarImage() {

        int size = 100;
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = image.createGraphics();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        g2.setColor(Color.BLACK);
        g2.fillOval(0, 0, size, size);
        g2.setColor(Colors.LIGHT_GREY_BACKGROUND_COLOR);
        g2.fillOval(30, 15, 40, 40);
        g2.fillArc(15, 50, 70, 55, 0, 180);
        g2.dispose();

        return image;
    }

    private void loadUserProfileData() {
        ProfileDAO profileDAO = new ProfileDAO();
        java.util.Map<String, String> userData = profileDAO.getUserProfile(currentUser.getPersonId());

        if (!userData.isEmpty()) {
            txtFullName.setText(userData.getOrDefault("fullName", "N/A"));
            txtEmail.setText(userData.getOrDefault("email", "N/A"));
            txtRole.setText(userData.getOrDefault("role", "Student"));
        } else {
            JOptionPane.showMessageDialog(this, "Could not load user data.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void confirmAndDeleteAccount() {
        int choice = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete your account? This action cannot be undone.",
                "Confirm Account Deletion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (choice == JOptionPane.YES_OPTION) {
            ProfileDAO profileDAO = new ProfileDAO();
            boolean success = profileDAO.deleteUserAccount(currentUser.getPersonId());

            if (success) {
                JOptionPane.showMessageDialog(this, "Account successfully deleted.", "Account Removed", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                new LogInWindow().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete account. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

}
