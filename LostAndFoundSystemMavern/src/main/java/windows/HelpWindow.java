//231323573

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package windows;

/**
 *
 * @author 231323573
 */

//import constants.Fonts;
//import constants.Icons;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class HelpWindow extends JFrame {

    private JPanel sidebarPanel;
    private JPanel topPanel;
    private JPanel contentPanel;

    private JLabel lblTitle;

    public HelpWindow() {
        guiSetUp();
    }

    private void guiSetUp() {

        setSize(1400, 800);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().setBackground(new Color(61, 98, 133));
        setLayout(new BorderLayout(15, 15));

        sidebarPanel = createSidebar();
        topPanel = createTopPanel();
        contentPanel = createContentPanel();

        JPanel center = new JPanel(new BorderLayout(15, 15));
        center.setOpaque(false);

        center.add(topPanel, BorderLayout.NORTH);
        center.add(contentPanel, BorderLayout.CENTER);

        add(sidebarPanel, BorderLayout.WEST);
        add(center, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel createSidebar() {

        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(240, 0));
        panel.setBackground(Color.WHITE);

        JLabel profile = new JLabel("PROFILE");
        //profile.setFont(Fonts.Bold.deriveFont(24f));
        profile.setBorder(new EmptyBorder(20,20,20,20));

        JPanel menu = new JPanel();
        menu.setOpaque(false);
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));

        String[] items = {
                "Report Lost Item",
                "Report Found Item",
                "View All Posts",
                "Claims",
                "Help"
        };

        for(String item : items){

            JButton button = new JButton(item);
            button.setFocusPainted(false);
            button.setBorderPainted(false);
            button.setBackground(Color.WHITE);
            button.setHorizontalAlignment(SwingConstants.LEFT);
            button.setMaximumSize(new Dimension(220,40));

            if(item.equals("Help")){
                button.setBackground(new Color(230,230,230));
            }

            menu.add(button);
        }

        JButton logout = new JButton("Logout");
        logout.setFocusPainted(false);

        panel.add(profile, BorderLayout.NORTH);
        panel.add(menu, BorderLayout.CENTER);
        panel.add(logout, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createTopPanel(){

        JPanel top = new JPanel();
        top.setOpaque(false);
        top.setLayout(new BoxLayout(top, BoxLayout.Y_AXIS));

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titlePanel.setBackground(Color.WHITE);

        lblTitle = new JLabel("Help");
//        lblTitle.setFont(Fonts.Bold.deriveFont(30f));

        titlePanel.add(lblTitle);

//        JPanel nav = new JPanel(new BorderLayout());
//        nav.setBackground(Color.WHITE);
//        nav.setPreferredSize(new Dimension(0,60));

//        JButton btnHome = new JButton(Icons.Home);
//        JButton btnSearch = new JButton(Icons.Search);
//        JButton btnBell = new JButton(Icons.Bell);

        JPanel right = new JPanel();
        right.setOpaque(false);

//        right.add(btnSearch);
//        right.add(btnBell);
//
//        nav.add(btnHome, BorderLayout.WEST);
//        nav.add(right, BorderLayout.EAST);

        top.add(titlePanel);
        top.add(Box.createVerticalStrut(10));
//        top.add(nav);

        return top;
    }
    
    private JPanel createContentPanel() {

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setBorder(new EmptyBorder(20,20,20,20));
        panel.setLayout(new BorderLayout(20,20));

        Color cardColor = new Color(220,233,245);

        //================ Description ================

        JTextArea description = new JTextArea(
                "Lost & Found System – Helping You Recover What Matters\n\n"
              + "Our Lost & Found System is "
              + "designed to make is easier for students and staff report, search and claim items "
//              + "lost property across campus.\n\n"
              + "Whether you've misplaced your student card, left your "
              + "laptop behind, or discovered someone's belongings, "
              + "thus platform ensures a secure and organized recovery process."
//              + "claimed through a simple verification process.\n\n"
//              + "The goal of this system is to reduce the number of permanently "
//              + "lost belongings while creating a safe and organized Lost & "
//              + "Found service for everyone."
        );

        description.setEditable(false);
        description.setWrapStyleWord(true);
        description.setLineWrap(true);
        description.setBackground(cardColor);
        description.setFont(new Font("Arial",Font.PLAIN,16));
        description.setBorder(new EmptyBorder(20,20,20,20));

        panel.add(description,BorderLayout.NORTH);

        //================ Bottom Panels ================

        JPanel bottom = new JPanel(new GridLayout(1,2,20,20));
        bottom.setOpaque(false);

        //================ FAQ =================

        JPanel faqPanel = new JPanel();
        faqPanel.setOpaque(false);
        faqPanel.setLayout(new BoxLayout(faqPanel,BoxLayout.Y_AXIS));

        JLabel faqTitle = new JLabel("Frequently Asked Questions");
        faqTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        faqTitle.setForeground(Color.WHITE);
        faqTitle.setFont(new Font("Arial",Font.BOLD,24));

        faqPanel.add(faqTitle);
        faqPanel.add(Box.createVerticalStrut(15));

        faqPanel.add(createQuestion(
                "How do I report a lost item?",
                "Select 'Report Lost Item' from the sidebar and complete the form with the item's details, the date it was lost, and where it was last seen."
        ));

        faqPanel.add(Box.createVerticalStrut(15));

        faqPanel.add(createQuestion(
                "How do I report a discovered item?",
                "Navigate to 'REPORT FOUND ITEM' in the side menu. Provide a description, approximate the location, and upload a clear photo. The system will review and catalog the entry within a short time."
        ));

        faqPanel.add(Box.createVerticalStrut(15));

        faqPanel.add(createQuestion(
                "What is the verification process for claims?",
                "Claims go through three checks: description matching, visual confirmation, and proof of ownership. Once you submit a claim, the original finder may be asked to confirm details."
        ));

        faqPanel.add(Box.createVerticalStrut(15));

        faqPanel.add(createQuestion(
                "How long are items retained in the archives?",
                "Standard items are held for 90 days. High-value electronics and official documents can be stored securely for up to 180 days before being processed according to policy."
        ));

        //================ Right Panel =================

        JPanel rightPanel = new JPanel();
        rightPanel.setOpaque(false);
        rightPanel.setLayout(new BoxLayout(rightPanel,BoxLayout.Y_AXIS));

        JLabel ownershipTitle = new JLabel("Ownership Guidelines");
        ownershipTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        ownershipTitle.setForeground(Color.WHITE);
        ownershipTitle.setFont(new Font("Arial",Font.BOLD,22));

        JTextArea ownership = new JTextArea(
                "To claim an item you may be asked to provide:\n\n"
              + "• Student or Staff Card\n\n"
              + "• Receipt or Proof of Purchase\n\n"
              + "• Photos of the Item\n\n"
              + "• Serial Numbers\n\n"
              + "• A Detailed Description\n\n"
//              + "Providing accurate information helps prevent fraudulent claims."
        );

        ownership.setEditable(false);
        ownership.setBackground(cardColor);
        ownership.setWrapStyleWord(true);
        ownership.setLineWrap(true);
        ownership.setFont(new Font("Arial",Font.PLAIN,15));
        ownership.setBorder(new EmptyBorder(15,15,15,15));

        JLabel contactTitle = new JLabel("Contact Admin Or Support Team");
        contactTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        contactTitle.setForeground(Color.WHITE);
        contactTitle.setFont(new Font("Arial",Font.BOLD,22));

        JTextArea contact = new JTextArea(
                "Admin\n"
              + "info@campusfindr.com\n\n"
              + "Support Team\n"
              + "0633621446\n\n"
        );

        contact.setEditable(false);
        contact.setBackground(cardColor);
        contact.setWrapStyleWord(true);
        contact.setLineWrap(true);
        contact.setFont(new Font("Arial",Font.PLAIN,15));
        contact.setBorder(new EmptyBorder(15,15,15,15));

        rightPanel.add(ownershipTitle);
        rightPanel.add(Box.createVerticalStrut(10));
        rightPanel.add(ownership);
        rightPanel.add(Box.createVerticalStrut(20));
        rightPanel.add(contactTitle);
        rightPanel.add(Box.createVerticalStrut(10));
        rightPanel.add(contact);

        bottom.add(faqPanel);
        bottom.add(rightPanel);

        panel.add(bottom,BorderLayout.CENTER);

        return panel;
    }
        private JPanel createQuestion(String question, String answer) {

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(220,233,245));
        panel.setBorder(new LineBorder(Color.GRAY));

        JLabel lblQuestion = new JLabel("<html><b>" + question + "</b></html>");
        lblQuestion.setFont(new Font("Arial", Font.BOLD, 15));
        lblQuestion.setBorder(new EmptyBorder(10,10,5,10));

        JTextArea txtAnswer = new JTextArea(answer);
        txtAnswer.setEditable(false);
        txtAnswer.setWrapStyleWord(true);
        txtAnswer.setLineWrap(true);
        txtAnswer.setFont(new Font("Arial", Font.PLAIN, 14));
        txtAnswer.setBackground(new Color(220,233,245));
        txtAnswer.setBorder(new EmptyBorder(0,10,10,10));

        panel.add(lblQuestion, BorderLayout.NORTH);
        panel.add(txtAnswer, BorderLayout.CENTER);

        return panel;
    }

}