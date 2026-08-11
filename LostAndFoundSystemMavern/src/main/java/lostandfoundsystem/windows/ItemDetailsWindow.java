// 221106901
package lostandfoundsystem.windows;

import lostandfoundsystem.components.UIComponents;
import lostandfoundsystem.constants.Colors;
import lostandfoundsystem.constants.Fonts;
import lostandfoundsystem.constants.Icons;

import lostandfoundsystem.domain.User;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class ItemDetailsWindow extends JFrame {

    private User currentUser;
    
    public ItemDetailsWindow(User currentUser) {
        this.currentUser = currentUser;
        super("Campus Finder - Item Details");
        guiSetUp();
    }

    private void guiSetUp() {

        setTitle("Campus Finder - Item Details");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel backgroundPanel = new JPanel(new GridBagLayout());
        backgroundPanel.setBackground(Colors.DARK_BLUE_TEXT_COLOR);
        backgroundPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        setContentPane(backgroundPanel);

        JPanel mainContainer = new JPanel();
        mainContainer.setLayout(new javax.swing.BoxLayout(mainContainer, javax.swing.BoxLayout.Y_AXIS));
        mainContainer.setOpaque(false);
        mainContainer.setPreferredSize(new Dimension(450, 650));

        JLabel lblTitle = new JLabel("ITEM DETAILS");
        lblTitle.setFont(Fonts.Bold.deriveFont(22f));
        lblTitle.setForeground(Colors.WHITE_TEXT_COLOR);
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainContainer.add(lblTitle);
        mainContainer.add(Box.createRigidArea(new Dimension(0, 15)));

        JLabel lblItemName = new JLabel("Item Name");
        styleSectionLabel(lblItemName);

        UIComponents.RoundedTextField txtItemName = new UIComponents.RoundedTextField(20);
        txtItemName.setText("e.g MacBook 14 Pro Max");
        styleCenteredTextField(txtItemName);

        mainContainer.add(lblItemName);
        mainContainer.add(Box.createRigidArea(new Dimension(0, 5)));
        mainContainer.add(txtItemName);
        mainContainer.add(Box.createRigidArea(new Dimension(0, 12)));

        JLabel lblCategory = new JLabel("Category");
        styleSectionLabel(lblCategory);

        UIComponents.RoundedTextField txtCategory = new UIComponents.RoundedTextField(20);
        txtCategory.setText("e.g Electronics");
        styleCenteredTextField(txtCategory);

        mainContainer.add(lblCategory);
        mainContainer.add(Box.createRigidArea(new Dimension(0, 5)));
        mainContainer.add(txtCategory);
        mainContainer.add(Box.createRigidArea(new Dimension(0, 12)));

        JLabel lblImage = new JLabel("Image");
        styleSectionLabel(lblImage);

        UIComponents.RoundedPanel imagePanel = new UIComponents.RoundedPanel(
                20,
                Colors.LOGIN_BACKGROUND_COLOR
        );

        imagePanel.setLayout(
                new javax.swing.BoxLayout(
                        imagePanel,
                        javax.swing.BoxLayout.Y_AXIS
                )
        );

        imagePanel.setMaximumSize(new Dimension(400, 90));
        imagePanel.setPreferredSize(new Dimension(400, 90));
        imagePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        imagePanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel lblImageText = new JLabel("e.g image display");
        lblImageText.setFont(Fonts.Regular.deriveFont(12f));
        lblImageText.setForeground(Colors.DASHBOARD_BACKGROUND_COLOR);
        lblImageText.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblImageIcon = new JLabel(Icons.ViewAllPosts);
        lblImageIcon.setAlignmentX(Component.CENTER_ALIGNMENT);

        imagePanel.add(lblImageText);
        imagePanel.add(Box.createRigidArea(new Dimension(0, 5)));
        imagePanel.add(lblImageIcon);

        mainContainer.add(lblImage);
        mainContainer.add(Box.createRigidArea(new Dimension(0, 5)));
        mainContainer.add(imagePanel);
        mainContainer.add(Box.createRigidArea(new Dimension(0, 12)));

        JLabel lblDescription = new JLabel("Item Description");
        styleSectionLabel(lblDescription);

        UIComponents.RoundedPanel descPanel = new UIComponents.RoundedPanel(
                20,
                Colors.LOGIN_BACKGROUND_COLOR
        );

        descPanel.setLayout(new BorderLayout());
        descPanel.setMaximumSize(new Dimension(400, 100));
        descPanel.setPreferredSize(new Dimension(400, 100));
        descPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        descPanel.setBorder(new EmptyBorder(15, 20, 15, 20));

        JTextArea txtDescription = new JTextArea(
                "e.g Description of unique and\n"
                + "specific contents about the Item"
        );

        txtDescription.setFont(Fonts.Regular.deriveFont(12f));
        txtDescription.setForeground(Colors.DASHBOARD_BACKGROUND_COLOR);
        txtDescription.setLineWrap(true);
        txtDescription.setWrapStyleWord(true);
        txtDescription.setOpaque(false);
        txtDescription.setEditable(false);

        descPanel.add(txtDescription, BorderLayout.CENTER);

        mainContainer.add(lblDescription);
        mainContainer.add(Box.createRigidArea(new Dimension(0, 5)));
        mainContainer.add(descPanel);
        mainContainer.add(Box.createRigidArea(new Dimension(0, 12)));

        JLabel lblStatus = new JLabel("Status");
        styleSectionLabel(lblStatus);

        UIComponents.RoundedTextField txtStatus = new UIComponents.RoundedTextField(20);
        txtStatus.setText("e.g Pending or Claimed");
        styleCenteredTextField(txtStatus);

        mainContainer.add(lblStatus);
        mainContainer.add(Box.createRigidArea(new Dimension(0, 5)));
        mainContainer.add(txtStatus);
        mainContainer.add(Box.createRigidArea(new Dimension(0, 20)));

        JPanel buttonsRow = new JPanel(
                new FlowLayout(
                        FlowLayout.CENTER,
                        20,
                        0
                )
        );

        buttonsRow.setOpaque(false);
        buttonsRow.setAlignmentX(Component.CENTER_ALIGNMENT);

        UIComponents.RoundedButton btnBack =
                new UIComponents.RoundedButton(
                        "Back",
                        Colors.GREY_BUTTON_COLOR,
                        Colors.BLACK_TEXT_COLOR,
                        20
                );

        UIComponents.RoundedButton btnClaim =
                new UIComponents.RoundedButton(
                        "Claim",
                        Colors.ACCENT_BLUE_BUTTON,
                        Colors.WHITE_TEXT_COLOR,
                        20
                );

        btnBack.setPreferredSize(new Dimension(130, 38));
        btnClaim.setPreferredSize(new Dimension(130, 38));

        btnBack.addActionListener(e -> {
            new ClaimWindow(currentUser);
            dispose();
        });

        btnClaim.addActionListener(e -> {
            new ClaimFormWindow(currentUser);
            dispose();
        });

        buttonsRow.add(btnBack);
        buttonsRow.add(btnClaim);

        mainContainer.add(buttonsRow);

        backgroundPanel.add(mainContainer);

        setVisible(true);
    }

    private void styleSectionLabel(JLabel label) {
        label.setFont(Fonts.Medium.deriveFont(15f));
        label.setForeground(Colors.WHITE_TEXT_COLOR);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void styleCenteredTextField(
            UIComponents.RoundedTextField textField
    ) {
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setForeground(Colors.DASHBOARD_BACKGROUND_COLOR);
        textField.setMaximumSize(new Dimension(400, 36));
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        textField.setEditable(false);
    }

    /*
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ItemDetailsWindow::new);
    }
    */
}