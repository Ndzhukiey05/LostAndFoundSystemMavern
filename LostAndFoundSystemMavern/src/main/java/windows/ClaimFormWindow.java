// 221106901

package windows;

import components.PageHeaderPanel;
import components.SideBarPanel;
import components.UIComponents;
import constants.Colors;
import constants.Fonts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class ClaimFormWindow extends JFrame {

    public ClaimFormWindow() {
        super("Campus Finder - Claim Form");
        guiSetUp();
    }

    private void guiSetUp() {
        setTitle("Campus Finder - Claim Form");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        getContentPane().setBackground(new Color(73, 107, 145));
        setLayout(new BorderLayout(15, 15));

        SideBarPanel sidebarPanel = new SideBarPanel();

        JPanel center = new JPanel(new BorderLayout(15, 15));
        center.setOpaque(false);

        PageHeaderPanel headerPanel = new PageHeaderPanel("CLAIM FORM");

        center.add(headerPanel, BorderLayout.NORTH);
        center.add(createContentPanel(), BorderLayout.CENTER);

        add(sidebarPanel, BorderLayout.WEST);
        add(center, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createContentPanel() {
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(new Color(220, 220, 220));
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel lblTitle = new JLabel("Submit a Claim");
        lblTitle.setOpaque(true);
        lblTitle.setBackground(new Color(40, 90, 255));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(Fonts.Bold.deriveFont(16f));
        lblTitle.setBorder(new EmptyBorder(8, 15, 8, 15));

        contentPanel.add(lblTitle, BorderLayout.NORTH);

        JPanel formArea = new JPanel(new GridBagLayout());
        formArea.setBackground(new Color(220, 220, 220));

        UIComponents.RoundedPanel formCard = new UIComponents.RoundedPanel(25, Colors.MOCKUP_FORM_CARD_BG);
        formCard.setLayout(new BoxLayout(formCard, BoxLayout.Y_AXIS));
        formCard.setBorder(new EmptyBorder(30, 45, 30, 45));
        formCard.setPreferredSize(new Dimension(600, 500));
        formCard.setMaximumSize(new Dimension(650, 520));

        JLabel lblDescription = new JLabel("Description :");
        lblDescription.setFont(Fonts.Bold.deriveFont(14f));
        lblDescription.setForeground(Colors.BLACK_TEXT_COLOR);
        lblDescription.setAlignmentX(LEFT_ALIGNMENT);

        JTextArea txtDescription = new JTextArea();
        txtDescription.setFont(Fonts.Regular.deriveFont(13f));
        txtDescription.setForeground(Colors.DASHBOARD_BACKGROUND_COLOR);
        txtDescription.setLineWrap(true);
        txtDescription.setWrapStyleWord(true);
        txtDescription.setBorder(new EmptyBorder(12, 12, 12, 12));
        txtDescription.setText("Exact Description\n(include unique markings)");

        UIComponents.RoundedPanel descriptionWrapper = new UIComponents.RoundedPanel(15, Colors.LOGIN_BACKGROUND_COLOR);
        descriptionWrapper.setLayout(new BorderLayout());
        descriptionWrapper.add(txtDescription, BorderLayout.CENTER);
        descriptionWrapper.setMaximumSize(new Dimension(500, 90));
        descriptionWrapper.setAlignmentX(LEFT_ALIGNMENT);

        JLabel lblLocation = new JLabel("Location Details :");
        lblLocation.setFont(Fonts.Bold.deriveFont(14f));
        lblLocation.setForeground(Colors.BLACK_TEXT_COLOR);
        lblLocation.setAlignmentX(LEFT_ALIGNMENT);

        UIComponents.RoundedTextField txtLocation = new UIComponents.RoundedTextField(20);
        txtLocation.setMaximumSize(new Dimension(500, 38));
        txtLocation.setAlignmentX(LEFT_ALIGNMENT);

        JLabel lblDateTime = new JLabel("Date/Time :");
        lblDateTime.setFont(Fonts.Bold.deriveFont(14f));
        lblDateTime.setForeground(Colors.BLACK_TEXT_COLOR);
        lblDateTime.setAlignmentX(LEFT_ALIGNMENT);

        UIComponents.RoundedTextField txtDateTime = new UIComponents.RoundedTextField(20);
        txtDateTime.setMaximumSize(new Dimension(500, 38));
        txtDateTime.setAlignmentX(LEFT_ALIGNMENT);

        JLabel lblContact = new JLabel("Contact Details :");
        lblContact.setFont(Fonts.Bold.deriveFont(14f));
        lblContact.setForeground(Colors.BLACK_TEXT_COLOR);
        lblContact.setAlignmentX(LEFT_ALIGNMENT);

        UIComponents.RoundedTextField txtContact = new UIComponents.RoundedTextField(20);
        txtContact.setMaximumSize(new Dimension(500, 38));
        txtContact.setAlignmentX(LEFT_ALIGNMENT);

        JPanel buttonsRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttonsRow.setOpaque(false);
        buttonsRow.setAlignmentX(LEFT_ALIGNMENT);

        UIComponents.RoundedButton btnBack = new UIComponents.RoundedButton("Back", Colors.BLACK_BUTTON_COLOR, Colors.WHITE_TEXT_COLOR, 20);
        UIComponents.RoundedButton btnClaim = new UIComponents.RoundedButton("Claim", Colors.ACCENT_BLUE_BUTTON, Colors.WHITE_TEXT_COLOR, 20);

        btnBack.setPreferredSize(new Dimension(125, 38));
        btnClaim.setPreferredSize(new Dimension(125, 38));

        btnBack.addActionListener(e -> {
            new ClaimWindow();
            dispose();
        });

        btnClaim.addActionListener(e -> {
            if (txtLocation.getText().trim().isEmpty() || txtDateTime.getText().trim().isEmpty() || txtContact.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please complete all fields.", "Incomplete Form", JOptionPane.WARNING_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(this, "Claim submitted successfully!", "Claim Submitted", JOptionPane.INFORMATION_MESSAGE);

            new ClaimWindow();
            dispose();
        });

        buttonsRow.add(btnBack);
        buttonsRow.add(btnClaim);

        formCard.add(lblDescription);
        formCard.add(Box.createRigidArea(new Dimension(0, 6)));
        formCard.add(descriptionWrapper);
        formCard.add(Box.createRigidArea(new Dimension(0, 15)));

        formCard.add(lblLocation);
        formCard.add(Box.createRigidArea(new Dimension(0, 6)));
        formCard.add(txtLocation);
        formCard.add(Box.createRigidArea(new Dimension(0, 15)));

        formCard.add(lblDateTime);
        formCard.add(Box.createRigidArea(new Dimension(0, 6)));
        formCard.add(txtDateTime);
        formCard.add(Box.createRigidArea(new Dimension(0, 15)));

        formCard.add(lblContact);
        formCard.add(Box.createRigidArea(new Dimension(0, 6)));
        formCard.add(txtContact);
        formCard.add(Box.createRigidArea(new Dimension(0, 25)));

        formCard.add(buttonsRow);

        formArea.add(formCard);

        contentPanel.add(formArea, BorderLayout.CENTER);

        return contentPanel;
    }
}