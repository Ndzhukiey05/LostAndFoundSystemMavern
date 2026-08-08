//240822757
package windows;

import components.PageHeaderPanel;
import components.SideBarPanel;
import components.UIComponents;
import constants.Colors;
import constants.Fonts;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Cursor;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ProfileWindow extends JFrame {

    public ProfileWindow() {
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

        SideBarPanel sidebarPanel = new SideBarPanel();

        JPanel center = new JPanel(new BorderLayout(15, 15));
        center.setOpaque(false);

        PageHeaderPanel headerPanel = new PageHeaderPanel("PROFILE");

        center.add(headerPanel, BorderLayout.NORTH);
        center.add(createProfilePanel(), BorderLayout.CENTER);

        add(sidebarPanel, BorderLayout.WEST);
        add(center, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createProfilePanel() {

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(Colors.MOCKUP_FORM_CARD_BG);
        contentPanel.setBorder(
                new EmptyBorder(
                        25,
                        30,
                        25,
                        30
                )
        );

        UIComponents.RoundedPanel profileCard =
                new UIComponents.RoundedPanel(
                        20,
                        Colors.LIGHT_GREY_BACKGROUND_COLOR
                );

        profileCard.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel lblAvatar =
                new JLabel(
                        new ImageIcon(createAvatarImage()),
                        SwingConstants.CENTER
                );

        gbc.gridy = 0;

        profileCard.add(
                lblAvatar,
                gbc
        );

        UIComponents.RoundedButton btnEditProfile =
                new UIComponents.RoundedButton(
                        "Edit Profile",
                        Colors.BLUE_BUTTON_COLOR,
                        Colors.WHITE_TEXT_COLOR,
                        15
                );

        btnEditProfile.setPreferredSize(
                new Dimension(
                        130,
                        35
                )
        );

        btnEditProfile.setFont(
                Fonts.Bold.deriveFont(13f)
        );

        btnEditProfile.setFocusPainted(false);

        btnEditProfile.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        btnEditProfile.addActionListener(e -> {

            dispose();

            new EditProfileWindow();

        });

        gbc.gridy = 1;

        profileCard.add(
                btnEditProfile,
                gbc
        );

        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.weightx = 1.0;

        gbc.gridy = 2;

        profileCard.add(
                createProfileField(
                        "John Doe"
                ),
                gbc
        );

        gbc.gridy = 3;

        profileCard.add(
                createProfileField(
                        "johndoe123@gmail.com"
                ),
                gbc
        );

        gbc.gridy = 4;

        profileCard.add(
                createProfileField(
                        "Student"
                ),
                gbc
        );

        UIComponents.RoundedButton btnChangePassword =
                new UIComponents.RoundedButton(
                        "Change Password?",
                        Colors.WHITE_TEXT_COLOR,
                        Colors.BLACK_TEXT_COLOR,
                        15
                );

        btnChangePassword.setPreferredSize(
                new Dimension(
                        240,
                        38
                )
        );

        btnChangePassword.setFont(
                Fonts.Regular.deriveFont(13f)
        );

        btnChangePassword.setFocusPainted(false);

        btnChangePassword.setCursor(
                new Cursor(
                        Cursor.HAND_CURSOR
                )
        );

        btnChangePassword.addActionListener(e -> {

            dispose();

            // Uncomment this when ChangePasswordWindow is available
            // new ChangePasswordWindow();

        });

        gbc.gridy = 5;

        profileCard.add(
                btnChangePassword,
                gbc
        );

        contentPanel.add(
                profileCard,
                BorderLayout.CENTER
        );

        return contentPanel;
    }

    private JTextField createProfileField(
            String text
    ) {

        JTextField field =
                new JTextField();

        field.setText(text);

        field.setEditable(false);

        field.setHorizontalAlignment(
                SwingConstants.CENTER
        );

        field.setFont(
                Fonts.Regular.deriveFont(13f)
        );

        field.setForeground(
                Colors.BLACK_TEXT_COLOR
        );

        field.setBackground(
                Color.WHITE
        );

        field.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                Colors.BORDER_GRAY,
                                1
                        ),
                        new EmptyBorder(
                                8,
                                15,
                                8,
                                15
                        )
                )
        );

        field.setPreferredSize(
                new Dimension(
                        240,
                        38
                )
        );

        return field;
    }

    private Image createAvatarImage() {

        int size = 100;

        BufferedImage image =
                new BufferedImage(
                        size,
                        size,
                        BufferedImage.TYPE_INT_ARGB
                );

        Graphics2D g2 =
                image.createGraphics();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        g2.setColor(
                Color.BLACK
        );

        g2.fillOval(
                0,
                0,
                size,
                size
        );

        g2.setColor(
                Colors.LIGHT_GREY_BACKGROUND_COLOR
        );

        g2.fillOval(
                30,
                15,
                40,
                40
        );

        g2.fillArc(815,
                50,
                70,
                60,
                0,
                180
        );

        g2.dispose();

        return image;
    }
}