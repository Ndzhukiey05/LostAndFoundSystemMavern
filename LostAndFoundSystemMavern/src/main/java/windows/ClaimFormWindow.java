// 221106901
package windows;

import constants.Colors;
import constants.Fonts;
import constants.UIComponents;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class ClaimFormWindow extends JFrame {

    public ClaimFormWindow() {
        super("Campus Finder - Claim Form");
        guiSetUp();
    }

    private void guiSetUp() {
        setTitle("Campus Finder - Claim Form");
        setSize(900, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel backgroundPanel = new JPanel(new GridBagLayout());
        backgroundPanel.setBackground(Colors.DARK_BLUE_TEXT_COLOR);
        backgroundPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        setContentPane(backgroundPanel);

        JPanel mainContainer = new JPanel();
        mainContainer.setLayout(new BoxLayout(mainContainer, BoxLayout.Y_AXIS));
        mainContainer.setOpaque(false);

        //REMEMMBER YOU CHANGED THIS
        // Wrapped lblTitle in a transparent FlowLayout panel to keep the F-ing Claim window centered
        JLabel lblTitle = new JLabel("CLAIM FORM");
        lblTitle.setFont(Fonts.Bold.deriveFont(22f));
        lblTitle.setForeground(Colors.WHITE_TEXT_COLOR);

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        titlePanel.setOpaque(false);
        titlePanel.add(lblTitle);

        mainContainer.add(titlePanel);
        //REMEMBER THIS PART ABOVE

        mainContainer.add(Box.createRigidArea(new Dimension(0, 15)));

        UIComponents.RoundedPanel formCard = new UIComponents.RoundedPanel(25, Colors.MOCKUP_FORM_CARD_BG);
        formCard.setLayout(new BoxLayout(formCard, BoxLayout.Y_AXIS));
        formCard.setBorder(new EmptyBorder(30, 45, 30, 45));
        formCard.setPreferredSize(new Dimension(500, 520));

        // Field 1: Description
        JLabel lblDescription = new JLabel("Description :");
        lblDescription.setFont(Fonts.Bold.deriveFont(14f));
        lblDescription.setForeground(Colors.BLACK_TEXT_COLOR);
        lblDescription.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextArea txtDescription = new JTextArea("Exact Description\n(include unique markings)");
        txtDescription.setFont(Fonts.Regular.deriveFont(13f));
        txtDescription.setForeground(Colors.DASHBOARD_BACKGROUND_COLOR);
        txtDescription.setLineWrap(true);
        txtDescription.setWrapStyleWord(true);
        txtDescription.setBorder(new EmptyBorder(12, 12, 12, 12));

        UIComponents.RoundedPanel descriptionWrapper = new UIComponents.RoundedPanel(15, Colors.LOGIN_BACKGROUND_COLOR);
        descriptionWrapper.setLayout(new BorderLayout());
        descriptionWrapper.add(txtDescription, BorderLayout.CENTER);
        descriptionWrapper.setMaximumSize(new Dimension(410, 90));
        descriptionWrapper.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Field 2: Location
        JLabel lblLocation = new JLabel("Location Details :");
        lblLocation.setFont(Fonts.Bold.deriveFont(14f));
        lblLocation.setForeground(Colors.BLACK_TEXT_COLOR);
        lblLocation.setAlignmentX(Component.LEFT_ALIGNMENT);

        UIComponents.RoundedTextField txtLocation = new UIComponents.RoundedTextField(20);
        txtLocation.setMaximumSize(new Dimension(410, 38));
        txtLocation.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Field 3: Date/Time
        JLabel lblDateTime = new JLabel("Date/Time :");
        lblDateTime.setFont(Fonts.Bold.deriveFont(14f));
        lblDateTime.setForeground(Colors.BLACK_TEXT_COLOR);
        lblDateTime.setAlignmentX(Component.LEFT_ALIGNMENT);

        UIComponents.RoundedTextField txtDateTime = new UIComponents.RoundedTextField(20);
        txtDateTime.setMaximumSize(new Dimension(410, 38));
        txtDateTime.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Field 4: Contact Details
        JLabel lblContact = new JLabel("Contact Details :");
        lblContact.setFont(Fonts.Bold.deriveFont(14f));
        lblContact.setForeground(Colors.BLACK_TEXT_COLOR);
        lblContact.setAlignmentX(Component.LEFT_ALIGNMENT);

        UIComponents.RoundedTextField txtContact = new UIComponents.RoundedTextField(20);
        txtContact.setMaximumSize(new Dimension(410, 38));
        txtContact.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Action Buttons NOT WORKING GUYS DUMMY BUTS
        JPanel buttonsRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 0));
        buttonsRow.setOpaque(false);
        buttonsRow.setAlignmentX(Component.LEFT_ALIGNMENT);
        buttonsRow.setMaximumSize(new Dimension(410, 45));

        
    // I did not make the claim and back btn work
        UIComponents.RoundedButton btnBack = new UIComponents.RoundedButton("Back", Colors.BLACK_BUTTON_COLOR, Colors.WHITE_TEXT_COLOR, 20);
        UIComponents.RoundedButton btnClaim = new UIComponents.RoundedButton("Claim", Colors.ACCENT_BLUE_BUTTON, Colors.WHITE_TEXT_COLOR, 20);

        btnBack.setPreferredSize(new Dimension(125, 38));
        btnClaim.setPreferredSize(new Dimension(125, 38));

        btnBack.addActionListener(e -> {});
        btnClaim.addActionListener(e -> {});
    // ------------------------------------------------------------------------------------------------------------------
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

        mainContainer.add(formCard);
        backgroundPanel.add(mainContainer);

        setVisible(true);
    }
/* This just to view this page only
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ClaimFormWindow::new);
    }*/
    
}