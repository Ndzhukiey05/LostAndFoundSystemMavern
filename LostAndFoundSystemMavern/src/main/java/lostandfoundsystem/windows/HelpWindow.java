//231323573

package lostandfoundsystem.windows;

import lostandfoundsystem.components.PageHeaderPanel;
import lostandfoundsystem.components.SideBarPanel;
import lostandfoundsystem.components.UIComponents;
import lostandfoundsystem.constants.Colors;
import lostandfoundsystem.constants.Fonts;

import lostandfoundsystem.domain.User;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class HelpWindow extends JFrame {
    
    private User currentUser;

    public HelpWindow(User currentUser) {
        this.currentUser = currentUser;
        super("Campus Finder - Help");
        guiSetUp();
    }

    private void guiSetUp() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(Colors.DARK_BLUE_TEXT_COLOR);
        setLayout(new BorderLayout(15, 15));

        SideBarPanel sidebarPanel = new SideBarPanel(currentUser);

        JPanel center = new JPanel(new BorderLayout(15, 15));
        center.setOpaque(false);

        PageHeaderPanel headerPanel = new PageHeaderPanel("HELP", currentUser);

        center.add(headerPanel, BorderLayout.NORTH);
        center.add(createContentPanel(), BorderLayout.CENTER);

        add(sidebarPanel, BorderLayout.WEST);
        add(center, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createContentPanel() {
        JPanel contentPanel = new JPanel(new BorderLayout(20, 20));
        contentPanel.setBackground(Colors.MOCKUP_FORM_CARD_BG);
        contentPanel.setBorder(new EmptyBorder(25, 30, 25, 30));

        UIComponents.RoundedPanel descriptionCard = new UIComponents.RoundedPanel(20, Colors.LOGIN_BACKGROUND_COLOR);
        descriptionCard.setLayout(new BorderLayout());
        descriptionCard.setBorder(new EmptyBorder(20, 25, 20, 25));

        JLabel descriptionTitle = new JLabel("Lost & Found System – Helping You Recover What Matters");
        descriptionTitle.setFont(Fonts.Bold.deriveFont(18f));
        descriptionTitle.setForeground(Colors.DARK_BLUE_TEXT_COLOR);

        JTextArea description = new JTextArea(
                "Our Lost & Found System is designed to make it easier for students and staff "
                + "to report, search and claim items lost across campus.\n\n"
                + "Whether you've misplaced your student card, left your laptop behind, "
                + "or discovered someone's belongings, this platform ensures a secure and "
                + "organized recovery process."
        );

        description.setEditable(false);
        description.setWrapStyleWord(true);
        description.setLineWrap(true);
        description.setFont(Fonts.Regular.deriveFont(14f));
        description.setForeground(Colors.BLACK_TEXT_COLOR);
        description.setBackground(Colors.LOGIN_BACKGROUND_COLOR);
        description.setBorder(new EmptyBorder(10, 0, 0, 0));

        descriptionCard.add(descriptionTitle, BorderLayout.NORTH);
        descriptionCard.add(description, BorderLayout.CENTER);

        contentPanel.add(descriptionCard, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        bottomPanel.setOpaque(false);

        bottomPanel.add(createFaqPanel());
        bottomPanel.add(createInformationPanel());

        contentPanel.add(bottomPanel, BorderLayout.CENTER);

        return contentPanel;
    }

    private JPanel createFaqPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);

        JLabel title = new JLabel("Frequently Asked Questions");
        title.setFont(Fonts.Bold.deriveFont(20f));
        title.setForeground(Colors.DARK_BLUE_TEXT_COLOR);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(title);
        panel.add(Box.createVerticalStrut(15));

        panel.add(createQuestion(
                "How do I report a lost item?",
                "Select 'Report Lost Item' from the sidebar and complete the form with "
                + "the item's details, the date it was lost, and where it was last seen."
        ));

        panel.add(Box.createVerticalStrut(12));

        panel.add(createQuestion(
                "How do I report a discovered item?",
                "Navigate to 'Report Found Item' in the side menu. Provide a description, "
                + "approximate the location, and upload a clear photo. The system will "
                + "review and catalog the entry within a short time."
        ));

        panel.add(Box.createVerticalStrut(12));

        panel.add(createQuestion(
                "What is the verification process for claims?",
                "Claims go through three checks: description matching, visual confirmation, "
                + "and proof of ownership. Once you submit a claim, the original finder "
                + "may be asked to confirm details."
        ));

        panel.add(Box.createVerticalStrut(12));

        panel.add(createQuestion(
                "How long are items retained in the archives?",
                "Standard items are held for 90 days. High-value electronics and official "
                + "documents can be stored securely for up to 180 days before being "
                + "processed according to policy."
        ));

        return panel;
    }

    private JPanel createQuestion(String question, String answer) {
        UIComponents.RoundedPanel panel = new UIComponents.RoundedPanel(
                15,
                Colors.LOGIN_BACKGROUND_COLOR
        );

        panel.setLayout(new BorderLayout());
        panel.setBorder(new LineBorder(Colors.BORDER_GRAY, 1));

        JLabel lblQuestion = new JLabel("<html><b>" + question + "</b></html>");

        lblQuestion.setFont(Fonts.Bold.deriveFont(14f));
        lblQuestion.setForeground(Colors.DARK_BLUE_TEXT_COLOR);
        lblQuestion.setBorder(new EmptyBorder(10, 12, 5, 12));

        JTextArea txtAnswer = new JTextArea(answer);

        txtAnswer.setEditable(false);
        txtAnswer.setWrapStyleWord(true);
        txtAnswer.setLineWrap(true);
        txtAnswer.setFont(Fonts.Regular.deriveFont(13f));
        txtAnswer.setForeground(Colors.BLACK_TEXT_COLOR);
        txtAnswer.setBackground(Colors.LOGIN_BACKGROUND_COLOR);
        txtAnswer.setBorder(new EmptyBorder(0, 12, 12, 12));

        panel.add(lblQuestion, BorderLayout.NORTH);
        panel.add(txtAnswer, BorderLayout.CENTER);

        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));

        return panel;
    }

    private JPanel createInformationPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setOpaque(false);

        UIComponents.RoundedPanel ownershipPanel = new UIComponents.RoundedPanel(
                20,
                Colors.LOGIN_BACKGROUND_COLOR
        );

        ownershipPanel.setLayout(new BorderLayout());
        ownershipPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel ownershipTitle = new JLabel(
                "Ownership Guidelines",
                SwingConstants.CENTER
        );

        ownershipTitle.setFont(Fonts.Bold.deriveFont(19f));
        ownershipTitle.setForeground(Colors.DARK_BLUE_TEXT_COLOR);

        JTextArea ownership = new JTextArea(
                "To claim an item you may be asked to provide:\n\n"
                + "• Student or Staff Card\n\n"
                + "• Receipt or Proof of Purchase\n\n"
                + "• Photos of the Item\n\n"
                + "• Serial Numbers\n\n"
                + "• A Detailed Description"
        );

        ownership.setEditable(false);
        ownership.setWrapStyleWord(true);
        ownership.setLineWrap(true);
        ownership.setFont(Fonts.Regular.deriveFont(14f));
        ownership.setForeground(Colors.BLACK_TEXT_COLOR);
        ownership.setBackground(Colors.LOGIN_BACKGROUND_COLOR);
        ownership.setBorder(new EmptyBorder(15, 5, 5, 5));

        ownershipPanel.add(ownershipTitle, BorderLayout.NORTH);
        ownershipPanel.add(ownership, BorderLayout.CENTER);

        UIComponents.RoundedPanel contactPanel = new UIComponents.RoundedPanel(
                20,
                Colors.LOGIN_BACKGROUND_COLOR
        );

        contactPanel.setLayout(new BorderLayout());
        contactPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel contactTitle = new JLabel(
                "Contact Admin Or Support Team",
                SwingConstants.CENTER
        );

        contactTitle.setFont(Fonts.Bold.deriveFont(19f));
        contactTitle.setForeground(Colors.DARK_BLUE_TEXT_COLOR);

        JTextArea contact = new JTextArea(
                "Admin\n"
                + "info@campusfindr.com\n\n"
                + "Support Team\n"
                + "0633621446"
        );

        contact.setEditable(false);
        contact.setWrapStyleWord(true);
        contact.setLineWrap(true);
        contact.setFont(Fonts.Regular.deriveFont(14f));
        contact.setForeground(Colors.BLACK_TEXT_COLOR);
        contact.setBackground(Colors.LOGIN_BACKGROUND_COLOR);
        contact.setBorder(new EmptyBorder(15, 5, 5, 5));

        contactPanel.add(contactTitle, BorderLayout.NORTH);
        contactPanel.add(contact, BorderLayout.CENTER);

        JButton btnAdminSupport = new JButton("Contact Admin Support");

        btnAdminSupport.setFont(Fonts.Bold.deriveFont(14f));
        btnAdminSupport.setBackground(Colors.DARK_BLUE_TEXT_COLOR);
        btnAdminSupport.setForeground(Color.WHITE);
        btnAdminSupport.setFocusPainted(false);
        btnAdminSupport.setBorderPainted(false);
        btnAdminSupport.setPreferredSize(new Dimension(220, 40));
        btnAdminSupport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnAdminSupport.addActionListener(e -> {
            AdminSupportWindow window = new AdminSupportWindow(currentUser);
                window.setVisible(true);
                dispose();
        });

        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setOpaque(false);
        buttonPanel.setBorder(new EmptyBorder(10, 0, 0, 0));

        buttonPanel.add(btnAdminSupport, BorderLayout.CENTER);

        contactPanel.add(buttonPanel, BorderLayout.SOUTH);

        panel.add(ownershipPanel);
        panel.add(Box.createVerticalStrut(20));
        panel.add(contactPanel);

        return panel;
    }

}
