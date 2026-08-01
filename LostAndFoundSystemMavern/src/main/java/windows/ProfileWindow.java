//240822757
package windows;

//import java.awt.BorderLayout;
//import java.awt.FlowLayout;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
import constants.Colors;
import constants.Fonts;
import constants.Icons;
import constants.UIComponents;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ProfileWindow extends JFrame {

//    private JPanel northPanel;
//    private JLabel title;
    public ProfileWindow() {
        //        title = new JLabel("Profile Window");
        //        northPanel = new JPanel();
        //
        //        guiSetUp();
        setTitle("Profile Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        // Full screen setup
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(950, 600));

        JPanel rootPanel = new JPanel(new BorderLayout());
        rootPanel.setBackground(Colors.MAIN_BACKGROUND_COLOR);
        rootPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        // Sidebar
        UIComponents.RoundedPanel sidebar = new UIComponents.RoundedPanel(20, Colors.SIDEBAR_COLOR);
        sidebar.setPreferredSize(new Dimension(220, 0));
        sidebar.setLayout(new BorderLayout());
        sidebar.setBorder(new EmptyBorder(15, 15, 15, 15));

        JPanel navPanel = new JPanel();
        navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.Y_AXIS));
        navPanel.setOpaque(false);

        JLabel lblLogo = new JLabel("PROFILE");
        lblLogo.setFont(Fonts.Bold != null ? Fonts.Bold.deriveFont(18f) : new Font("SansSerif", Font.BOLD, 18));
        lblLogo.setForeground(Colors.DARK_BLUE_TEXT_COLOR);
        lblLogo.setBorder(new EmptyBorder(5, 5, 20, 5));
        navPanel.add(lblLogo);

        lblLogo.setCursor(new Cursor(Cursor.HAND_CURSOR));

        lblLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                ProfileWindow profileWindow = new ProfileWindow();
                profileWindow.setVisible(true);
                dispose(); // Closes the Dashboard
            }
        });

        navPanel.add(createSidebarButton("Report Lost Item", Icons.LostItem, e -> {
            dispose();
            new ReportLostItemWindow().setVisible(true);
        }));

        navPanel.add(createSidebarButton("Report Found Item", Icons.FoundItem, e -> {
            dispose();
            new ReportFoundItemWindow().setVisible(true);
        }));

        navPanel.add(createSidebarButton("View All Posts", Icons.ViewAllPosts, e -> {
            dispose();
            new ViewAllPostsWindow().setVisible(true);
        }));

        navPanel.add(createSidebarButton("Claims", Icons.Claims, e -> {
            dispose();
            new ClaimWindow().setVisible(true);
        }));

        navPanel.add(createSidebarButton("Help", Icons.Claims, e -> {
            dispose();
            new HelpWindow().setVisible(true);
        }));

        sidebar.add(navPanel, BorderLayout.CENTER);

        JButton btnLogout = new JButton("Logout", Icons.Home);
        btnLogout.setFont(Fonts.SemiBold != null ? Fonts.SemiBold.deriveFont(13f) : new Font("SansSerif", Font.PLAIN, 13));
        btnLogout.setFocusPainted(false);
        btnLogout.setContentAreaFilled(false);
        btnLogout.setBorderPainted(false);
        btnLogout.setHorizontalAlignment(SwingConstants.LEFT);
        btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogout.addActionListener(e -> JOptionPane.showMessageDialog(this, "Logged out."));
        sidebar.add(btnLogout, BorderLayout.SOUTH);

        // Right Main Panel
        JPanel mainContent = new JPanel(new BorderLayout(0, 15));
        mainContent.setOpaque(false);
        mainContent.setBorder(new EmptyBorder(0, 15, 0, 0));

        // Top Navigation Bar
        UIComponents.RoundedPanel header = new UIComponents.RoundedPanel(20, Colors.HEADER_COLOR);
        header.setPreferredSize(new Dimension(0, 50));
        header.setLayout(new BorderLayout());
        header.setBorder(new EmptyBorder(5, 15, 5, 15));

        JLabel lblHeaderTitle = new JLabel("PROFILE");
        lblHeaderTitle.setFont(Fonts.Bold != null ? Fonts.Bold.deriveFont(16f) : new Font("SansSerif", Font.BOLD, 16));
        lblHeaderTitle.setForeground(Colors.DARK_BLUE_TEXT_COLOR);

        JPanel iconGroup = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        iconGroup.setOpaque(false);

        JButton btnHome = new JButton(Icons.Home);
        btnHome.setBorderPainted(false);
        btnHome.setContentAreaFilled(false);
        JButton btnSearch = new JButton(Icons.Search);
        btnSearch.setBorderPainted(false);
        btnSearch.setContentAreaFilled(false);
        JButton btnBell = new JButton(Icons.Bell);
        btnBell.setBorderPainted(false);
        btnBell.setContentAreaFilled(false);

        iconGroup.add(btnHome);
        iconGroup.add(btnSearch);
        iconGroup.add(btnBell);

        header.add(lblHeaderTitle, BorderLayout.WEST);
        header.add(iconGroup, BorderLayout.EAST);

        // Profile Details Card
        UIComponents.RoundedPanel cardPanel = new UIComponents.RoundedPanel(20, Colors.LIGHT_GREY_BACKGROUND_COLOR);
        cardPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Avatar Icon
        JLabel lblAvatar = new JLabel(new ImageIcon(createAvatarImage()), SwingConstants.CENTER);
        gbc.gridy = 0;
        cardPanel.add(lblAvatar, gbc);

        // Edit Profile Button (Wider size so text displays fully + disposes current window)
        UIComponents.RoundedButton btnEditProfile = new UIComponents.RoundedButton("Edit Profile", Colors.BLUE_BUTTON_COLOR, Colors.WHITE_TEXT_COLOR, 15);
        btnEditProfile.setPreferredSize(new Dimension(130, 32));
        btnEditProfile.addActionListener(e -> {
            dispose(); // Dispose current ProfileWindow
            new EditProfileWindow().setVisible(true);
        });
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        cardPanel.add(btnEditProfile, gbc);

        // Info Displays (Updated placeholders)
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 2;
        cardPanel.add(createReadOnlyField("Your Full Name"), gbc);
        gbc.gridy = 3;
        cardPanel.add(createReadOnlyField("Email Address"), gbc);
        gbc.gridy = 4;
        cardPanel.add(createReadOnlyField("Your Role"), gbc);

        // Change Password Button (Directs to ChangePasswordWindow)
        UIComponents.RoundedButton btnChangePass = new UIComponents.RoundedButton("Change Password?", Colors.WHITE_TEXT_COLOR, Colors.BLACK_TEXT_COLOR, 15);
        btnChangePass.setPreferredSize(new Dimension(220, 35));
        btnChangePass.addActionListener(e -> {
            dispose();
            //new ChangePasswordWindow().setVisible(true);
        });
        gbc.gridy = 5;
        cardPanel.add(btnChangePass, gbc);

        mainContent.add(header, BorderLayout.NORTH);
        mainContent.add(cardPanel, BorderLayout.CENTER);

        rootPanel.add(sidebar, BorderLayout.WEST);
        rootPanel.add(mainContent, BorderLayout.CENTER);

        add(rootPanel);
    }

    private JButton createSidebarButton(String title, Icon icon, java.awt.event.ActionListener action) {
        JButton btn = new JButton(title, icon);
        btn.setFont(Fonts.Regular != null ? Fonts.Regular.deriveFont(13f) : new Font("SansSerif", Font.PLAIN, 13));
        btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setMaximumSize(new Dimension(180, 35));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        if (action != null) {
            btn.addActionListener(action);
        }
        return btn;
    }

    private JTextField createReadOnlyField(String text) {
        UIComponents.RoundedTextField tf = new UIComponents.RoundedTextField(18);
        tf.setText(text);
        tf.setEditable(false);
        tf.setHorizontalAlignment(JTextField.CENTER);
        return tf;
    }

    private Image createAvatarImage() {
        int size = 80;
        java.awt.image.BufferedImage img = new java.awt.image.BufferedImage(size, size, java.awt.image.BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.BLACK);
        g2.fillOval(0, 0, size, size);
        g2.setColor(Colors.LIGHT_GREY_BACKGROUND_COLOR);
        g2.fillOval(25, 15, 30, 30);
        g2.fillArc(10, 45, 60, 50, 0, 180);
        g2.dispose();
        return img;
    }
}
